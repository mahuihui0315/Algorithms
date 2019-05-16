package search.binarysearchTree;

public class BST<Key extends Comparable<Key>,Value> {
    private class Node{
        private Key key;
        private Value val;
        private Node left;
        private Node right;
        private int N;

        public Node(Key key, Value val,int N){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }

    private Node root;

    public int size(){
        return size(root);
    }

    private int size(Node root){
        if (root==null)
            return 0;
        else
            return root.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    /**
     * 查找key, 存在就返回val, 不存在就返回null
     * @param root
     * @param key
     * @return
     */
    private Value get(Node root,Key key){
        if (root==null)
            return null;
        int compare=key.compareTo(root.key);
        if (compare<0){
            return get(root.left,key);
        }else if (compare>0){
            return get(root.right,key);
        }else{
            return root.val;
        }
    }

    public void put(Key key,Value val){
        root=put(root,key,val);
    }

    /**
     * 查找key, 存在就更新val, 不存在就以key-val新增节点
     * @param key
     * @param val
     */
    private Node put(Node root,Key key,Value val){
        if (root==null)
            return new Node(key,val,1);
        int compare=key.compareTo(root.key);
        if (compare<0){
            root.left=put(root.left,key,val);
        }else if (compare>0){
            root.right=put(root.right,key,val);
        }else{
            root.val=val;
        }
        return root;
    }

    public Key max(){
        return null;
    }
    
}
