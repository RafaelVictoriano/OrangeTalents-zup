package br.com.zup.orange.zup.controllers.form;

import br.com.zup.orange.zup.models.Address;

import javax.validation.constraints.NotNull;

public class AddressForm {
    @NotNull
    private String logradouro;
    @NotNull
    private Integer numero;
    @NotNull
    private String complemento;
    @NotNull
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
    @NotNull
    private String cep;

    public AddressForm(String logradouro, Integer numero, String complemento, String bairro, String cidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public Address converter(){
        return new Address(this.logradouro, this.numero, this.complemento, this.bairro, this.cidade, this.uf, this.cep);
    }

}
