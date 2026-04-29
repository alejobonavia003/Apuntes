import java.util.HashSet;

public class Curso {

    private HashSet<Student> estudiantes;

    public Curso () {
        this.estudiantes = new HashSet<>();
    }

    public void addStudent(Student studiante){
        estudiantes.add(studiante);
    }

    public boolean findStudent(Student s1){
        return estudiantes.contains(s1);
    }


}
