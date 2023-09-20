package org.example.Controller;

import org.example.DTO.AdressDTO;
import org.example.DTO.ClientDTO;
import org.example.Entity.Client;
import org.example.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @GetMapping("/findall")

    public List<Client> Findall() {
        return service.Findall();
    }

    @GetMapping("/name")

    public List<Client> findByName(@RequestParam String nome) {
        return service.FindByName(nome);
    }

    @PostMapping

    public ResponseEntity<Client> create (@RequestBody
                                          ClientDTO clientDTO) {

        return service.create(clientDTO);
    };

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody ClientDTO clientDTO, @RequestParam Long id){
        return service.update(id, clientDTO);
    }

    @DeleteMapping
    private ResponseEntity<Object> Delete(@RequestParam long id){

        return service.delete(id);
    }

    @PutMapping("/adress")

    public ResponseEntity<Object> addAdress (@RequestBody AdressDTO adressDTO, @RequestParam Long id){
        return service.AddAdress(id, adressDTO);
    }
}
