
/**
 * Main class for Lab-classes project
 */
public class LabClassMain {

    public static void main(String[] args) {

      //crea una class nueva con (capacidad de la clase)
      LabClass comision1 = new LabClass(75);
      LabClass comision2 = new LabClass(75);
      LabClass comision3 = new LabClass(75);


      //registramos todos los estudiantes
      Student student1 = new Student("Bosh Joaco", "XZ12345");
      comision1.enrollStudent(student1);
      Student student2 = new Student("Luka Chave", "XZ12363");
      comision2.enrollStudent(student2);
      Student student3 = new Student("Lauti Giraudo", "XZ123435");
      comision2.enrollStudent(student3);
      Student student4 = new Student("Alejo bonavia", "XZ1234563524");
      comision3.enrollStudent(student4);

      // seteamos un instructor a cada comision
      comision1.setInstructor("Pablito Ponzio");
      comision2.setInstructor("Pablaso Ponzio");
      comision3.setInstructor("Pablin Ponzio");

      //seteamos una aula
      comision1.setRoom("101 P2");
      comision2.setRoom("101 P2");
      comision3.setRoom("101 P2");

      //seteamos una hora y dia de inicio
      comision1.setTime("mie 08:00");
      comision2.setTime("jue 14:00");
      comision3.setTime("vie 16:00");

      //mostramos por terminal la cantidad de estudiantes y su informacioon por terminal
      System.out.println("--------------------------------------------------");
      System.out.println("lista de estudiantes de la comision 1:");
      comision1.printList();
      System.out.println("--------------------------------------------------");
      System.out.println("--------------------------------------------------");
      System.out.println("lista de estudiantes de la comision 2:");
      comision2.printList();
      System.out.println("--------------------------------------------------");
      System.out.println("lista de estudiantes de la comision 3:");
      comision3.printList();
      System.out.println("--------------------------------------------------");
      /**
       * 2.2) getName es un setter que devuelve el nombre del estudiante
       *      addCredits es getter que agrega creditos al estudiante
       */
      
    }
}
