package estructurasdatos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
        Queue<String> tareasPendientes = new LinkedList<>();
        List<String> tareasCompletadas = new ArrayList<>();
        PriorityTree arbolPrioridad = new PriorityTree("Proyecto");
        TaskGraph grafoTareas = new TaskGraph();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar tarea pendiente (Cola)");
            System.out.println("2. Completar tarea (Cola y Lista)");
            System.out.println("3. Ver tareas pendientes (Cola)");
            System.out.println("4. Ver tareas completadas (Lista)");
            System.out.println("5. Agregar tarea al árbol de prioridad");
            System.out.println("6. Ver árbol de prioridad");
            System.out.println("7. Agregar tarea al grafo de tareas");
            System.out.println("8. Ver grafo de tareas (BFS)");
            System.out.println("9. Salir");

            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la nueva tarea pendiente: ");
                    String nuevaTarea = scanner.nextLine();
                    tareasPendientes.add(nuevaTarea);
                    System.out.println("Tarea \"" + nuevaTarea + "\" agregada correctamente a la Cola.");
                    break;

                case "2":
                    if (!tareasPendientes.isEmpty()) {
                        String tareaCompleta = tareasPendientes.poll();
                        tareasCompletadas.add(tareaCompleta);
                        System.out.println("Tarea \"" + tareaCompleta + "\" completada y movida a Lista de Tareas Completadas.");
                    } else {
                        System.out.println("No hay tareas pendientes para completar.");
                    }
                    break;

                case "3":
                    System.out.println("\nTareas Pendientes (Cola):");
                    for (String tarea : tareasPendientes) {
                        System.out.println(tarea);
                    }
                    break;

                case "4":
                    System.out.println("\nTareas Completadas (Lista):");
                    for (String tarea : tareasCompletadas) {
                        System.out.println(tarea);
                    }
                    break;

                case "5":
                    System.out.print("Ingrese la nueva tarea para el árbol de prioridad: ");
                    String nuevaTareaArbol = scanner.nextLine();
                    System.out.print("Ingrese la prioridad (Alta, Media, Baja): ");
                    String prioridadTareaArbol = scanner.nextLine();
                    arbolPrioridad.insert(nuevaTareaArbol, prioridadTareaArbol);
                    System.out.println("Tarea \"" + nuevaTareaArbol + "\" agregada al Árbol de Prioridad.");
                    break;

                case "6":
                    System.out.println("\nÁrbol de Prioridad:");
                    arbolPrioridad.inOrderTraversal(arbolPrioridad.getRoot());
                    break;

                case "7":
                    System.out.print("Ingrese la nueva tarea para el grafo de tareas: ");
                    String nuevaTareaGrafo = scanner.nextLine();
                    grafoTareas.addTask(nuevaTareaGrafo);

                    System.out.print("Ingrese dependencias de '" + nuevaTareaGrafo + "' (separadas por coma): ");
                    String[] dependencias = scanner.nextLine().split(",");

                    for (String dependency : dependencias) {
                        grafoTareas.addTaskDependency(nuevaTareaGrafo, dependency.trim());
                    }

                    System.out.println("Tarea '" + nuevaTareaGrafo + "' agregada al Grafo de Tareas.");
                    break;

                case "8":
                    System.out.print("Ingrese la tarea para iniciar BFS en el grafo de tareas: ");
                    String tareaInicioBFS = scanner.nextLine();
                    grafoTareas.BFS(tareaInicioBFS);
                    break;

                case "9":
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número del 1 al 9.");
                    break;
            }
        }
    }
}
