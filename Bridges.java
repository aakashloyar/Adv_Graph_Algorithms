package Graph;
import java.util.*;
public class Bridges {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<12;i++) list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(1).add(0);
        list.get(0).add(3);
        list.get(3).add(0);
        list.get(1).add(2);
        list.get(2).add(1);
        list.get(3).add(2);
        list.get(2).add(3);
        list.get(3).add(4);
        list.get(4).add(3);
        list.get(4).add(5);
        list.get(5).add(4);
        list.get(5).add(6);
        list.get(6).add(5);
        list.get(5).add(8);
        list.get(8).add(5);
        list.get(8).add(7);
        list.get(7).add(8);
        list.get(6).add(7);
        list.get(7).add(6);
        list.get(7).add(9);
        list.get(9).add(7);
        list.get(9).add(11);
        list.get(11).add(9);
        list.get(9).add(10);
        list.get(10).add(9);
        list.get(11).add(10);
        list.get(10).add(11);
        Tarjan obj=new Tarjan(list,12);
        obj.dfs();
        ArrayList<int[]>res=obj.res;
        for(int i=0;i<res.size();i++) {
            System.out.println(Arrays.toString(res.get(i)));
        }
    }
    static void solve() {

    }

}
class Tarjan {
    int n;
    int timer;
    int[] t;
    int[] low;
    ArrayList<int[]> res;
    ArrayList<ArrayList<Integer>> list;
    Tarjan(ArrayList<ArrayList<Integer>> list,int n) {
        timer=1;
        this.list=list;
        this.n=n;
        this.low=new int[n];
        this.t=new int[n];
        res=new ArrayList<>();
    }
    void dfs() {
        for(int i=0;i<n;i++) {
            if(t[i]==0) dfs(i,-1);
        }
    }
    int dfs(int curr,int prev) {
        if(t[curr]!=0) return low[curr];
        t[curr]=low[curr]=timer++;
        ArrayList<Integer> internal=list.get(curr);
        for(int i=0;i<internal.size();i++) {
            int next=internal.get(i);
            if(next==prev) continue;
            int x=dfs(next,curr);
            low[curr]=Math.min(low[curr],x);
            if(x>t[curr]) {
                res.add(new int[]{curr,next});
            }
        }
        return low[curr];
    }
}
