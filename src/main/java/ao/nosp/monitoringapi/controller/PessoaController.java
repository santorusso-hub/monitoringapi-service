package ao.nosp.monitoringapi.controller;

import ao.nosp.monitoringapi.model.Pessoa;
import ao.nosp.monitoringapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;


    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaService.filterAll();
    }
    @GetMapping("/{id}")
    public Pessoa find(@PathVariable long id ) {
        return pessoaService.find(id);
    }

}