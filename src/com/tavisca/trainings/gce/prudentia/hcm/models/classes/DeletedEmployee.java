package com.tavisca.trainings.gce.prudentia.hcm.models.classes;

public class DeletedEmployee {
    private Employee employee;

    public DeletedEmployee() {
    }

    public DeletedEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DeletedEmployee{" +
                "employee=" + employee +
                '}';
    }
}
