package ao.nosp.monitoringapi.controller;

import ao.nosp.monitoringapi.model.Estudante;
import ao.nosp.monitoringapi.service.EstudanteService;
import ao.nosp.monitoringapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudante")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;

    @PostMapping
    public void save(@RequestBody Estudante estudante) {
        estudanteService.save(estudante);
    }

    @GetMapping("/{id}")
    public Estudante find(@PathVariable long id) {
        return estudanteService.find(id);
    }
}
