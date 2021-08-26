package br.com.zup.orange.zup.controllers;

import br.com.zup.orange.zup.controllers.dto.AddressDto;
import br.com.zup.orange.zup.controllers.dto.DetailsUsersDto;
import br.com.zup.orange.zup.controllers.dto.UsersDto;
import br.com.zup.orange.zup.controllers.form.AddressForm;
import br.com.zup.orange.zup.controllers.form.UpdateUserform;
import br.com.zup.orange.zup.controllers.form.UserForm;
import br.com.zup.orange.zup.models.Address;
import br.com.zup.orange.zup.models.Users;
import br.com.zup.orange.zup.repository.AddressRespository;
import br.com.zup.orange.zup.repository.UserRespository;
import br.com.zup.orange.zup.service.AddressService;
import br.com.zup.orange.zup.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
@RequestMapping("/zup")
public class ApiController {

    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    public ResponseEntity<DetailsUsersDto> listUser(@PathVariable Long id) throws NotFoundException {
        DetailsUsersDto user = userService.listUser(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsersDto> usersRegister(@RequestBody @Valid UserForm form) {
        UsersDto usersDto = userService.usersRegister(form);
        return new ResponseEntity<>(usersDto, HttpStatus.CREATED);
    }


    @PostMapping("/address/{cep}")
    @Transactional
    public ResponseEntity<AddressDto> addressRegister(@PathVariable("cep") String cep) {
        AddressDto addressDto = addressService.addressRegister(cep);
        return new ResponseEntity<>(addressDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsersDto> update(@PathVariable Long id, @RequestBody @Valid UpdateUserform form) throws NotFoundException {
        UsersDto userUpdated = userService.update(id, form);
        return ResponseEntity.ok(userUpdated);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) throws NotFoundException {
        userService.removeUser(id);
        return ResponseEntity.noContent().build();

    }

}
