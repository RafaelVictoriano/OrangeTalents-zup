package br.com.zup.orange.zup.service;

import br.com.zup.orange.zup.controllers.dto.AddressDto;
import br.com.zup.orange.zup.controllers.form.AddressForm;
import br.com.zup.orange.zup.models.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "viaCep", url="${url-viacep}")
public interface CepClient {

    @GetMapping("/{cep}/json")
    AddressForm cepService(@PathVariable("cep") String cep);
}