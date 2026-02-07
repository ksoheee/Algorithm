import java.util.*;
import java.io.*;

public class Main {

    static List<List<Integer>> nodes = new ArrayList<>();
    static int[] dist;          //순환선 까지의 거리
    static int[] degree;        //각 노드 차수
    static boolean[] removed;   //잘려간 노드 표시
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++){
            nodes.add(new ArrayList<>());
        }
        dist = new int[n+1];
        degree = new int[n+1];
        removed = new boolean[n+1];

        Arrays.fill(dist, -1);

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            nodes.get(b).add(a);
            //간선을 입력받았으니 ++
            degree[a]++; degree[b]++;
        }

        //1 사이클 노드 확인
        Queue<Integer> q = new LinkedList<>();
        //간선이 1인 노드 전부 큐에 넣기
        for(int i = 1; i <= n; i++){
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            if(removed[cur]) continue; //이미 처리했으면 스킵
            //리프노드 제거 표시
            removed[cur] = true;

            //제거한 리프노드의 아직 제거되지 않은 이웃한 노드들의 간선 제거하여 새로운 리프노드 찾음
            for(int node : nodes.get(cur)){
                if(removed[node]) continue; //이미 제거됐으면 스킵
                degree[node]--;
                if(degree[node] == 1){
                    q.offer(node);
                }
            }
        }

        //2 거리 계산하기
        //removed[]=false인 노드들이 순환선
        q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            //순환선과 가지들의 거리를 구하기 위해 순환선을 큐에 넣는다
            if(!removed[i]){
                dist[i] = 0;
                q.offer(i);
            }
        }

        //큐에 순환선들을 미리 집어넣고 차례대로 꺼내면서 순환선에서 가지의 거리를 구함
        while(!q.isEmpty()){
            int cur = q.poll();

            for(int node : nodes.get(cur)){
                if(dist[node] == -1){
                    //순환선에서 부터 거리를 +1씩 늘려가며 순환선에서 노드까지의 거리를 구함
                    dist[node] = dist[cur] + 1;
                    q.offer(node);
                }
            }
        }

        for(int i=1; i <= n; i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();

    }


}