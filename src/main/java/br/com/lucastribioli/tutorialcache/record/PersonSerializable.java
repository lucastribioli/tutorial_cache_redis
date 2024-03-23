package br.com.lucastribioli.tutorialcache.record;

import java.io.Serializable;

public record PersonSerializable(Long id, String name, int age) implements Serializable {

}
