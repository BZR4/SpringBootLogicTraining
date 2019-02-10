package br.com.logicsp.spring.service;

import br.com.logicsp.spring.model.Convidado;
import br.com.logicsp.spring.repositories.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    ConvidadoRepository convidadoRepository;

    public Iterable<Convidado> buscarTodos(){
        Iterable<Convidado> convidados = convidadoRepository.findAll();
        return convidados;
    }

    public void salvar(Convidado convidado){
        convidadoRepository.save(convidado);
    }
}
