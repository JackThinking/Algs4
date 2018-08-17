package week_1.Union_Find;

/**
 * Created by Citrix on 2018/8/17.
 */
public class QuickFindUF {
    private int[] id;

    public QuickFindUF(int N){
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /*
    * quickfind的含义就是find操作简单
    * */
    public boolean connected(int p, int q){
        return id[p] == id[q];

    }
    /*
    * 所有前面连向p的都改成q
    * */
    public void union(int p, int q){
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (pid == id[i]){
                id[i] = qid;
            }

        }

    }
}

