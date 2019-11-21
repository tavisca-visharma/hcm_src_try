package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

import com.tavisca.trainings.gce.prudentia.hcm.models.enums.Level;

import java.io.Serializable;
import java.time.Instant;

public class SkillMatrix implements Serializable {

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
        return "\n\t\t\t" + "SkillMatrix{" +
                "\n\t\t\t\t" + "skill=" + skill +
                "," + "\n\t\t\t\t" + " proficiency=" + proficiency +
                "," + "\n\t\t\t\t" + " acquired=" + acquired +
                "," + "\n\t\t\t" + "}";
    }
}
