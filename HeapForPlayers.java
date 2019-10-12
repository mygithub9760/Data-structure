/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;

class Heap
{
    int heap_size;
    Player[] A;
    
    Heap(Player[] A, int heap_size)
    {
       
        this.heap_size = heap_size;
        this.A = new Player[this.heap_size];
        for(int i = 0;i<this.heap_size; i++)
            this.A[i] = A[i];
        
        BuildHeap();
    }
    
    public void printHeap()
    {
        for(int i =0;i<this.heap_size;i++)
        {
            System.out.print(this.A[i].name + " ");
        }
    }
    
    public void BuildHeap()
    {
        for(int i = (this.heap_size - 1)/2 + 1;i>=0;i--)
        {
            heapify(this.A, i, this.heap_size);
        }
    }
    
    public void heapify(Player[] A, int i, int n)
	{
	    int l = 2*i + 1;
	    int r = 2*i + 2;
	    int max = i;
	    if(
	        (l < n && A[l].odi_score > A[max].odi_score) ||
	        (l < n && A[l].odi_score == A[max].odi_score && A[l].test_score > A[max].test_score)
	      )
	        max = l;
	        
	    if(
	        (r < n && A[r].odi_score > A[max].odi_score) ||
	        (r < n && A[r].odi_score == A[max].odi_score && A[r].test_score > A[max].test_score)
	      )
	        max = r;
	        
	    if(max!=i)
	    {
	        Player temp = A[max];
	        A[max] = A[i];
	        A[i] = temp;
	        
	        heapify(A, max , n);
	    }
	}
	
	public Player extractMax()
	{
	    if(this.heap_size<1)
	        return null;
	    Player ret = this.A[0];
	    this.A[0] = this.A[this.heap_size-1];
	    this.heap_size -- ;
	    heapify(A, 0, heap_size);
	    return ret;
	}
	
    
}

class Player
{
    String name;
    int odi_score;
    int test_score;
    Player(String name, int odi_score, int test_score)
    {
        this.name = name;
        this.odi_score = odi_score;
        this.test_score = test_score;
    }
}

public class Main
{
	public static void main(String[] args) throws IOException{
	    
	    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		Player[] players = new Player[n];
		for(int i = 0 ;i<n;i++)
		{
		    String[] str = br.readLine().trim().split(" ");
		    String name = str[0].trim();
		    int odi = Integer.parseInt(str[1]);
		    int test = Integer.parseInt(str[2]);
		    players[i] = new Player(name, odi, test);
		}
		
		Heap heap = new Heap(players, n);
		
		heap.printHeap();
		//System.out.println("Maximun = " + heap.extractMax());
		//heap.printHeap();
		//System.out.println();
		//heap.increaseKeyTo(3 , 100);
		//heap.printHeap();
		
		System.out.println();
		
		heapSort(players, n);
		for(Player i : players)
		    System.out.print(i.name + " ");
		
	}
	
	static void heapSort(Player[] A, int n)
	{
	    Heap heap = new Heap(A, n);
	    
	    for(int i = n-1;i>=0;i--)
	    {
	        A[i] = heap.extractMax();
	    }
	    
	    
	}
	
	
}
