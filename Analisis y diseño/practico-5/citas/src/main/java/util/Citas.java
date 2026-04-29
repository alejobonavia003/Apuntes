package util;

import java.util.ArrayList;

/**
 * Problema de las citas
 *
 * @author Alejo Bonavia
 *
 */

public final class Citas {

  public static class Cita{
    public String descripcion;
    public int fecha;
    public int inicio;
    public int fin;
    public int prioridad;

    public Cita(String d, int fecha, int i, int fin, int p){
      descripcion = d;
      this.fecha = fecha;
      inicio = i;
      this.fin = fin;
      prioridad = p;
    }

    @Override
    public String toString() {
      return descripcion + " (inicio=" + inicio + ", fin=" + fin + ", prioridad=" + prioridad + ")";
    }
  }
   
  public static void main(String[] args){
    ArrayList<Cita> citas = new ArrayList<>();

    
    citas.add(new Cita("Reunión de equipo", 20251031, 9, 10, 3));
    citas.add(new Cita("Llamada con cliente", 20251031, 9, 11, 5));
    citas.add(new Cita("Almuerzo", 20251031, 12, 13, 1));
    citas.add(new Cita("Entrenamiento", 20251031, 10, 12, 4));
    citas.add(new Cita("Cena", 20251031, 20, 22, 2));

    ArrayList<Cita> seleccionadas = mejoresCitas(20251031, citas);
    //System.out.println(seleccionadas.getFirst() + "    ----- " + seleccionadas.getFirst());

    System.out.println("Citas seleccionadas para el día 20251031:");
    for (int i=0;i<seleccionadas.size();i++) {
      System.out.println(" - " + seleccionadas.get(i));
    }
  }  

  public static ArrayList<Cita> mejoresCitas(int fecha, ArrayList<Cita> c){
    ArrayList<Cita> fechaC = new ArrayList<>();

    //agarro solo las de la fecha
    for(int i=0;i<c.size();i++){
      if(c.get(i).fecha == fecha){
        fechaC.add(c.get(i));
      }
    }

    ArrayList<Cita> sortedC = new ArrayList<>();

    for(int i=0;i< fechaC.size();i++){
      for(int j=0;j< fechaC.size();j++){
        if(fechaC.get(i).inicio <= fechaC.get(j).inicio && (!sortedC.contains(fechaC.get(i)) && !sortedC.contains(fechaC.get(j)))){
          if(fechaC.get(j).inicio < fechaC.get(i).fin){
            Cita aux = (fechaC.get(i).prioridad > fechaC.get(j).prioridad ? fechaC.get(i) : fechaC.get(j));
            if(!sortedC.contains(aux)){
              sortedC.add(aux);
            }
          } else {
            if(!sortedC.contains(fechaC.get(i))){
              sortedC.add(fechaC.get(i));
            }
            if(!sortedC.contains(fechaC.get(j))){
              sortedC.add(fechaC.get(j));
            }
          }
        }
      }
    }
    return sortedC;

  }
}   
public static ArrayList<Cita> mejoresCitas(int fecha, ArrayList<Cita> c) {
  ArrayList<Cita> fechaC = new ArrayList<>();

  // Filtro las citas por fecha
  for (int i = 0; i < c.size(); i++) {
    if (c.get(i).fecha == fecha) {
      fechaC.add(c.get(i));
    }
  }

  // Ordeno las citas por hora de inicio (para comparar más fácil)
  fechaC.sort((a, b) -> Integer.compare(a.inicio, b.inicio));

  ArrayList<Cita> sortedC = new ArrayList<>();

  for (int i = 0; i < fechaC.size(); i++) {
    Cita actual = fechaC.get(i);
    boolean solapa = false;

    // Verifico si se solapa con alguna ya elegida
    for (int j = 0; j < sortedC.size(); j++) {
      Cita elegida = sortedC.get(j);

      // hay solapamiento si inicio < fin y fin > inicio
      if (!(actual.fin <= elegida.inicio || actual.inicio >= elegida.fin)) {
        solapa = true;

        // Si se solapan, quedate con la de mayor prioridad
        if (actual.prioridad > elegida.prioridad) {
          sortedC.set(j, actual); // reemplaza la vieja por la nueva
        }
        break; // no hace falta seguir comparando
      }
    }

    // Si no se solapa con ninguna elegida, la agregamos
    if (!solapa) {
      sortedC.add(actual);
    }
  }

  return sortedC;
}
