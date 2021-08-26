package br.com.zup.orange.zup.service;

import br.com.zup.orange.zup.controllers.dto.DetailsUsersDto;
import br.com.zup.orange.zup.controllers.dto.UsersDto;
import br.com.zup.orange.zup.controllers.form.UpdateUserform;
import br.com.zup.orange.zup.controllers.form.UserForm;
import br.com.zup.orange.zup.models.Users;
import br.com.zup.orange.zup.repository.UserRespository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRespository userRespository;

    public DetailsUsersDto listUser(Long id) throws NotFoundException {
        Optional<Users> user = userRespository.findById(id);
        if (user.isPresent()) {
            return new DetailsUsersDto(user.get());
        }
        throw new NotFoundException("User not found");
    }

    public UsersDto usersRegister(UserForm form) {
        Users user = form.convert();
        userRespository.save(user);

        return new UsersDto(user);
    }

    public UsersDto update( Long id, UpdateUserform form) throws NotFoundException {
        Optional<Users> user = userRespository.findById(id);
        if (user.isPresent()) {
            Users users = form.update(id, userRespository);
            return new UsersDto(users);
        }
        throw new NotFoundException("User not found");

    }


    public void removeUser(Long id) throws NotFoundException {
        Optional<Users> user = userRespository.findById(id);
        if (user.isPresent()) {
            userRespository.deleteById(id);
        }
        throw new NotFoundException("User not found");
    }



}
