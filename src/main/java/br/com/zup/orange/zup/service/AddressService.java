package br.com.zup.orange.zup.service;

import br.com.zup.orange.zup.controllers.dto.AddressDto;
import br.com.zup.orange.zup.controllers.form.AddressForm;
import br.com.zup.orange.zup.models.Address;
import br.com.zup.orange.zup.repository.AddressRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.net.URI;

@Service
public class AddressService {

    @Autowired
    private CepClient client;
    @Autowired
    private AddressRespository addressRespository;


    public Address createAddress(String cep) {
        AddressForm address = client.cepService(cep);
        return address.converter();
    }


    public AddressDto addressRegister(String cep) {
        Address address = this.createAddress(cep);
        addressRespository.save(address);

        return new AddressDto(address);
    }
}
