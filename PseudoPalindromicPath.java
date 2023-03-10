import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class PseudoPalindromicPath {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        Node root = new Node(Integer.parseInt(ip[0]));
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            Node currNode = queue.peek();
            queue.remove();
                
            String currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }
                
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            if(!currVal.equals("N")) {
                    
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Solution g = new Solution();
    	        System.out.println(g.pseudoPalindromicPaths(root));
    	    }
	}
}

class Solution {
    private int res = 0;
    public int pseudoPalindromicPaths (Node root) {
        
        //Write Code here
        
        int[] arr = new int[10];
        dfs (root, arr);

        return res;
    }

    void dfs (Node root, int[] map)
    {
        if(root == null) return;

        map[root.data] = map[root.data] + 1;
        if(root.left == null && root.right == null)
        {
            if (isPalindrom(map)) res++;
        }

        dfs(root.left, map);
        dfs(root.right, map);
    }

    boolean isPalindrom(int[] map)
    {
        int count = 0;
        for(int i=0;i<10;i++)
        {
            if(map[i] % 2 != 0) count++;

            if(count > 1) return false; 
        }
        return true;
    }
}