package com.example.demo.collections.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.ToString;

/**
 * @package: com.example.demo.collections.domain
 * @author:
 * @email:
 * @createDate: 2019-06-05 10:31
 * @description:
 */
@ToString
public class Zoo {
    public Animal animal;

    @ToString
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
    @JsonSubTypes({@JsonSubTypes.Type(value = Dog.class, name = "dog"), @JsonSubTypes.Type(value = Cat.class, name = "cat")})
    public static class Animal {
        public String name;

        public Animal() {
        }

        public Animal(String name) {
            this.name = name;
        }
    }

    @ToString
    @JsonTypeName("dog")
    public static class Dog extends Animal {
        public double barkVolume;

        public Dog(double barkVolume) {
            this.barkVolume = barkVolume;
        }

        public Dog(String name) {
            super(name);
        }
    }

    @ToString
    @JsonTypeName("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }

        public Cat() {
        }
    }

    public Zoo() {
    }

    public Zoo(Animal animal) {
        this.animal = animal;
    }
}
