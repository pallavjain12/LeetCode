//{ Driver Code Starts
import java.util.Scanner;
import java.io.*;
class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
class BinarySearchTree {
    public static Node root;
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }
 
    public static void inorder()  {
       inorderRec(root);
    }
    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []a=new int[n];
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            GFG obj=new GFG();
            boolean k=obj.isDeadEnd(root);
            if(k==true)
            System.out.println("1");
            else
            System.out.println("0");
        }       
    }
}


// } Driver Code Ends


/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/


class GFG {
    public static boolean isDeadEnd(Node root) {
        java.util.HashMap<Integer, Integer> map = new java.util.HashMap<>();
        return traverseTree(root, map);
    }
    
    private static boolean traverseTree(Node root, java.util.HashMap<Integer, Integer> map) {
        if (root == null) return false;
        if ((map.containsKey(root.data - 1 ) || root.data == 1) && map.containsKey(root.data + 1))   return true;
        map.put(root.data, 0);
        if (traverseTree(root.left, map))   return true;
        if (traverseTree(root.right, map))  return true;
        map.remove(root.data);
        return false;
    }
}

/*
public class Solution {
    public static Boolean isDeadEnd(TreeNode<Integer> root) {
        return traverseTree(root, new HashMap<Integer, Integer>());
    }
    private static boolean traverseTree(TreeNode<Integer> root, HashMap<Integer, Integer> map) {
        if (root == null)   return false;
        if (root.data == -1)    return false;
        if ((map.containsKey(root.data - 1) || root.data - 1 == 0) && (map.containsKey(root.data + 1))) return true;
        map.put(root.data, 0);
        boolean temp = false;
        if (root.left != null)
            temp = traverseTree(root.left, map);
        if (temp) return temp;
        if (root.right != null)
            temp = traverseTree(root.right, map);
        map.remove(root.data);
        return temp;
    }
}

*/