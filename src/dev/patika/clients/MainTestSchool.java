package dev.patika.clients;

import dev.patika.controller.CourseController;
import dev.patika.controller.InstructorController;
import dev.patika.controller.StudentController;
import dev.patika.models.*;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class MainTestSchool {
    public static void main(String[] args) {

        if(checkTestData() == 0){
            SaveTestData();
        }

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();
        InstructorController instructorController = new InstructorController();


        List<Student> returnedList = studentController.allStudentList();
        for (Student student : returnedList) {
            System.out.println(student);
        }

        List<Instructor> listInstructor = instructorController.allInstructorList();
        for (Instructor instructor : listInstructor) {
            System.out.println(instructor);
        }

        List<Course> listCourses = courseController.allCourseList();
        for (Course course : listCourses) {
            System.out.println(course);
        }

    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("from Course", Course.class).getResultList().size();
    }

    private static void SaveTestData() {

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        Student student1 = new Student("Berkay","Mersin","E",LocalDate.of(1997,Month.AUGUST,13));
        Student student2 = new Student("Ceren","İzmir","K",LocalDate.of(1998,Month.DECEMBER,23));
        Student student3 = new Student("Alp","İzmir","E",LocalDate.of(1999,Month.MARCH,13));
        Student student4 = new Student("Yiğit","Aydın","E",LocalDate.of(1999,Month.MAY,31));
        Student student5 = new Student("Ömer","Mersin","E",LocalDate.of(1998,Month.MARCH,15));
        Student student6 = new Student("Eda","Muğla","K",LocalDate.of(1998,Month.JANUARY,23));

        Course course1 = new Course("OOP JAVA",101,7);
        Course course2 = new Course("Database Design",301,5);
        Course course3 = new Course("Machine Learning",501,4);

        Instructor instructor1 = new PermanentInstructor("Şevket Çakır","Denizli",14523253,5000.0);
        Instructor instructor2 = new VisitingResearcher("Sezai Tokat","Denizli",21312313,7000.0);
        Instructor instructor3 = new PermanentInstructor("Fatmana Şentürk","Antalya",1651516,4500.0);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        course1.getStudentList().add(student1);
        course1.getStudentList().add(student2);
        course2.getStudentList().add(student3);
        course2.getStudentList().add(student4);
        course3.getStudentList().add(student5);
        course3.getStudentList().add(student6);




        try {
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);
            em.persist(student5);
            em.persist(student6);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();

            System.out.println("All Data Persisted.......");

        }catch (Exception e){
            em.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }
}
