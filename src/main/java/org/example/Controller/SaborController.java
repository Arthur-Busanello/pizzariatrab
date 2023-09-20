package org.example.Controller;

import org.example.DTO.SaborDTO;
import org.example.Entity.Sabor;
import org.example.Service.SaborService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/saborDTO")
public class SaborController {
    @Autowired
    private SaborService service;

    @GetMapping("/findall")

    public List<Sabor> Findall() {
        return service.Findall();
    }

    @GetMapping("/nome")
    private Sabor findByNome (@RequestParam String nome) {
        return service.findByNome(nome);
    }

    @PostMapping

    public ResponseEntity<Sabor> create (@RequestBody
                                         SaborDTO saborDTO) {

        return service.create(saborDTO);
    };

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody SaborDTO saborDTO, @RequestParam Long id){
        return service.update(id, saborDTO);
    }

    @DeleteMapping
    private ResponseEntity<Object> Delete(@RequestParam long id){

        return service.delete(id);
    }
}
