package br.com.zup.orange.zup.exception.dto;

public class ErrrorFormDto {
    private String  field;
    private String error;

    public ErrrorFormDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }
}
