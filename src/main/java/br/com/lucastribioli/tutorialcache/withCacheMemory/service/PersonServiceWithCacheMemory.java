package br.com.lucastribioli.tutorialcache.withCacheMemory.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.lucastribioli.tutorialcache.record.Person;

@Service
public class PersonServiceWithCacheMemory {
    Map<Long, Person> persons = new HashMap<>() {
        {
            put(1L, new Person(1L, "Lucas", 25));
            put(2L, new Person(2L, "João", 30));
            put(3L, new Person(3L, "Maria", 35));
        }
    };

    @Cacheable("persons")
    public Person getById(Long id) {
        System.out.println("(Cache Memory) Getting person by id: " + id);
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
