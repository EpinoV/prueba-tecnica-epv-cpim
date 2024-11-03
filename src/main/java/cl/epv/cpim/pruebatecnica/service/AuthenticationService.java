package cl.epv.cpim.pruebatecnica.service;

import cl.epv.cpim.pruebatecnica.dto.AuthenticationRequestDTO;
import cl.epv.cpim.pruebatecnica.dto.AuthenticationResponseDTO;
import cl.epv.cpim.pruebatecnica.dto.RegisterRequestDTO;

public interface AuthenticationService {
    /**
     *
     * @param request
     * @return
     */
    AuthenticationResponseDTO register(RegisterRequestDTO request);

    /**
     *
     * @param request
     * @return
     */
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
