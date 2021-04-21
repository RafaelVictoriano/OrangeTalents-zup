package br.com.zup.orange.zup.repository;

import br.com.zup.orange.zup.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<Users, Long> {
}
