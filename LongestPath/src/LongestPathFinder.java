import java.util.ArrayList;

public class LongestPathFinder {

    //Binary tree node
    private static class Node {
        Node left;
        Node right;
        int data;
    }

    //to create a new Binary Node
    static Node newNode(int data) {
        Node temp = new Node();

        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }

    //to find the longest path
    private static ArrayList<Integer> longestPath(Node root) {
        //check for null
        if (root == null) {
            ArrayList<Integer> result = new ArrayList<>();
            return result;
        }

        //recursive call on root.right
        ArrayList<Integer> right = longestPath(root.right);

        //recursive call on root.left
        ArrayList<Integer> left = longestPath(root.left);

        //compare the size of the 2 ArrayList and insert current node accordingly
        if (right.size() < left.size()) {
            left.add(root.data);
        }
        else {
            right.add(root.data);
        }

        //return the appropriate ArrayList
        return left.size() > right.size() ? left : right;
    }

    //driver
    public static void main(String[] args) {
        Node root = newNode(100);
        root.left = newNode(20);
        root.right = newNode(130);
        root.left.left = newNode(10);
        root.left.right = newNode(50);
        root.left.left.left = newNode(5);
        root.right.left = newNode(110);
        root.right.right = newNode(140);

        ArrayList<Integer> output = longestPath(root);
        int n = output.size();

        System.out.print(output.get(n - 1));
        for(int i = n - 2; i >= 0; i--)
        {
            System.out.print(" -> " + output.get(i));
        }
    }
}
