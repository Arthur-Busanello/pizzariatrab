package org.example.Controller;

import org.example.DTO.AdressDTO;
import org.example.Entity.Adress;
import org.example.Service.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/Adress")
public class AdressController {
    @Autowired
    private AdressService service;




    @PostMapping

    public ResponseEntity<Adress> create(@RequestBody
                                         AdressDTO adressDTO) {

        return service.create(adressDTO);
    };

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody AdressDTO adressDTO, @RequestParam Long id){
        return service.update(id, adressDTO);
    }

    @DeleteMapping
    private ResponseEntity<Object> Delete(@RequestParam Long id){

        return service.delete(id);
    }
}
