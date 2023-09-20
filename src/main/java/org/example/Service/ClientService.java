package org.example.Service;

import org.example.DTO.AdressDTO;
import org.example.DTO.ClientDTO;
import org.example.Entity.Adress;
import org.example.Entity.Client;
import org.example.Repository.AdressRepository;
import org.example.Repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private AdressRepository adressRepository;



    public List<Client> Findall() { return repository.findAll();}

    public List<Client> FindByName(String name) { return Collections.singletonList(repository.findByNome(name));}

    public ResponseEntity<Object> update (Long id, ClientDTO clientDTO){
        Optional<Client> cliente_update = repository.findById(id);
        if ( cliente_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Client client = cliente_update.get();
            BeanUtils.copyProperties(clientDTO,client);
            return ResponseEntity.ok(cliente_update);

        }

    }

    public ResponseEntity<Client> create(ClientDTO clientDTO){

        try {
            Client cliente = new Client();
            BeanUtils.copyProperties(clientDTO, cliente);

            repository.save(cliente);

            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}

    }

    public ResponseEntity<Object> AddAdress(Long id, AdressDTO adressdto) {
        Optional<Client> cliente_update = repository.findById(id);
        if ( cliente_update.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {
            Client client =cliente_update.get();
            List<Adress> adresses = client.getEndereco();
            Adress adress = new Adress();

            BeanUtils.copyProperties(adressdto, adress);
            adressRepository.save(adress);
            adresses.add(adress);
            client.setEndereco(adresses);
            repository.save(client);



            return ResponseEntity.ok(client);

        }

    }

    public ResponseEntity<Object> delete ( Long id){
        Optional<Client> cliente_optional = repository.findById(id) ;
        if ( cliente_optional.isEmpty()) {
            ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return objectResponseEntity;
        } else {


            Client cliente = cliente_optional.get();
            repository.delete(cliente);
            return ResponseEntity.ok("Cliente deletado com sucesso");


        }

    }
}
