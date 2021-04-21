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
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserRespository userRespository;

    @Autowired
    private AddressRespository addressRespository;


    @GetMapping("/{id}")
    public ResponseEntity<DetailsUsersDto> list(@PathVariable Long id) {
        Optional<Users> user = userRespository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new DetailsUsersDto(user.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsersDto> UsersCadaster(@RequestBody @Valid UserForm form, UriComponentsBuilder uri) {
        Users user = form.converter();
        userRespository.save(user);

        URI uri1 = uri.path("/zup/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri1).body(new UsersDto(user));
    }

    @PostMapping("/address")
    @Transactional
    public ResponseEntity<AddressDto> AddreesCadaster(@RequestBody @Valid AddressForm form, UriComponentsBuilder uri) {
        Address address = form.converter();
        addressRespository.save(address);

        URI uri2 = uri.path("/zup/address/{id}").buildAndExpand(address.getId()).toUri();
        return ResponseEntity.created(uri2).body(new AddressDto(address));
    }

    @PutMapping("/{id}")
    @Transactional //Garantir que ele faça a transação no fim do metodo
    public ResponseEntity<UsersDto> updatte(@PathVariable Long id, @RequestBody @Valid UpdateUserform form) {

        Optional<Users> optinal = userRespository.findById(id);
        if (optinal.isPresent()) {
            Users user = form.update(id, userRespository);
            return ResponseEntity.ok(new UsersDto(user));
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {

        Optional<Users> optinal = userRespository.findById(id);
        if (optinal.isPresent()) {
            userRespository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();

    }

}
