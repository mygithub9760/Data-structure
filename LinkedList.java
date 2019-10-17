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
