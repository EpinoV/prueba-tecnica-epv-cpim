package cl.epv.cpim.pruebatecnica.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] AUTH_WHITE_LIST = {
            // -- Swagger UI v2
            "/cpim/doc/v2/api-docs",
            "/cpim/doc/swagger-resources",
            "/cpim/doc/swagger-resources/**",
            "/cpim/doc/configuration/ui",
            "/cpim/doc/configuration/security",
            "/cpim/doc/swagger-ui.html",
            "/cpim/doc/webjars/**",
            // -- Swagger UI v3 (OpenAPI)
            "/cpim/doc/v3/api-docs/**",
            "/cpim/doc/swagger-ui/**",
            "/cpim/doc/**",
            "/cpim/api/v1/auth/**",

            "/swagger-ui/**",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/v2/api-docs",
            "/configuration/ui",
            "/configuration/security"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                //.disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(AUTH_WHITE_LIST).permitAll()  // Permite acceso sin autenticación a rutas públicas
                        .anyRequest().authenticated()               // Requiere autenticación para todas las demás
                )
                /*.authorizeHttpRequests()
                .requestMatchers(
                        AUTH_WHITE_LIST
                )
                .permitAll()
                .anyRequest()
                .authenticated()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                 */
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Configuración de gestión de sesiones
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        return httpSecurity.build();
    }
}