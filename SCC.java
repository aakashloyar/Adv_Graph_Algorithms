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



//the main idea
//as first step we init our parametrs where list and rev are adj list
//suppose scc1-> scc2.....->sccn
//so it is guranteed that if you do dfs then in top of stack
//you will get at least 1node guranted of scc1 and then at least 1 node of scc2
//now after scc2 scc1 nodes can be there but scc3 1st node will come after scc2
//so that is how it is giving
//now we just reverse our edges
//so now scc1<-scc2<-.......sccn
//now we pop from stack so first we will visit scc1 first
// now we cannot go to other scc from scc1
//after that we visit scc2 now we can go to scc1 but that is already visited
//that is how we will visit all our scc
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
        solve();
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
