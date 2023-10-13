package app.controller;

import app.dto.CarroDTO;
import app.dto.LivroDTO;
import app.entity.Livro;
import app.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livro")
@CrossOrigin("http://localhost:4200")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/todos")
    private ResponseEntity<List<LivroDTO>> getAll(){
        try{
            List<LivroDTO>lista = service.getAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

    }
    @PostMapping("/cadastrar")
    private ResponseEntity<LivroDTO> save (@RequestBody LivroDTO livroDTO){
        try{
            return ResponseEntity.ok(service.save(livroDTO));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/editar/{id}")
    private ResponseEntity<LivroDTO>editar (@PathVariable("id") Long id, @RequestBody LivroDTO livroDTO){
        try{
            return ResponseEntity.ok(service.put(livroDTO,id));
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletar/{id}")
    private ResponseEntity<HttpStatus>delete(@PathVariable("id") final long id){
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }



}
