/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Tree tree = new Tree(); 
	    
	    tree.insert(1);
	    tree.insert(2);
	    tree.insert(3);
	    tree.insert(4);
	    tree.insert(5);
	    tree.insert(6);
	    tree.insert(7);
	    tree.insert(8);
	    tree.insert(9);
	    tree.insert(10);
	    tree.insert(11);
	    tree.insert(12);
	    tree.insert(13);
	    tree.insert(14);
	    tree.insert(15);
	    
	    tree.rootToLeafPrint();
	    //tree.preorder(tree.root);
	    //System.out.println(tree.root.left.left.data);
	   // tree.inorder(tree.root);
	   // System.out.println();
	   // tree.postOrder();
	}
}

class Tree
{
    TreeNode root;
    
    class TreeNode
    {
        int data;
        TreeNode left;
        TreeNode right;
        boolean visited;
        TreeNode(int data)
        {
            this.data = data;
            visited = false;
        }
    }
    
    public void insert(int data)
    {
        TreeNode t = new TreeNode(data);
        
        if(root == null)
            root = t;
        else
        {
            Queue<TreeNode> q = new LinkedList();
            TreeNode temp = root;
            q.offer(temp);
            while(!q.isEmpty())
            {
                temp = q.poll();
                if(temp.left == null)
                {
                    temp.left = t;
                    break;
                }
                q.offer(temp.left);
                if(temp.right == null)
                {
                    temp.right = t;
                    break;
                }
                q.offer(temp.right);
            }
            
        }
    }
    
    public void rootToLeafPrint()
    {
        ArrayList<TreeNode> list = new ArrayList<>();
        rootToLeafPrintHelper(this.root, list);
    }
    
    public void rootToLeafPrintHelper(TreeNode root, ArrayList<TreeNode> list)
    {
        if(root==null){
            
            System.out.println("null is running");
            return;
        }
        
        if(root.left==null && root.right == null)
        {
            list.add(root);
            printList(list);
            list.remove(root);
            return;
        }
        list.add(root);
        rootToLeafPrintHelper(root.left, list);
        
        rootToLeafPrintHelper(root.right, list);
        list.remove(root);
        
    }
    
    
    public void printList(ArrayList<TreeNode> list)
    {
        for(int i = 0;i<list.size();i++)
            System.out.print(list.get(i).data + " ");
        System.out.println();
    }
    
    public void inorder(TreeNode root)
    {
        if(root==null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    
    public void preorder(TreeNode r)
    {
        if(r != null){
            System.out.print(r.data + " ");
        
            this.preorder(r.left);
        
            this.preorder(r.right);
        }
    }
    
    public void postOrder()
    {
        Stack<TreeNode> s = new Stack<>();
        
        TreeNode temp = root;
        boolean flag = false;
        while(true)
        {
            while(temp!=null)
            {
                s.push(temp);
                temp = temp.left;
            }
            
            if(s.empty()) break;
            temp = s.peek();
            while(temp.right == null || temp.right.visited)
            {
                System.out.print(temp.data + " ");
                temp.visited = true;
                s.pop();
                if(s.empty())
                {
                    flag = true;
                    break;
                }
                temp = s.peek();
            }
            
            if(flag)
                break;
            temp = temp.right;
        }
    }
}
