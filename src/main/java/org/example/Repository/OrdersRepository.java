package org.example.Repository;

import org.example.Entity.Orders;
import org.example.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByStatus (Status status);

    List<Orders> findByDay (LocalDate day);
}
