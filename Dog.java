package com.mns;

public class Dog extends Pet {
    private String dogBreed;

    public Dog(String name, int age, String breed, String type, String dogBreed) {
        super(name, age, breed, type);
        this.dogBreed = dogBreed;
    }

    public String getDogBreed() {
        return dogBreed;
    }

    public void setDogBreed(String dogBreed) {
        this.dogBreed = dogBreed;
    }
}
