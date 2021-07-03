package br.com.zup.orange.zup.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private LocalDate bornDate;

    @OneToMany(mappedBy = "users")
    private List<Address> address;

    public Users() {
    }

    public Users(String name, String email, String cpf, LocalDate bornDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.bornDate = bornDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users user = (Users) o;
        return email.equals(user.email) && cpf.equals(user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, cpf);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public List<Address> getAddress() {
        return address;
    }
}
