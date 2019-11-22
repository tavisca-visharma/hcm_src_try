package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

import com.tavisca.trainings.gce.prudentia.hcm.models.enums.Level;

import java.time.Instant;

public class SkillMatrix {

    private int id;
    private Skill skill;
    private Level proficiency;
    private Instant acquired;

    public SkillMatrix() {
    }

    public SkillMatrix(Skill skill, Level proficiency, Instant acquired) {
        this.skill = skill;
        this.proficiency = proficiency;
        this.acquired = acquired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Level getProficiency() {
        return proficiency;
    }

    public void setProficiency(Level proficiency) {
        this.proficiency = proficiency;
    }

    public Instant getAcquired() {
        return acquired;
    }

    public void setAcquired(Instant acquired) {
        this.acquired = acquired;
    }

    @Override
    public String toString() {
        return "SkillMatrix{" +
                "id=" + id +
                ", skill=" + skill +
                ", proficiency=" + proficiency +
                ", acquired=" + acquired +
                '}';
    }
}
