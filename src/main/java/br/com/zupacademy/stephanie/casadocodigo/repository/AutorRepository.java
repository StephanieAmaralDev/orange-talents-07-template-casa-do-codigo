package br.com.zupacademy.stephanie.casadocodigo.repository;

import br.com.zupacademy.stephanie.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AutorRepository  extends JpaRepository<Autor, Long> {

   Autor findByNome(String nome);

   Optional<Autor> findByEmail(String email);
}
