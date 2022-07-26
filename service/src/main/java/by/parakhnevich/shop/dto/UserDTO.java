package by.parakhnevich.shop.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class UserDTO extends AbstractDTO {
    private String username;
    private String password;
}
