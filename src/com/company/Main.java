package com.company;

class Student{
    private String name;
    private String code;
    private String lastname;

    //Constructor
    Student(String name, String lastname, String code){
        this.name = name;
        this.lastname = lastname;
        this.code = code;
    }

    /*Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code){
        this.code = code;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }*/

    //Getters
    public String getName() {
        return name;
    }

    public String getCode(){
        return code;
    }

    public String getLastName(){
        return lastname;
    }
}

class Group{
    private String code;
    private Student[] students;
    private int enrolled; //0, int, float, short, byte, double, char
    private int rejected; //boolean -> true/false

    public Group(String code, int capacity){
        this.code = code;
        students = new Student[capacity];
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public boolean addStudents(Student student){
        if(enrolled < students.length){
            students[enrolled++] = student;
            return true;
        }
        else {
            ++rejected;
            return false;
        }
    }

    public int getEnrolled(){
        return enrolled;
    }

    public int getRejected(){
        return rejected;
    }

    public Student getStudent(int index){
        return students[index];
    }

    public void removeStudent(String code){
        /*for(int i; i<8; i++) {
        Student[i] = Student[i+1];
        }*/
    }
}

public class Main {

    public static void main(String[] args) {
	Student student1;
    Student student2 = new Student("Ivan", "Uresti", "972196");
    student1 = new Student("José", "Gonzáles", "456789");

    Group group = new Group("230401", 8);
    Group group2 = new Group("230402", 6);

    if (!group.addStudents(student1)) {
        System.out.println("Estudiante no fue añadido: " + student1.getName() + " " + student1.getLastName());
    }

    if (!group.addStudents(student2)) {
        System.out.println("Estudiante no fue añadido: " + student2.getName() + " " + student2.getLastName());
    }

    group.addStudents(new Student("Jorge", "Acosta", "1"));
    group.addStudents(new Student("Arturo", "Aleman", "2"));
    group.addStudents(new Student("Antonio", "Angel", "3"));
    group.addStudents(new Student("Francisco", "Arreguin", "4"));
    group2.addStudents(new Student("Misael", "Cabrera", "5"));
    group2.addStudents(new Student("Roberto", "Cisneros", "6"));
    group.addStudents(new Student("Juan", "Coronado", "7"));
    group.addStudents(new Student("José", "González", "8"));
    group.addStudents(new Student("Jesús", "Lara", "9"));
    group.addStudents(new Student("José", "Limón", "10"));


    System.out.println("Grupo: " + group.getCode() + ", Alumnos inscritos: " + group.getEnrolled() + ", Alumnos rechazados: " + group.getRejected());
    System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d\n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

    group.removeStudent("4");
    group2.removeStudent("6");
    group2.removeStudent("12");

    System.out.println("Grupo: " + group.getCode() + ", Alumnos inscritos: " + group.getEnrolled() + ", Alumnos rechazados: " + group.getRejected());
    System.out.printf("Grupo: %s, inscritos: %d, rechazados: %d\n", group2.getCode(), group2.getEnrolled(), group2.getRejected());

    System.out.println();
    System.out.println("Alumnos del grupo: " + group.getCode());

    for(int i = 0; i < group.getEnrolled(); i++){
        Student student = group.getStudent(i);
        System.out.println(student.getCode() + ": " + student.getName() + "" + student.getLastName());
    }

    for(int i = 0; i < group2.getEnrolled(); i++){
        Student student = group2.getStudent(i);
        System.out.println(student.getCode() + ": " + student.getName() + "" + student.getLastName());
    }
    }
}
