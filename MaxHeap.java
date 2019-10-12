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
    int[] A;
    
    Heap(int[] A, int heap_size)
    {
       
        this.heap_size = heap_size;
        this.A = new int[this.heap_size];
        for(int i = 0;i<this.heap_size; i++)
            this.A[i] = A[i];
        
        BuildHeap();
    }
    
    public void printHeap()
    {
        for(int i =0;i<this.heap_size;i++)
        {
            System.out.print(this.A[i] + " ");
        }
    }
    
    public void BuildHeap()
    {
        for(int i = (this.heap_size - 1)/2 + 1;i>=0;i--)
        {
            heapify(this.A, i, this.heap_size);
        }
    }
    
    public void heapify(int[] A, int i, int n)
	{
	    int l = 2*i + 1;
	    int r = 2*i + 2;
	    int max = i;
	    if(l < n && A[l] > A[max])
	        max = l;
	    if(r < n && A[r] > A[max])
	        max = r;
	    if(max!=i)
	    {
	        int temp = A[max];
	        A[max] = A[i];
	        A[i] = temp;
	        
	        heapify(A, max , n);
	    }
	}
	
	public int extractMax()
	{
	    if(this.heap_size<1)
	        return -1;
	    int ret = this.A[0];
	    this.A[0] = this.A[this.heap_size-1];
	    this.heap_size -- ;
	    heapify(A, 0, heap_size);
	    return ret;
	}
	
	public void increaseKeyTo(int index, int val)
	{
	    if(index < 0 || index >= this.heap_size)
	        return;
	        
	    this.A[index] = val;
	    
	    while(index > 0 && this.A[index] > this.A[(index-1)/2])
	    {
	        int temp = this.A[index];
	        this.A[index] = this.A[(index-1)/2];
	        this.A[(index-1)/2] = temp;
	        index = (index-1)/2;
	    }
	}
    
}

public class Main
{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
		int n = A.length;
		
		Heap heap = new Heap(A, n);
		
		heap.printHeap();
		//System.out.println("Maximun = " + heap.extractMax());
		//heap.printHeap();
		//System.out.println();
		//heap.increaseKeyTo(3 , 100);
		//heap.printHeap();
		
		System.out.println();
		
		heapSort(A, n);
		for(int i : A)
		    System.out.print(i + " ");
		
	}
	
	static void heapSort(int[] A, int n)
	{
	    Heap heap = new Heap(A, n);
	    
	    for(int i = n-1;i>=0;i--)
	    {
	        A[i] = heap.extractMax();
	    }
	}
	
	
}
