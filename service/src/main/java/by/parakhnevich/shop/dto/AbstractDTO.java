package by.parakhnevich.shop.dto;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class AbstractDTO {
    private long id;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;
}
