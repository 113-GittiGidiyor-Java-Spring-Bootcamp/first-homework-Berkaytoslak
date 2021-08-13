package dev.patika.models;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{

    private double visitingSalary;

    public VisitingResearcher(String name, String address, long telNo,double visitingSalary) {
        super(name, address, telNo);
        this.visitingSalary = visitingSalary;
    }

    public VisitingResearcher(double visitingSalary) {
        this.visitingSalary = visitingSalary;
    }

    public VisitingResearcher() {
    }

    public double getVisitingSalary() {
        return visitingSalary;
    }

    public void setVisitingSalary(double visitingSalary) {
        this.visitingSalary = visitingSalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "visitingSalary=" + visitingSalary +
                '}';
    }
}
