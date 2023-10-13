package app.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class LivroDTO {
    private Long id;
    private String nome;
    private String autor;
    private String genero;
}
