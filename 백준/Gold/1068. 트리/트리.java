import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] tree;
    static int cut;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new List[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        String line = br.readLine();
        String[] split = line.split(" ");
        int root = 0;
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(split[i]);
            if(t==-1)   root = i;
            else        tree[t].add(i);
        }
        cut = Integer.parseInt(br.readLine());

        //루트가 잘린다면
        if(cut == root){
            System.out.println(0);
            return;
        }
        dfs(root);
        System.out.println(cnt);
    }
    static void dfs(int cur){
        int validChild = 0;

        for(int next : tree[cur]){
            if(next == cut) continue;
            validChild++;
            dfs(next);
        }
        if(validChild == 0) cnt++;
    }

}