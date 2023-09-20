package org.example.Repository;

import org.example.Entity.Delivery;
import org.example.Entity.MetodoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByMetodoEntrega (MetodoEntrega metodoEntrega);
}
