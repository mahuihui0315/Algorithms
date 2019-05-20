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

    public Key max(Key key){
        return max(root,key).key;
    }

    /**
     * 寻找最大的key并返回
     * @param root
     * @param key
     * @return
     */
    private Node max(Node root,Key key){
        if (root.right==null){
            return root;
        }
        return max(root.right,key);
    }

    public Key min(Key key){
        return min(root,key).key;
    }

    /**
     * 寻找最小的key并返回
     * @param root
     * @param key
     * @return
     */
    private Node min(Node root,Key key){
        if (root.left==null){
            return root;
        }
        return min(root.left,key);
    }

    public Key select(int k){
        return select(root,k).key;
    }

    /**
     * 寻找排名为k的key
     * @param root
     * @param k
     * @return
     */
    private Node select(Node root,int k){
        if (root==null){
            return null;
        }
        int t=size(root.left);
        if (t>k){
            return select(root.left,k);
        }else if (t<k){
            return select(root.right,k-t-1);
        }else{
            return root;
        }
    }

    public int rank(Key key){
        return rank(root,key);
    }

    /**
     * 寻找key在二叉树中的排名
     * @param root
     * @param key
     * @return
     */
    private int rank(Node root,Key key){
        if (root==null){
            return 0;
        }
        int compare=key.compareTo(root.key);
        if (compare<0){
            return rank(root.left,key);
        }else if (compare>0){
            return rank(root.right,key)+size(root.left)+1;
        }else{
            return size(root.left);
        }
    }
}
