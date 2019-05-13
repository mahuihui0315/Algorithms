package sort.priorityqueue;

import static sort.utils.Utils.exchange;
import static sort.utils.Utils.less;

public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N=0;
    public MaxPQ(int maxN){
        pq=(Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(Key value){
        pq[++N]=value;
        swim(N);
    }

    public Key deleteMax(){
        Key max=pq[1];
        exchange(pq,1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }

    private void swim(int k){
        while(k>1&&less(pq[k/2],pq[k])){
            exchange(pq,k/2,k);
            k/=2;
        }
    }

    private void sink(int k){
        while(2*k<=N){
            int j=2*k;
            if (j<N&&less(pq[j],pq[j+1]))
                j++;
            if (!less(pq[k],pq[j]))
                break;
            exchange(pq,k,j);
            k=j;
        }
    }
}
