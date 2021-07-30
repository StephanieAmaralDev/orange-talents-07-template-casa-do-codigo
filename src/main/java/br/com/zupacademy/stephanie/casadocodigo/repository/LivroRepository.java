package br.com.zupacademy.stephanie.casadocodigo.repository;

import br.com.zupacademy.stephanie.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByTitulo(String titulo);
}
