/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws IOException{
		Trie t = new Trie();
		t.insert("abc");
		t.insert("bcd");
		t.insert("abcd");
		t.insert("ab");
		System.out.println(t.count);
		t.delete("abc");
		t.delete("abcd");
		t.delete("ab");

		//t.insert("abc");
		System.out.println(t.search("ab"));
	}
}


class Trie
{
    static int count = 0;
    TrieNode root;
    
    Trie()
    {
        root = new TrieNode();
    }
    
    
    class TrieNode
    {
        Map<Character, TrieNode> map;
        boolean eow;
        
        TrieNode()
        {
            map = new HashMap<>();
            eow = false;
        }
    }
    
    public void insert(String str)
    {
        TrieNode temp = root;
        int size = str.length();
        for (int i = 0;i<size ; i++)
        {
            char ch = str.charAt(i);
            if(temp.map.containsKey(ch))
                temp = temp.map.get(ch);
            else
            {
                TrieNode t = new TrieNode();
                temp.map.put(ch, t);
                temp = t;
            }
        }
        
        temp.eow = true;
        count++;
    }
    
    public boolean search(String str)
    {
        TrieNode temp = root;
        boolean flag = true;
        int size = str.length();
        for(int i = 0;i<size;i++)
        {
            char ch = str.charAt(i);
           if(temp.map.containsKey(ch))
               temp = temp.map.get(ch);
            else
            {
                flag = false;
                break;
            }
        }
        if(!flag)
            return flag;
        return temp.eow;
    }
    
    
    public void delete(String str)
    {
        TrieNode temp = root;
        int size = str.length();
        Stack<TrieNode> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        boolean flag = true;
        for(int i =0;i<size;i++)
        {
            char ch = str.charAt(i);
            if(!temp.map.containsKey(ch))
            {
                flag = false;
                break;
            }
            s1.push(temp);
            s2.push(ch);
            temp = temp.map.get(ch);
            
        }
        
        if(!flag || !temp.eow){
            System.out.println("string " + str + " not found");
            return;
        }
        temp.eow = false;
        while(!s1.empty() && !s2.empty())
        {
            TrieNode t = s1.pop();
            char ch = s2.pop();
            if(!t.map.get(ch).map.isEmpty() || t.map.get(ch).eow)
            {
                break;
            }
            t.map.remove(ch);
        }
        System.out.println("string " + str + " deleted successfully.");
        count--;
        
    }
    
    
    
}
