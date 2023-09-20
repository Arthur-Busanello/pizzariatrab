package org.example.Repository;

import org.example.Entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
    Sabor findByNome(String nome);
}
