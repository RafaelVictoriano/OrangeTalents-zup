package br.com.zup.orange.zup.controllers.dto;

import br.com.zup.orange.zup.models.Address;
import br.com.zup.orange.zup.models.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetailsUsersDto {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate bornDate;
    private List<AddressDto> address;

    public DetailsUsersDto(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.email = users.getEmail();
        this.cpf = users.getCpf();
        this.bornDate = users.getBornDate();
        this.address = new ArrayList<>();
        this.address.addAll(users.getAddress().stream().map(AddressDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public List<AddressDto> getAddress() {
        return address;
    }
}
