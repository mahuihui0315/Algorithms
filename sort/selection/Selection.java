package sort.selection;

import org.junit.Test;

import static sort.utils.Utils.*;

/**
 * 选择排序
 */
public class Selection {

    @Test
    public void selectionTest(){
        Integer[] example={2,1,4,1,5,7,2,3,9,10};
        sort(example);
        show(example);
    }

    public static void sort(Comparable[] a){
        int len=a.length;
        for (int i=0;i<len;i++){
            int min=i;
            for (int j=i+1;j<len;j++){
                if (less(a[j],a[min]))
                    min=j;
            }
            exchange(a,i,min);
        }
    }
}
