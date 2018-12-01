package week_1.Union_Find;

/**
 * Created by Citrix on 2018/8/17.
 */
public class WeightedQuickUnionUF {
    private int[] parent;
    private int[] size;//权值记录
    private int count;//count没啥用呀

    public WeightedQuickUnionUF(int N){
        parent = new int[N];
        size = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int count() {
        return count;
    }

    private int root(int i){
        while(i != parent[i]){
            parent[i] = parent[parent[i]];//这一步就是扁平化
            i = parent[i];
        }
        return i;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);

        /*
        * 改进点：小树并到大树，这个树是指几颗树而不是树高
        * */
        if (size[i]<size[j]){
            parent[i] = j;
            size[j] += size[i];
        }
        else{
            parent[j] = i;
            size[i] += size[j];
        }
        count--;
    }


}
