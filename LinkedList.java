/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insert(1);
		list.insert(2);
		list.insert(4);
		list.insert(9);
		//System.out.println("First List");
		//list.print();
		LinkedList list2 = new LinkedList();
		list2.insert(10);
		list2.insert(20);
		list2.insert(30);
		list2.insert(40);
		//System.out.println();
		//System.out.println("Second List");
		//list2.print();
		
		//System.out.println(list.find(2));
		System.out.println("Before reversing");
		list.print();
		list.reverse();
		System.out.println("After reversing");
		list.print();
		System.out.println(list.isCircular());
		
	}
	
	static public LinkedList Merge(LinkedList l1, LinkedList l2)
	    {
		if(l1.head == null) return l2;
		if(l2.head == null) return l1;

		LinkedList result = new LinkedList();
		if(l1.head.data < l2.head.data)
		{
		    result.head = l1.head;
		    l1.head = l1.head.next;
		    result.head.next = Merge(l1, l2).head;
		}
		else
		{
		    result.head = l2.head;
		    l2.head = l2.head.next;
		    result.head.next = Merge(l1, l2).head;
		}
		return result;
	    }
	
}

class LinkedList
{
    Node head;
    
    class Node
    {
        int data;
        Node next;
        
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    
    public void insert(int data)
    {
        Node node = new Node(data);
        
        if(this.head == null)
        {
            this.head = node;
        }
        else
        {
            Node temp = this.head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
	
    public void insertInSorted(int data)
    {
        Node node = new Node(data);
        if(head == null)
        {
            head = node;
            return;
        }
        if(head.data >= data)
        {
            node.next = head;
            head = node;
            return;
        }
        
        Node temp = head;
        while(temp.next != null && temp.next.data < data)
            temp = temp.next;
        
        if(temp.next == null)
        {
            temp.next = node;
        
            return;
        }
        
        node.next = temp.next;
        temp.next = node;
        return;
    }
	
    public void delete(int data)
    {
        if(head == null)
            return;
        if(head.data == data)
        { 
            Node temp = head;
            head = head.next; 
            temp.next = null;
            return;
        }
        
        Node temp = head;
        while(temp.next != null && temp.next.data != data)
            temp = temp.next;
            
        if(temp.next == null) return;
        
        temp.next = temp.next.next;
        
        return;
    }
	
    public void deleteAt(int index)
    {
        if(head == null) return;
        if(index < 1) return;
        if(index == 1)
        {
            head = head.next;
            return;
        }
        
        Node temp = head;
        int i = 1;
        while(temp.next!=null && i<index-1)
        {
            temp = temp.next;
            i++;
        }
        
        if(temp.next == null) return;
        temp.next = temp.next.next;
        return;
    }
    
    public boolean find(int key)
    {
        if(this.head == null)
            return false;
        Node temp = this.head;
        while(temp != null)
        {
            if(temp.data == key)
                return true;
            temp = temp.next;
        }
        return false;
    }
    
    public void reverse()
    {
        Node prev = null;
        Node nextCurrent = null;
        //Node current = head;
        while(this.head!=null)
        {
            nextCurrent = this.head.next;
            this.head.next = prev;
            prev = this.head;
            this.head = nextCurrent;
        }
        this.head = prev;
    }
    
    public void reverseRec()
    {
        if(head == null || head.next == null) return;
        
        Node temp = head;
        head = head.next;
        temp.next = null;
        this.reverseRec();
        
        Node temp2 = head;
        while(temp2.next != null)
            temp2 = temp2.next;
        temp2.next = temp;
        
    }
	
	
	
     public Node reverseInPairs()
    {
        if(this.head == null)
            return this.head;
            
        if(this.head.next == null)
            return this.head;
            
        Node rest = this.head.next.next;
        
        this.head.next.next = null;
        Node next = this.head.next;
        this.head.next = null;
        next.next = this.head;
        this.head = next;
        
        LinkedList restList = new LinkedList();
        restList.head = rest;
        this.head.next.next = restList.reverseInPairs();
        return this.head;
    }	
	
	
    public Node reverseInK_airs(int k)
    {
        if(this.head == null)
            return this.head;
            
        if(this.head.next == null)
            return this.head;
            
        int i = 0;
        Node rest;
        Node temp = this.head;
        while(i<k-1 && temp != null)
        {
            temp = temp.next;
            i++;
        }
        if(temp == null)
        {
            rest = null;
        }
        else
        {
            rest = temp.next;
            temp.next = null;
        }
        
        LinkedList restList = new LinkedList();
        restList.head = rest;
        this.reverse();
        temp = this.head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = restList.reverseInK_airs(k);
        return this.head;
    }
	
	
    public LinkedList Merge(LinkedList l)
    {
        if(this.head == null) return l;
        if(l.head == null) return this;
        
        LinkedList result = new LinkedList();
        if(this.head.data < l.head.data)
        {
            result.head = this.head;
            this.head = this.head.next;
            result.head.next = this.Merge(l).head;
        }
        else
        {
            result.head = l.head;
            l.head = l.head.next;
            result.head.next = this.Merge(l).head;
        }
        return result;
    }
	
    
    public boolean isCircular()
    {
        Node fast = this.head;
        Node slow = this.head;
        while(slow!=null && fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow)
                return true;
        }
        return false;
    }
    
    public void print()
    {
        Node temp = this.head;
        while(temp != null)
        {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
