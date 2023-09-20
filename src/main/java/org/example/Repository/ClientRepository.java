package org.example.Repository;

import org.example.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByNome(String name);
    Optional<Client> findById(Long id);

    boolean selectExistisCpf(String cpf);
}
