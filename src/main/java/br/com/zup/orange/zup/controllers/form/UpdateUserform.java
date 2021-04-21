package br.com.zup.orange.zup.controllers.form;

import br.com.zup.orange.zup.models.Users;
import br.com.zup.orange.zup.repository.UserRespository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateUserform {

    @NotNull @NotEmpty @Length(min = 5)
    private String name;
    @NotNull @NotEmpty
    private String email;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users update(Long id, UserRespository userRespository){
        Users users = userRespository.getOne(id);

        users.setName(this.name);
        users.setEmail(this.email);

        return users;
    }
}
