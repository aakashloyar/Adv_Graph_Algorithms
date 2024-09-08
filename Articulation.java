package Graph;

import java.util.*;
public class Articulation {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=0;i<5;i++) list.add(new ArrayList<>());
        list.get(0).add(1);
        list.get(1).add(0);
        list.get(1).add(4);
        list.get(4).add(1);
        list.get(4).add(3);
        list.get(3).add(4);
        list.get(3).add(2);
        list.get(2).add(3);
        list.get(2).add(4);
        list.get(4).add(2);
        AP obj=new AP(list,5);
        obj.solve();
        ArrayList<Integer>res=obj.res;
        for(int i=0;i<res.size();i++) {
            System.out.println(res.get(i));
        }
    }
    static void solve() {

    }

}
//Articulation point
class AP {
    int n;
    int timer;
    int[] t;
    int[] low;
    boolean[] v;
    boolean[] mark;
    ArrayList<Integer> res;
    ArrayList<ArrayList<Integer>> list;
    AP(ArrayList<ArrayList<Integer>> list,int n) {
        timer=1;
        this.list=list;
        this.n=n;
        this.low=new int[n];
        this.t=new int[n];
        res=new ArrayList<>();
        v=new boolean[n];
        mark=new boolean[n];
    }
    void solve() {
        for(int i=0;i<n;i++) {
            if(!v[i]) {
                dfs(i,-1);
            }
        }
        for(int i=0;i<n;i++) {
            if(mark[i]) res.add(i);
        }
    }
    void dfs(int curr,int prev) {
        v[curr]=true;
        t[curr]=low[curr]=timer++;
        int child=0;
        ArrayList<Integer> internal=list.get(curr);
        for(int i=0;i<internal.size();i++) {
            int next=internal.get(i);
            if(next==prev) continue;
            if(!v[next]) {
                dfs(next,curr);
                low[curr]=Math.min(low[curr],low[next]);
                if(low[next]>=t[curr]&& prev!=-1) {
                    mark[curr]=true;
                }
                child++;
            } else {
                low[curr]=Math.min(low[curr],t[next]);
            }

        }
        if(prev==-1 &&child>1) mark[curr]=true;
    }
}
