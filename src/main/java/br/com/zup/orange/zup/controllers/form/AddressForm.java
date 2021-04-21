package br.com.zup.orange.zup.controllers.form;

import br.com.zup.orange.zup.controllers.dto.AddressDto;
import br.com.zup.orange.zup.models.Address;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddressForm {
    @NotNull
    private String publicPlace;
    @NotNull
    private Integer number;
    @NotNull
    private String complement;
    @NotNull
    private String neighborhoods;
    @NotNull
    private String city;
    @NotNull
    private String state;
    @NotNull
    private String cep;

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setNeighborhoods(String neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Address converter(){
        return new Address(this.publicPlace, this.number, this.complement, this.neighborhoods, this.city, this.state, this.cep);
    }
}
