import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

class BacklockTest {

   @Test
    void spentTime() {
        Set<Functionality> functionalities= new HashSet<>();
        Functionality f1 = new Functionality("tarea 1", 2, 12);
        Functionality f2 = new Functionality("tarea 2", 1, 10);
        Functionality f3 = new Functionality("tarea 3", 3, 20);
        Functionality f4 = new Functionality("tarea 4", 2, 15);
        functionalities.add(f1);
        functionalities.add(f2);
        functionalities.add(f3);
        functionalities.add(f4);

        Backlog b1 = new Backlog(functionalities, 5);

        assertEquals(37, b1.getValue(), "Max value in sprint");
    }

    @Test
    void optimalSetTest() {
        Set<Functionality> functionalities = new HashSet<>();
        Functionality f1 = new Functionality("tarea 1", 2, 12);
        Functionality f2 = new Functionality("tarea 2", 1, 10);
        Functionality f3 = new Functionality("tarea 3", 3, 20);
        Functionality f4 = new Functionality("tarea 4", 2, 15);
        functionalities.add(f1);
        functionalities.add(f2);
        functionalities.add(f3);
        functionalities.add(f4);

        Backlog b1 = new Backlog(functionalities, 5);
        Set<Functionality> res = b1.optimalSet();

        assertEquals(3, res.size(), "Optimal set size");
        Set<Functionality> expectedList = new HashSet<>(Arrays.asList(f1, f2, f4));
        assertEquals(expectedList, res, "Optimal Set");

    }

    @Test
    void resultSprintExample() {
        Set<Functionality> functionalities = new HashSet<>(Arrays.asList(
            new Functionality("Login social", 3, 8),
            new Functionality("Panel administración", 5, 10),
            new Functionality("Chat en tiempo real", 8, 12),
            new Functionality("Exportar reportes", 2, 6),
            new Functionality("Notificaciones push", 3, 7),
            new Functionality("Búsqueda avanzada", 4, 9),
            new Functionality("Dashboard personalizado", 6, 11),
            new Functionality("API RESTful", 5, 8),
            new Functionality("Sistema de backup", 2, 5),
            new Functionality("Editor WYSIWYG", 4, 7)
        ));

        int SprintTime = 15;
        Backlog backlog = new Backlog(functionalities, SprintTime);

        Set<Functionality> expectedFunctionalities = new HashSet<>(Arrays.asList(
            new Functionality("Login social", 3, 8),
            new Functionality("Panel administración", 5, 10),
            new Functionality("Exportar reportes", 2, 6),
            new Functionality("Notificaciones push", 3, 7),
            new Functionality("Sistema de backup", 2, 5)
        ));
        int totalTimeExpected = expectedFunctionalities.stream().mapToInt(Functionality::getTimeCost).sum();
        int totalValueExpected = expectedFunctionalities.stream().mapToInt(Functionality::getValue).sum();
        assertEquals(totalTimeExpected, backlog.getSpentTime(), "Total time used in sprint");
        assertEquals(totalValueExpected, backlog.getValue(), "Total value used in sprint");
        assertEquals(expectedFunctionalities, backlog.optimalSet(), "Optimal functionalities");

    }
}