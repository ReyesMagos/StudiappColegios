package co.reyesmagos.studiappcolegios.mocks;

import java.util.ArrayList;
import java.util.List;

import co.reyesmagos.studiappcolegios.dominio.adaptadores.entities.teacher.Group;

/**
 * Created by Alexis-PC on 31/01/2015.
 */
public class GroupFactory {

    private static GroupFactory instance;
    private List<Group> groupFactory;

    private GroupFactory() {

    }

    public static List<Group> getInstance() {
        List<Group> groupFactory = new ArrayList<Group>();

        Group group = new Group();

        group.setTitle("Biología");
        group.setSubTitle("Clase de Biologia");
        group.setDescription("Clases para niños de primaria");
        groupFactory.add(group);

        group = new Group();
        group.setTitle("Matemáticas");
        group.setSubTitle("Matemáticas elementales");
        group.setDescription("Clases de Matematicas para niños de primaria");
        groupFactory.add(group);

        group = new Group();
        group.setTitle("Ciencias Naturales");
        group.setSubTitle("Clases sobre la naturaleza");
        group.setDescription("Clases de ciencias para niños");
        groupFactory.add(group);

        return groupFactory;
    }

    public static void addGroup(Group group){
        getInstance().add(group);
    }
}
