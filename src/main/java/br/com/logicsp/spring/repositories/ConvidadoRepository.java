package br.com.logicsp.spring.repositories;

import br.com.logicsp.spring.model.Convidado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {
    List<Convidado> findByNome(String nome);
}
