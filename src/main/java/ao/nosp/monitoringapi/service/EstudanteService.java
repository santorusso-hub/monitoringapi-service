package ao.nosp.monitoringapi.service;

import ao.nosp.monitoringapi.model.Estudante;
import ao.nosp.monitoringapi.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudanteService {

    @Autowired
    private RedisTemplate<String, Estudante> redisTemplate;
    private static final String KEY_PREFIX = "estudante:";



    public Estudante find(long id) {
        return redisTemplate.opsForValue().get(KEY_PREFIX + id);
    }

    public void save(Estudante estudante) {
        redisTemplate.opsForValue().set(KEY_PREFIX + estudante.getId(), estudante);
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
