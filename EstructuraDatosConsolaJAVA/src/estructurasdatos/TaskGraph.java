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

public class TaskGraph {
	 private Map<String, List<String>> taskDependencies;

	    public TaskGraph() {
	        this.taskDependencies = new HashMap<>();
	    }

	    public void addTask(String task) {
	        if (!taskDependencies.containsKey(task)) {
	            taskDependencies.put(task, new ArrayList<>());
	        }
	    }

	    public void addTaskDependency(String task, String dependency) {
	        if (taskDependencies.containsKey(task)) {
	            taskDependencies.get(task).add(dependency);
	        }
	    }

	    public void BFS(String startTask) {
	        if (!taskDependencies.containsKey(startTask)) {
	            System.out.println("La tarea '" + startTask + "' no existe en el grafo de tareas.");
	            return;
	        }

	        Set<String> visited = new HashSet<>();
	        Queue<String> queue = new LinkedList<>();

	        visited.add(startTask);
	        queue.add(startTask);

	        while (!queue.isEmpty()) {
	            String currentTask = queue.poll();
	            System.out.println(currentTask);

	            if (taskDependencies.containsKey(currentTask)) {
	                for (String dependency : taskDependencies.get(currentTask)) {
	                    if (!visited.contains(dependency)) {
	                        visited.add(dependency);
	                        queue.add(dependency);
	                    }
	                }
	            }
	        }
}}
