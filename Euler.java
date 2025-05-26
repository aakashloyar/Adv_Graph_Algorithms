package Graph;
import java.util.*;
public class Euler {
    static ArrayList<Integer>[] list;
    static boolean[] v;
    static ArrayList<Integer> res;
    public static void main(String[] args) {
        int n=10;
        list=new ArrayList[n];
        res=new ArrayList<>();
        v=new boolean[n];
    }
    static void solve(int curr) {
        ArrayList<Integer> internal=list[curr];
        while(!internal.isEmpty()) {
            int next=internal.removeLast();
            if(v[next]) continue;
            v[next]=true;
            solve(next);
        }
        res.add(curr);
    }
}
//euler path
//visiting all vertices without visiting any edge twice  and takiing pencil up
//maximum 2 node have odd degree

//euler circuit
//euler path with same starting and ending node
//all node must have even degree

//heriholzer's algorthm ******

//for directed graph
//at most 1 has ind-out==1
//at most 1 has out-ind==1
//start from out-ind==1 otherwise from manywhere
//donot think that it will not work just dry run