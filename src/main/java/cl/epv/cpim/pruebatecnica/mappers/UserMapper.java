package cl.epv.cpim.pruebatecnica.mappers;

import cl.epv.cpim.pruebatecnica.dto.UserDTO;
import cl.epv.cpim.pruebatecnica.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    /**
     *
     * @param entity
     * @return
     */
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phones", source = "phones", ignore = true)
    UserDTO entityToDTO(User entity);

    /**
     *
     * @param dto
     * @return
     */
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phones", source = "phones", ignore = true)
    User dtoToEntity(UserDTO dto);

    /**
     *
     * @param entityList
     * @return
     */
    List<UserDTO> entityListToDTOList(List<User> entityList);

    /**
     *
     * @param dtoList
     * @return
     */
    List<User> dtoListToEntityList(List<UserDTO> dtoList);
}
