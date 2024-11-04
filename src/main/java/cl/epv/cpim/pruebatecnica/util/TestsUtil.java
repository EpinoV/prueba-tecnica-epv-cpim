package cl.epv.cpim.pruebatecnica.util;

import cl.epv.cpim.pruebatecnica.dto.UserDTO;
import cl.epv.cpim.pruebatecnica.model.User;

public class TestsUtil {
    public static UserDTO getUserDTO() {
        return UserDTO.builder().userId(1).name("Nombre Test").email("user@user.cl").build();
    }
    public static User getUserModel() {
        return User.builder().userId(1).name("Nombre Test").email("user@user.cl").build();
    }
}
