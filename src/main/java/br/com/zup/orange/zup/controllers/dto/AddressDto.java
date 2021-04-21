package br.com.zup.orange.zup.controllers.dto;

import br.com.zup.orange.zup.models.Address;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class AddressDto {

    private Long id;
    private String publicPlace;
    private Integer number;
    private String complement;
    private String neighborhoods;
    private String city;
    private String state;
    private String cep;

    public AddressDto(Address address) {
        this.id = address.getId(); ;
        this.publicPlace = address.getPublicPlace();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.neighborhoods = address.getNeighborhoods();
        this.city = address.getCity();
        this.state = address.getState();
        this.cep = address.getCep();
    }

    public Long getId() {
        return id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhoods() {
        return neighborhoods;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public static List<AddressDto> converter(List<Address> address) {
        return address.stream().map(AddressDto::new).collect(Collectors.toList());
    }
}
