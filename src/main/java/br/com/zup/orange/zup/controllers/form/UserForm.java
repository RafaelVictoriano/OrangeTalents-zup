package br.com.zup.orange.zup.controllers.form;

import br.com.zup.orange.zup.models.Users;
import br.com.zup.orange.zup.validCpf.CpfValid;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserForm {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @NotNull @NotEmpty @Length(min = 5) @Length(max = 200)
    private String name;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String cpf;
    @Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
    @NotNull
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
    public Users converter(){
        if(CpfValid.isCPF(cpf)){
            return new Users(this.name, this.email, this.cpf, LocalDate.parse(this.bornDate, formatter));
        }
        throw new IllegalArgumentException("Cpf invalido");
    }
}
