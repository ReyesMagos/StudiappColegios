package co.reyesmagos.studiappcolegios.mocks;

import java.util.ArrayList;
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

        Tareas tarea = new Tareas();
        tarea.setName("Tarea de matematicas");
        tarea.setDescription("Realizar el capitulo 4 del libro");
        tarea.setDate("25/12/2014");
        tarea.setMateria("Matemáticas");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Tarea de Algebra");
        tarea.setDescription("Hacer ejercicios del capitulo 3 LeitHold");
        tarea.setDate("25/02/2015");
        tarea.setMateria("Matemáticas");

        listTareas.add(tarea);

        tarea = new Tareas();

        tarea.setName("Tarea de español");
        tarea.setDescription("Leer el Principito");
        tarea.setDate("12/01/2015");
        tarea.setMateria("Castellano");

        listTareas.add(tarea);

        tarea = new Tareas();

        tarea.setName("Lectura");
        tarea.setDescription("Realizar resumen del texto de la pág 45");
        tarea.setDate("16/01/2015");
        tarea.setMateria("Castellano");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Realizar Pág 45 libro Artisitica");
        tarea.setDescription("Pintar con colores primarios el dibujo que allí aparece");
        tarea.setDate("15/01/2015");
        tarea.setMateria("artistica");

        listTareas.add(tarea);

        tarea = new Tareas();
        tarea.setName("Dibujo libre");
        tarea.setDescription("Llevar un dibujo libre con vinilos");
        tarea.setDate("15/01/2015");
        tarea.setMateria("Artistica");

        listTareas.add(tarea);

        return listTareas;
    }
}
