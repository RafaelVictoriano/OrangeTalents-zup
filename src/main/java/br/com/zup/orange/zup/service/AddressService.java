package br.com.zup.orange.zup.service;

import br.com.zup.orange.zup.controllers.form.AddressForm;
import br.com.zup.orange.zup.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private CepClient  client;

    public Address createAddress(String cep) {
        AddressForm address = client.cepService(cep);

       return address.converter();
    }
}
