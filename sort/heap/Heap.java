package sort.heap;

import org.junit.Test;

import static sort.utils.Utils.*;

/**
 * 二叉堆排序
 */
public class Heap {

    @Test
    public void heapTest(){
        Character[] example={null,'S','O','R','T','E','X','A','M','P','L','E'};
        sort(example);
        show(example);
    }

    public static void sort(Comparable[] a){
        int N=a.length-1;
        //堆的构造
        for (int i=N/2;i>=1;i--){
            sink(a,i,N);
        }
        //下沉排序
        while(N>1){
            exchange(a,1,N--);
            sink(a,1,N);
        }
    }

    /**
     * 上浮
     * @param a
     * @param k
     */
    private static void swim(Comparable[] a,int k){
        while(k>1&&less(a[k/2],a[k])){
            exchange(a,k/2,k);
            k=k/2;
        }
    }

    /**
     * 下沉
     * @param a
     * @param k
     * @param N
     */
    private static void sink(Comparable[] a,int k,int N){
        while(2*k<=N){
            int j=2*k;
            if (j<N&&less(a[j],a[j+1]))
                j++;
            if (less(a[j],a[k]))
                break;
            exchange(a,k,j);
            k=j;
        }
    }
}
