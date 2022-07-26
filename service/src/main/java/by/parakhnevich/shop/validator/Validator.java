package by.parakhnevich.shop.validator;

import by.parakhnevich.shop.dto.AbstractDTO;

public interface Validator<T extends AbstractDTO> {
    void validate(T t);
}
