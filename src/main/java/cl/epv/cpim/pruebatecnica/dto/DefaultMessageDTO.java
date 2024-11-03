package cl.epv.cpim.pruebatecnica.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DefaultMessageDTO {
    @JsonProperty("mensaje")
    private String message;
}
