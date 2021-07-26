package br.com.zupacademy.stephanie.casadocodigo.repository;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository  extends JpaRepository<Autor, Long> {

   Autor findByNome(String nome);
}
