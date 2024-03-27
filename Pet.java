package com.mns;

public class Pet {
    private int id;
    private String name;
    private int age;
    private String breed;
    private String type;

    public Pet(String name, int age, String breed, String type) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.type = type;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
