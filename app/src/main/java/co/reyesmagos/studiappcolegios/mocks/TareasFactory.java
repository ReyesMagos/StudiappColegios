package co.reyesmagos.studiappcolegios.mocks;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.Tareas;

/**
 * Created by Alexis-PC on 15/12/2014.
 */
public class TareasFactory {

    private static TareasFactory instance;
    private List<Tareas> tareasList;

    private TareasFactory() {
        super();
    }

    public static List<Tareas> getInstance(){
        List<Tareas> listTareas = new ArrayList<Tareas>();
        Long date;
        Tareas tarea = new Tareas();
        tarea.setName("Tarea de matematicas");
        tarea.setDescription("Realizar el capitulo 4 del libro");
        date = new Long("1420666111000");
        tarea.setDate(new Date(date));
        tarea.setMateria("Matemáticas");
        //tarea.setHeaderTitle("1");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Tarea de Algebra");
        tarea.setDescription("Hacer ejercicios del capitulo 3 LeitHold");
        date = new Long("1420838911000");
        tarea.setDate(new Date(date));
        tarea.setMateria("Matemáticas");
        tarea.setHeaderTitle("2");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Tarea de español");
        tarea.setDescription("Leer el Principito");
        date = new Long("1420752511000");
        tarea.setDate(new Date(date));
        tarea.setMateria("Castellano");
        tarea.setHeaderTitle("3");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Lectura");
        tarea.setDescription("Realizar resumen del texto de la pág 45");
        date = new Long("1421184511000");
        tarea.setDate(new Date(date));
        tarea.setMateria("Castellano");
        tarea.setHeaderTitle("4");

        listTareas.add(tarea);
        tarea = new Tareas();
        tarea.setName("Realizar Pág 45 libro Artisitica");
        tarea.setDescription("Pintar con colores primarios el dibujo que allí aparece");
        tarea.setDate(new Date(2015, 01,15));
        tarea.setMateria("artistica");
        tarea.setHeaderTitle("5");

        listTareas.add(tarea);
        tarea = new Tareas();
        tarea.setName("Dibujo libre");
        tarea.setDescription("Llevar un dibujo libre con vinilos");
        date = new Long("1421989200000");
        tarea.setDate(new Date(date));
        tarea.setMateria("Artistica");
        tarea.setHeaderTitle("6");

        listTareas.add(tarea);

        return listTareas;
    }
}
