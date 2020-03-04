/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    HashMap<Integer,TreeNode> nn=new HashMap<>();
    HashMap<Integer,Integer> depth=new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        
        traverse(root,x,y,0,0);
        
       if(nn.get(x)!=nn.get(y) && depth.get(x)==depth.get(y)){
           return true;
       }
        return false;
        
    }
    
    private void traverse(TreeNode node,int x,int y,int countL,int countR){
        
        if(node==null){
            return;
        }
        
        if(node.left!=null){
            if(node.left.val==x){
                nn.put(x,node);
                depth.put(x,countL);

            }
            if(node.left.val==y){
                nn.put(y,node);
                depth.put(y,countL);

            }
            
            
        }
        
        if(node.right!=null){
            if(node.right.val==x){
                nn.put(x,node);
                depth.put(x,countR);

            }
            if(node.right.val==y){
                nn.put(y,node);
                depth.put(y,countR);

            }
            
            
        }
        countL++;
        countR++;
        traverse(node.left,x,y,countL,countR);
        traverse(node.right,x,y,countL,countR);

    }
}