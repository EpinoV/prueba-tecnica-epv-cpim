package cl.epv.cpim.pruebatecnica.controller;

import cl.epv.cpim.pruebatecnica.dto.AuthenticationRequestDTO;
import cl.epv.cpim.pruebatecnica.dto.AuthenticationResponseDTO;
import cl.epv.cpim.pruebatecnica.dto.RegisterRequestDTO;
import cl.epv.cpim.pruebatecnica.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpim/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponseDTO> register(
            @RequestBody RegisterRequestDTO request
    ) {
        log.info("Registrando..");


        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping (value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthenticationResponseDTO> authenticate(
            @RequestBody AuthenticationRequestDTO request
    ) {
        log.info("Autenticando..");


        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}