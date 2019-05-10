package sort.utils;

import org.jetbrains.annotations.NotNull;

public class Utils {
    public static boolean less(@NotNull Comparable a, Comparable b){
        return a.compareTo(b)<0;
    }

    public static void exchange(Comparable[] a,int i,int j){
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    public static void show(Comparable[] a){
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+"  ");
        }
        System.out.println();
    }
}
