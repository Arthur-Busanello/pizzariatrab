package org.example.Service;

import org.example.DTO.DeliveryDTO;
import org.example.Entity.Delivery;
import org.example.Entity.MetodoEntrega;
import org.example.Repository.DeliveryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository repository;


    public List<Delivery> Findall() { return repository.findAll();}

    public List<Delivery> FindByMetodoEntrega(MetodoEntrega name) { return repository.findByMetodoEntrega(name);}

    public ResponseEntity<Object> update (Long id, DeliveryDTO deliveryDTO){
        Optional<Delivery> delivery_update = repository.findById(id);
        if ( delivery_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Delivery delivery = delivery_update.get();
            BeanUtils.copyProperties(deliveryDTO,delivery);
            return ResponseEntity.ok(delivery_update);

        }

    }

    public ResponseEntity<Delivery> create(DeliveryDTO deliveryDTO){

        try {
            Delivery delivery = new Delivery();
            BeanUtils.copyProperties(deliveryDTO, delivery);

            repository.save(delivery);

            return ResponseEntity.ok(delivery);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Delivery> delivery_optional = repository.findById(id) ;
        if ( delivery_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Delivery delivery = delivery_optional.get();
            repository.delete(delivery);
            return ResponseEntity.ok("Deliverye deletado com sucesso");


        }

    }
}
