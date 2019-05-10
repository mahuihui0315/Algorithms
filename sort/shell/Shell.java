package sort.shell;

import org.junit.Test;

import static sort.utils.Utils.*;

/**
 * 希尔排序
 */
public class Shell {

    @Test
    public void shellTest(){
        Integer[] example={2,1,4,1,5,7,2,3,9,10};
        sort(example);
        show(example);
    }

    public static void sort(Comparable[] a){
        int len=a.length;
        int h=1;
        while(h<len/3)
            h=3*h+1;
        while(h>=1){
            for (int i=h;i<len;i++){
                for (int j=i;j>=h;j-=h){
                    if (less(a[j],a[j-h]))
                        exchange(a,j,j-h);
                }
            }
            h/=3;
        }
    }
}
