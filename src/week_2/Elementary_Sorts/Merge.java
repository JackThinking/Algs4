package week_2.Elementary_Sorts;


import util.StdIn;
import util.StdOut;

/**
 * Created by Citrix on 2018/11/5.
 */
public class Merge {

    private Merge() {
    }

    private static void merge(Comparable[] a, Comparable aux[], int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            /*
             * 这边不取等于号
             * */
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[i], a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
        assert isSorted(a, lo, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a;
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    /*
     * 别忘记还有这辅助数组，很容易忘的
     * */
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        /*
         * 这边有个细节做的不好，应该单独拎出情况不好的情况
         * */
        for (int i = lo + 1; i <= hi; i++) {
            if (less(i, i - 1)) {
                return false;
            }
        }
        return true;
    }


    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Merge.sort(a);
        show(a);
    }
}



