package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

public class Skill {

    private int id;
    private String name;
    private String description;

    public Skill() {
    }

    public Skill(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n\t\t\t\t\t\t" + "Skill{" +
                "\n\t\t\t\t\t\t\t" + "id=" + id +
                "," + "\n\t\t\t\t\t\t\t" + " name='" + name + '\'' +
                "," + "\n\t\t\t\t\t\t\t" + " description='" + description + '\'' +
                "\n\t\t\t\t\t\t" + '}';
    }
}
