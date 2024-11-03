package cl.epv.cpim.pruebatecnica.mappers;

import cl.epv.cpim.pruebatecnica.dto.PhoneDTO;
import cl.epv.cpim.pruebatecnica.model.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PhoneMapper {
    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "cityCode", source = "phoneNumber")
    @Mapping(target = "countryCode", source = "phoneNumber")
    PhoneDTO entityToDTO(Phone entity);

    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "cityCode", source = "phoneNumber")
    @Mapping(target = "countryCode", source = "phoneNumber")
    Phone dtoToEntity(PhoneDTO dto);

    List<PhoneDTO> entityListToDTOList(List<Phone> entityList);

    List<Phone> dtoListToEntityList(List<PhoneDTO> dtoList);
}
