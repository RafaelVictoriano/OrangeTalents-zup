package br.com.zup.orange.zup.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String publicPlace;
    private Integer number;
    private String complement;
    private String neighborhoods;
    private String city;
    private String state;
    private String cep;

    @ManyToOne(fetch = FetchType.EAGER)
    private Users users;

    public Address(String publicPlace, Integer number, String complement, String neighborhoods, String city, String state, String cep) {
        this.publicPlace = publicPlace;
        this.number = number;
        this.complement = complement;
        this.neighborhoods = neighborhoods;
        this.city = city;
        this.state = state;
        this.cep = cep;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhoods() {
        return neighborhoods;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }

    public Users getUsers() {
        return users;
    }
}

