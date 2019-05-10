package sort.insertion;

import org.junit.Test;

import static sort.utils.Utils.*;

/**
 * 插入排序
 */
public class Insertion {

    @Test
    public void insertionTest(){
        Integer[] example={2,1,4,1,5,7,2,3,9,10};
        sort(example);
        show(example);
    }

    public static void sort(Comparable[] a){
        int len=a.length;
        for (int i=0;i<len;i++){
            for (int j=i;j>0;j--){
                if (less(a[j],a[j-1]))
                    exchange(a,j-1,j);
            }
        }
    }
}
