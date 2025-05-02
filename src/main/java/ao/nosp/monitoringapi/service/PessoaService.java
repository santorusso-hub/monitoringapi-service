package ao.nosp.monitoringapi.service;

import ao.nosp.monitoringapi.model.Pessoa;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    @Cacheable("pessoas")
    public List<Pessoa> filterAll () {
        simulateLatency();
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa(1, "João Silva", 30, "joao.silva@email.com"));
        pessoas.add(new Pessoa(2, "Maria Oliveira", 25, "maria.oliveira@email.com"));
        pessoas.add(new Pessoa(3, "Carlos Santos", 40, "carlos.santos@email.com"));
        pessoas.add(new Pessoa(4, "Ana Souza", 35, "ana.souza@email.com"));
        pessoas.add(new Pessoa(5, "Pedro Costa", 28, "pedro.costa@email.com"));
        return pessoas;
    }



    @Cacheable(value = "findpessoa", key = "#id")
    public Pessoa find(long id) {
        simulateLatency();
        for (Pessoa pessoa :  filterAll()) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null; // ou lançar exceção se preferir
    }



    public void simulateLatency() {
        try {
            long time=2000L;
            Thread.sleep(time);
        }catch (InterruptedException e){
            throw new IllegalStateException(e);
        }
    }
}
