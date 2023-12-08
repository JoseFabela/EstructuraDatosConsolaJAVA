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

public class PriorityTree {
	static class Node {
        String task;
        String priority;
        Node left, right;

        public Node(String task, String priority) {
            this.task = task;
            this.priority = priority;
            this.left = this.right = null;
        }
    }

    private Node root;

    public PriorityTree(String rootTask) {
        this.root = new Node(rootTask, "Media");
    }

    public Node getRoot() {
        return this.root;
    }

    public void insert(String task, String priority) {
        this.root = insertRecursive(this.root, task, priority);
    }

    private Node insertRecursive(Node root, String task, String priority) {
        if (root == null) {
            return new Node(task, priority);
        }

        if (priority.compareTo(root.priority) < 0) {
            root.left = insertRecursive(root.left, task, priority);
        } else {
            root.right = insertRecursive(root.right, task, priority);
        }

        return root;
    }

    public void inOrderTraversal(Node root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.task + " - " + root.priority);
            inOrderTraversal(root.right);
        }
    }
}
