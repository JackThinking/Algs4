package week_2.Elementary_Sorts;

/**
 * Created by Citrix on 2018/11/6.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            /*
            * 上面的循环走一步子
            * */
            for (int i = h; i < N; i++) {
                /*
                * 这下面的循环走h的大步子，且是从后面向前面走
                * */
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
