//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    ArrayList<Integer> result;
    Set<Node> set;
    public void iterateLeafNode(Node node){
        
        if(node==null)
         return;
         if(node.left==null && node.right==null){
             if(!set.contains(node)){
                 result.add(node.data);
                 set.add(node);
             }
             return;
         }
        iterateLeafNode(node.left);
        iterateLeafNode(node.right);
        return;
        
    }
    public void iterateLeftSubtree(Node node,Node start){
        
        if(node==null)
         return;
        result.add(node.data);
        set.add(node);
        iterateLeftSubtree(node.left,start);
        if(node.left==null && node!=start){
             iterateLeftSubtree(node.right,start);
        }
        return;
        
        
    }
    public void iterateRightSubTreee(Node node,Node start){
        
        if(node==null)
         return;
    
        iterateRightSubTreee(node.right,start);
        if(node.right==null && start!=node){
            iterateRightSubTreee(node.left,start);
        }
        if(!set.contains(node)){
                 result.add(node.data);
                 set.add(node);
             }
        return;
        
        
    }
	ArrayList <Integer> boundary(Node node)
	{
	    result=new ArrayList<>();
	    set=new HashSet<>();
	    iterateLeftSubtree(node,node);
	    iterateLeafNode(node);
	    iterateRightSubTreee(node,node);
	    
	    return result;
	    
	    
	}
}
