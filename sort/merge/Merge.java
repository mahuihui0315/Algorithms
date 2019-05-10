package sort.merge;

import org.junit.Test;

import static sort.utils.Utils.less;
import static sort.utils.Utils.show;

/**
 * 归并排序
 */
public class Merge {

    @Test
    public void mergeTest(){
        Integer[] example={2,1,4,1,5,7,2,3,9,10};
        sort(example);
        show(example);
    }

    private static Comparable[] tem;

    public static void sort(Comparable[] a){
        tem=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if (lo>=hi)
            return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }

    /**
     * 将数组的两个有序子数组归并
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a,int lo,int mid,int hi){
        int i=lo;
        int j=mid+1;
        for (int k=lo;k<=hi;k++)
            tem[k]=a[k];
        for (int k=lo;k<hi;k++){
            if (i>mid)
                a[k]=tem[j++];
            else if (j>hi)
                a[k]=tem[i++];
            else if (less(tem[i],tem[j]))
                a[k]=tem[i++];
            else
                a[k]=tem[j++];
        }
    }
}
