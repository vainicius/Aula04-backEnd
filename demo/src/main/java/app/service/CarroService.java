package app.service;

import app.dto.CarroDTO;
import app.dto.PessoaDTO;
import app.entity.Carro;
import app.repository.CarroRepository;
import app.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;


    public Carro toCarro(CarroDTO carroDTO){
        Carro carro = new Carro();
        carro.setMarca(carroDTO.getMarca());
        carro.setPlaca(carroDTO.getPlaca());
        carro.setModelo(carroDTO.getModelo());
        carro.setId(carroDTO.getId());
        return carro;
    }

    public CarroDTO toCarroDTO (Carro carro){
        CarroDTO carroDTO = new CarroDTO();
        carroDTO.setMarca(carro.getMarca());
        carroDTO.setPlaca(carro.getPlaca());
        carroDTO.setModelo(carro.getModelo());
        carroDTO.setId(carro.getId());
        return carroDTO;
    }

    public List<CarroDTO> getAll(){
        List<Carro> listaEntidade = repository.findAll();
        List<CarroDTO>listaDTO = new ArrayList<>();

        for(int i=0; i<listaEntidade.size(); i++){
            listaDTO.add(this.toCarroDTO(listaEntidade.get(i)));
        }
        return listaDTO;
    }

    public CarroDTO save(CarroDTO carroDTO){
        Carro carro = this.toCarro(carroDTO);
        Carro carroSalvo = repository.save(carro);
        return this.toCarroDTO(carroSalvo);
    }

    public CarroDTO put (CarroDTO carroDTO, Long id){
        return this.toCarroDTO(repository.save(toCarro(carroDTO)));
    }
    @Transactional
    public void delete(long id){
        PessoaDTO pessoaDTO = new PessoaDTO();
        repository.deleteById(id);
    }
}
