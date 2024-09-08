package Graph;
import java.util.*;
public class SCC {
    public static void main(String[] args) {

    }
}
//KosaRaju
//only for directed graph
//scc1-> scc2-> scc3
//step1-> store in stack according to scc1-> ...->sccn
//step2-> reverse list
//step3-> do dfs and store

class KR {
    ArrayList<ArrayList<Integer>> list;
    ArrayList<ArrayList<Integer>> rev;
    ArrayList<ArrayList<Integer>> res;
    int n;
    boolean[] v;
    KR(ArrayList<ArrayList<Integer>> list,int n) {
        this.list=list;
        this.rev=new ArrayList<>();
        this.res=new ArrayList<>();
        this.n=n;
        this.v=new boolean[n];
        make();
    }
    void make() {
        for(int i=0;i<n;i++) {
            rev.add(new ArrayList<>());
        }
        for(int i=0;i<list.size();i++) {
            ArrayList<Integer> internal=list.get(i);
            for(int j=0;j<internal.size();j++) {
                int next=internal.get(j);
                rev.get(next).add(i);
            }
        }
    }
    void solve() {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++) {
            if(!v[i]) {
                dfs(s,i);
            }
        }
        v=new boolean[n];
        while(!s.isEmpty()) {
            int curr=s.pop();
            if(v[curr]) continue;
            ArrayList<Integer> add=new ArrayList<>();
            dfs2(add,curr);
            res.add(add);
        }
    }
    void dfs2(ArrayList<Integer> add,int curr) {
        v[curr]=true;
        add.add(curr);
        ArrayList<Integer> internal=rev.get(curr);
        for(int i=0;i<internal.size();i++) {
            int next=internal.get(i);
            if(v[next]) continue;
            dfs2(add,next);
        }
    }
    void dfs(Stack<Integer> s,int curr) {
        v[curr]=true;
        ArrayList<Integer> internal=list.get(curr);
        for(int i=0;i<internal.size();i++) {
            int next=internal.get(i);
            if(v[next]) continue;
            dfs(s,next);
        }
        s.push(curr);
    }

}
