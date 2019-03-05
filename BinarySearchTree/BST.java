import java.util.Scanner;

public class BST {

     //Why static inner class? Read https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     private static class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int val) {
            data = val;
        }
    }

    /*Find height of binary search tree*/
    private static int maxHeight = 0;

    public static void getHeightRec(Node root, int height) {
        if(height > maxHeight) {
            maxHeight = height;
        }

        if(root.left != null) {
            getHeightRec(root.left, height+1);
        }
        if(root.right != null) {
            getHeightRec(root.right, height+1);
        }
        return;
    }

    public static int getHeight(Node root){
        if(root != null) {
            getHeightRec(root, 0);
            return maxHeight;
        }
        else
            return 0;
    }
    /**********************************************************/

    /*Given a root node insert an element into BST */

    public static Node insert(Node root,int val) {
        if(root == null) {
            Node p = new Node(val);
            root = p;
            return root;
        }
        else
            insertRec(root, val);

        return root;
    }

    public static void insertRec(Node root,int data) {
        if(data < root.data) {
            if(root.left == null) {
                Node p = new Node(data);
                root.left = p;
            }
            else
                insertRec(root.left, data);
        }
        else {
            if(root.right == null) {
                Node p = new Node(data);
                root.right = p;
            }
            else
                insertRec(root.right, data);
        }
    }

    /*********************************************************/

    /*Search an element in BST */

    private static boolean searchKey(Node root, int key) {
        if(root == null)
            return false;

        if(root.data == key)
            return true;
        else if(root.data < key)
            return searchKey(root.right, key);
        else
            return searchKey(root.left, key);
    }
    /*********************************************************/

    public static void main(String []args) {
        Node root = null;
        Scanner sc = new Scanner(System.in);
        int input = 0;

        System.out.println("Enter elements. On completion enter -1! ");
        while(true) {
            input = sc.nextInt();
            if(input == -1)
                break;
            root = insert(root, input);
        }

        System.out.println("Height of the tree is " + getHeight(root));

        input = 0;
        while(true) {
            System.out.println("Enter element to search, On completion enter -1! ");
            input = sc.nextInt();
            if(input == -1)
                break;
            System.out.println("Element exists " + searchKey(root, input));
        }
    }
}
