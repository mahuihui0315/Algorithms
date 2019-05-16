package search.binary;

/**
 * 基于有序数组的二分查找
 */
public class BinarySearchST<Key extends Comparable<Key>,Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;

    /**
     * 通过构造函数初始化数组容量
     * @param capacity
     */
    public BinarySearchST(int capacity){
        keys=(Key[]) new Comparable[capacity];
        vals=(Value[]) new Comparable[capacity];
    }

    /**
     * 返回数组中的元素个数
     * @return
     */
    public int getSize(){
        return N;
    }

    /**
     * 获取指定key的value
     * @param key
     * @return
     */
    public Value get(Key key){
        if (key==null)
            return null;
        int i=rank(key);
        if (i<N&&keys[i].compareTo(key)==0)
            return vals[i];
        else
            return null;
    }

    /**
     * 存储key-value
     * @param key
     * @param val
     */
    public void put(Key key,Value val){
        if(N==keys.length)
            resize(keys.length*2);
        int i=rank(key);
        if (1<N&&keys[i].compareTo(key)==0){
            vals[i]=val;
            return;
        }
        for (int j=N;j>i;j--){
            keys[j]=keys[j-1];
            vals[j]=vals[j-1];
        }
        keys[i]=key;
        vals[i]=val;
        N++;
    }

    /**
     * 获取key小于输入参数的元素个数, 即输入参数在keys数组中的位置
     * @param key
     * @return
     */
    private int rank(Key key){
        int lo=0;
        int hi=N-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            int compare=key.compareTo(keys[mid]);
            if (compare>0)
                lo=mid+1;
            else if (compare<0)
                hi=mid-1;
            else
                return mid;
        }
        return lo;
    }

    /**
     * 调整keys和vals数组的大小
     * @param max
     */
    private void resize(int max){
        Key[] temp=(Key[]) new Comparable[max];
        Value[] temp1=(Value[]) new Comparable[max];
        for (int i=0;i<N;i++){
            temp[i]=keys[i];
            temp1[i]=vals[i];
        }
        keys=temp;
        vals=temp1;
    }
}
