package cl.epv.cpim.pruebatecnica.service.impl;

import cl.epv.cpim.pruebatecnica.dto.UserDTO;
import cl.epv.cpim.pruebatecnica.repository.UserRepository;
import cl.epv.cpim.pruebatecnica.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
    private UserService service;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new UserServiceImpl(userRepository, passwordEncoder);
    }


    @Test
    void getAllUsers() {
    }

    @Test
    void getAllUsers_empty() {
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>(Collections.emptyList()));

        List<UserDTO> list = service.getAllUsers();

        Assertions.assertThat(list).isEmpty();
    }


    @Test
    void updateUser() {
    }

    @Test
    void newUser() {
    }

    @Test
    void getUser() {
    }

    @Test
    void testGetUser() {
    }

    @Test
    void deleteUser() {
    }
}