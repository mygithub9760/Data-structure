/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Tree root = new Tree();
	    root.insert(1);
	    root.insert(2);
	    root.insert(3);
	    root.insert(4);
	    root.insert(5);
	    
	    root.postOrder();
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
