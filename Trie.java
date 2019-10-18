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
		System.out.println(t.search("abced"));
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
    
}










