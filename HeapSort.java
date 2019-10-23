/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        heapSort(A);
	}
	
	static int[] buildHeap(int[] A, int n)
	{
	    for(int i = n/2 -1; i>=0 ; i--)
	    {
	        heapify(A, n, i);
	    }
	    
	    return A;
	}
	
	static void heapify(int[] A, int n, int i)
	{
	    int l = 2*i + 1;
	    int r = 2*i + 2;
	    int max = i;
	    if(l<n && A[l]>A[max])
	        max = l;
	    if(r<n && A[r] > A[max])
	        max = r;
	        
	    if(max!=i)
	    {
	        int temp = A[max];
	        A[max] = A[i];
	        A[i] = temp;
	        
	        heapify(A, n , max);
	    }
	}
	
	static void heapSort(int[] A)
	{
	    int l = A.length;
	    A = buildHeap(A, l);
	    while(l>0)
	    {
	        int temp = A[l-1];
	        A[l-1] = A[0];
	        A[0] = temp;
	        
	        l--;
	        heapify(A, l, 0);
	    }
	    
	    
	    for(int i : A)
	    {
	        System.out.print(i + " ");
	    }
	}
}
