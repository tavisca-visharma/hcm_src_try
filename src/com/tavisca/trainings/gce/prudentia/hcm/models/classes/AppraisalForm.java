package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

import com.tavisca.trainings.gce.prudentia.hcm.models.enums.Level;

import java.util.Arrays;

public class AppraisalForm {
    private int id;
    private String[] technologies;
    private Level interpersonal;
    private Level communication;
    private String rating;
    private String remarks;

    public AppraisalForm() {
    }

    public AppraisalForm(int id, String[] technologies, Level interpersonal, Level communication, String rating, String remarks) {
        this.id = id;
        this.technologies = technologies;
        this.interpersonal = interpersonal;
        this.communication = communication;
        this.rating = rating;
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getTechnologies() {
        return technologies;
    }

    public void setTechnologies(String[] technologies) {
        this.technologies = technologies;
    }

    public Level getInterpersonal() {
        return interpersonal;
    }

    public void setInterpersonal(Level interpersonal) {
        this.interpersonal = interpersonal;
    }

    public Level getCommunication() {
        return communication;
    }

    public void setCommunication(Level communication) {
        this.communication = communication;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "AppraisalForm{" +
                "id=" + id +
                ", technologies=" + Arrays.toString(technologies) +
                ", interpersonal=" + interpersonal +
                ", communication=" + communication +
                ", rating='" + rating + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
