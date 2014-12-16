package co.reyesmagos.studiappcolegios.dominio.adaptadores.entities;

/**
 * Created by Alexis-PC on 15/12/2014.
 */
public class Tareas {

    private String name;
    private String description;
    private String date;
    private String materia; //Cambiar a una clase materia

    public Tareas() {
        super();
    }

    public Tareas(String name, String description, String date) {
        this.name = name;
        this.description = description;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
