package app.controller;

import app.dto.CarroDTO;
import app.entity.Carro;
import app.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@RestController
@RequestMapping("/api/carro")
@CrossOrigin(origins = "http://localhost:4200")
public class CarroController {
    @Autowired
    private CarroService service;

        @GetMapping("/todos")
        private ResponseEntity<List<CarroDTO>>getAll(){
            try{
                List<CarroDTO>lista = service.getAll();
                return new ResponseEntity<>(lista, HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }

        }
        @PostMapping("/cadastrar")
         private ResponseEntity<CarroDTO> save (@RequestBody CarroDTO carroDTO){
            try{
                return ResponseEntity.ok(service.save(carroDTO));
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }

        }

        @PutMapping("/editar/{id}")
        private ResponseEntity<CarroDTO>editar (@PathVariable("id") Long id, @RequestBody CarroDTO carroDTO){
            try{
                return ResponseEntity.ok(service.put(carroDTO,id));
            }catch (Exception e){
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("/deletar/{id}")
    private ResponseEntity<HttpStatus>delete(@PathVariable("id") final long id){
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);

        }
    }


