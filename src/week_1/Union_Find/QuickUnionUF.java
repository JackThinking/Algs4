package week_1.Union_Find;

/**
 * Created by Citrix on 2018/8/17.
 */
public class QuickUnionUF {

    private int[] id;

    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    /*
    * id[i] = i 可以理解为建立指向，i = id[i]理解为按指针取值，知道取出来的值等于其本身序号
    * */
    private int root(int i){
        while(i != id[i]){
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
            return root(p) == root(q);
    }

    /*
    * quickunion的含义就是union操作简单
    * */
    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;

    }
}
