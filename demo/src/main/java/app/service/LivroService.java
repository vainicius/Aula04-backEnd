package app.service;

import app.dto.LivroDTO;
import app.dto.PessoaDTO;
import app.entity.Livro;
import app.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;


    private Livro toLivro(LivroDTO livroDTO){
        Livro livro = new Livro();
        livro.setNome(livroDTO.getNome());
        livro.setGenero(livroDTO.getGenero());
        livro.setAutor(livroDTO.getAutor());
        livro.setId(livroDTO.getId());
        return livro;
    }
    private LivroDTO toLivroDTO(Livro livro){
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setNome(livro.getNome());
        livroDTO.setGenero(livro.getGenero());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setId(livro.getId());
        return livroDTO;
    }

    public LivroDTO save (LivroDTO livroDTO){
        Livro livro = this.toLivro(livroDTO);
        Livro livroNovo = repository.save(livro);

        return this.toLivroDTO(livroNovo);
    }

    public LivroDTO put (LivroDTO livroDTO, Long id){
        return this.toLivroDTO(repository.save(toLivro(livroDTO)));

    }

    public void delete(Long id){
        LivroDTO livroDTO = new LivroDTO();
        repository.deleteById(id);
    }

    public List<LivroDTO>getAll(){
        List<Livro> listEntidade = repository.findAll();
        List<LivroDTO>listDTO = new ArrayList<>();

        for(int i=0; i<listEntidade.size(); i++){
            listDTO.add(this.toLivroDTO(listEntidade.get(i)));
        }
        return listDTO;
    }
}
