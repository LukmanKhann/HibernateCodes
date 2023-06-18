import java.util.*;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value)
            root.left = insertNode(root.left, value);
        else if (value > root.value)
            root.right = insertNode(root.right, value);

        return root;
    }

    public int findClosestValue(int target) {
        return findClosestValueHelper(root, target, root.value);
    }

    private int findClosestValueHelper(Node root, int target, int closest) {
        if (root == null)
            return closest;

        if (Math.abs(root.value - target) < Math.abs(closest - target))
            closest = root.value;

        if (target < root.value)
            return findClosestValueHelper(root.left, target, closest);
        else if (target > root.value)
            return findClosestValueHelper(root.right, target, closest);
        else
            return closest;
    }
}

public class Main {
    public static void main(String[] args) {
        String input = "5 3 9 1 4 7 1 1";
        int K = 13;
        BinaryTree bst = new BinaryTree();
        String[] values = input.split(" ");
        for (String value : values) {
            int num = Integer.parseInt(value);
            bst.insert(num);
        }

        int closestValue = bst.findClosestValue(K);

        int difference = Math.abs(closestValue - K);
        System.out.println("Closest value to " + K + " is " + closestValue);
        System.out.println("Absolute difference: " + difference);
    }
}
