package br.com.lucastribioli.tutorialcache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.com.lucastribioli.tutorialcache.withCacheMemory.service.PersonServiceWithCacheMemory;
import br.com.lucastribioli.tutorialcache.withoutCache.service.PersonServiceWithoutCache;

@SpringBootApplication
@EnableCaching
public class TutorialCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialCacheApplication.class, args);
	}

	@Bean
	ApplicationRunner initWithoutCache(PersonServiceWithoutCache personService) {
		return args -> {
			System.out.println("Fetching persons...");
			System.out.println(personService.getById(1L));
			System.out.println(personService.getById(2L));
			System.out.println(personService.getById(3L));
			System.out.println(personService.getById(1L));
			System.out.println(personService.getById(2L));
			System.out.println(personService.getById(3L));
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
		};
	}

	@Bean
	ApplicationRunner initWithCacheMemory(PersonServiceWithCacheMemory personService) {
		return args -> {
			System.out.println("Fetching persons...");
			System.out.println(personService.getById(1L));
			System.out.println(personService.getById(2L));
			System.out.println(personService.getById(3L));
			System.out.println(personService.getById(1L));
			System.out.println(personService.getById(2L));
			System.out.println(personService.getById(3L));
			System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
		};
	}
}

