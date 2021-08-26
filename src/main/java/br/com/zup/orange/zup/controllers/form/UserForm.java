package br.com.zup.orange.zup.controllers.form;

import br.com.zup.orange.zup.models.Users;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserForm {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @NotBlank @NotEmpty @Length(min = 3) @Length(max = 180)
    private String name;
    @NotBlank @NotEmpty @Email
    private String email;
    @NotBlank @CPF @NotEmpty
    private String cpf;
    @NotBlank @NotEmpty
    private String bornDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public Users convert() {
        return new Users(this.name, this.email, this.cpf, LocalDate.parse(this.bornDate));
    }
}
