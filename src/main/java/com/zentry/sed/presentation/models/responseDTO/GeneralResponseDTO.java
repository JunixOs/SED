package com.zentry.sed.presentation.models.responseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponseDTO<T> {
    private boolean status;
    private String message;
    private T extraDataForResponse;

    public GeneralResponseDTO(
        boolean status,
        String message,
        T extraDataForResponse
    ){
        this.status = status;
        this.message = message;
        this.extraDataForResponse = extraDataForResponse;
    }
}
