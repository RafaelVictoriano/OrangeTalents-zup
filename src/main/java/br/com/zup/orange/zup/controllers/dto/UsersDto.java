package br.com.zup.orange.zup.controllers.dto;

import br.com.zup.orange.zup.models.Users;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class UsersDto {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate bornDate;

    public UsersDto(Users users) {
        this.id = users.getId();
        this.name = users.getName();
        this.email = users.getEmail();
        this.cpf = users.getCpf();
        this.bornDate = users.getBornDate();
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

    public static List<UsersDto> converter(List<Users> user) {
        return user.stream().map(UsersDto::new).collect(Collectors.toList());
    }
}
