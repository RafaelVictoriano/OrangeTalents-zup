package br.com.zup.orange.zup.repository;

import br.com.zup.orange.zup.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRespository extends JpaRepository<Address,Long> {
}
