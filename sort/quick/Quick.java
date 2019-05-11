package sort.quick;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static sort.utils.Utils.*;

/**
 * 快速排序
 */
public class Quick {

    @Test
    public void quickTest(){
        Integer[] example={2,1,4,1,5,7,2,3,9,10};
        sort(example);
        show(example);
    }

    public static void sort(Comparable[] a){
        //将输入数组进行乱序处理, 消除对输入的依赖
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if (lo>=hi)
            return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    /**
     * 对数组a[lo,hi]进行切分, 使得切分点左边的都是小于切分点的元素, 右边都是大于切分点的元素
     * @param a
     * @param lo
     * @param hi
     * @return 返回切分点在数组的索引
     */
    private static int partition(Comparable[] a,int lo,int hi){
        int i=lo;
        int j=hi+1;
        //选取切分点
        Comparable cutPoint=a[lo];
        while(true){
            //在数组左边寻找第一个大于切点的元素
            while(less(a[++i],cutPoint)){
                if (i==hi)
                    break;
            }
            //在数组右边寻找第一个小于切分点的元素
            while(less(cutPoint,a[--j])){
                if (j==lo)
                    break;
            }
            if (i>=j)
                break;
            //交换元素
            exchange(a,i,j);
        }
        //将切分点放置到正确位置
        exchange(a,lo,j);
        //返回切分点索引
        return j;
    }
}
