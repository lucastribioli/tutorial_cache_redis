package br.com.lucastribioli.tutorialcache.withCacheRedis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.lucastribioli.tutorialcache.record.PersonSerializable;

@Service
public class PersonServiceWithRedis {
    Map<Long, PersonSerializable> persons = new HashMap<>() {
        {
            put(1L, new PersonSerializable(1L, "Lucas", 25));
            put(2L, new PersonSerializable(2L, "João", 30));
            put(3L, new PersonSerializable(3L, "Maria", 35));
        }
    };

    @Cacheable("persons")
    public PersonSerializable getById(Long id) {
        System.out.println("(Cache Redis) Getting person by id: " + id);
        simulateSlowService();
        return persons.get(id);
    }

    private void simulateSlowService() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
