package org.example.Service;

import org.example.DTO.AdressDTO;
import org.example.Entity.Adress;
import org.example.Repository.AdressRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdressService {
    @Autowired
    private AdressRepository repository;



    public ResponseEntity<Object> update (Long id, AdressDTO adressDTO){
        Optional<Adress> adress_update = repository.findById(id);
        if ( adress_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Adress adress = adress_update.get();
            BeanUtils.copyProperties(adressDTO,adress);
            return ResponseEntity.ok(adress_update);

        }

    }

    public ResponseEntity<Adress> create(AdressDTO adressDTO){

        try {
            Adress adress = new Adress();
            BeanUtils.copyProperties(adressDTO, adress);

            repository.save(adress);

            return ResponseEntity.ok(adress);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }


    public ResponseEntity<Object> delete ( Long id){
        Optional<Adress> adress_optional = repository.findById(id) ;
        if ( adress_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Adress adress = adress_optional.get();
            repository.delete(adress);
            return ResponseEntity.ok("Adresse deletado com sucesso");


        }

    }
}
