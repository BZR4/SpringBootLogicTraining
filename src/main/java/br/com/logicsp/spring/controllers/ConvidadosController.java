package br.com.logicsp.spring.controllers;

import br.com.logicsp.spring.model.Convidado;
import br.com.logicsp.spring.repositories.ConvidadoRepository;
import br.com.logicsp.spring.service.ConvidadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ConvidadosController {

    @Autowired
    ConvidadoService convidadoService;

    @RequestMapping("/")
    String index(){
        return "index";
    }

    @RequestMapping("/listaconvidados")
    public String listaConvidados(Model model){
        Iterable<Convidado> listaConvidados = convidadoService.buscarTodos();
        model.addAttribute("convidados", listaConvidados);
        return "listaconvidados";
    }

//    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    @PostMapping("salvar")
    public String salvar(@RequestParam("nome_convidado") String nome, @RequestParam("email_convidado") String email, Model model){
        System.out.println("Nome: "+nome+"\tE-mail: "+email);
        Convidado convidado = new Convidado(nome, email);
        convidadoService.salvar(convidado);
        Iterable<Convidado> convidados = convidadoService.buscarTodos();
        model.addAttribute("convidados", convidados);
        return "listaconvidados";
    }


//    @PostMapping("buscar")
//    public String buscarConvidadoPorNome(@RequestParam("busca") String nome, Model model){
//        Iterable<Convidado> buscaConvidados = convidadoRepository.findByNome(nome);
//        List<Convidado> lista = (List<Convidado>) buscaConvidados;
//        model.addAttribute("lista",lista);
//        Iterable<Convidado> convidados = convidadoRepository.findAll();
//        model.addAttribute("convidados", convidados);
//        return "listaconvidados";
//    }
}
