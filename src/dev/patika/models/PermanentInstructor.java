package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

    private double permanentSalary;

    public PermanentInstructor(String name, String address, long telNo,double permanentSalary) {
        super(name, address, telNo);
        this.permanentSalary = permanentSalary;
    }

    public PermanentInstructor(double permanentSalary) {
        this.permanentSalary = permanentSalary;
    }

    public PermanentInstructor() {
    }

    public double getPermanentSalary() {
        return permanentSalary;
    }

    public void setPermanentSalary(double permanentSalary) {
        this.permanentSalary = permanentSalary;
    }

    @Override
    public String toString() {
        return "PermanentInstructor{" +
                "permanentSalary=" + permanentSalary +
                '}';
    }
}
