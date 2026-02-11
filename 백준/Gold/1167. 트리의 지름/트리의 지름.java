import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, w;
        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static List<Edge>[] g;

    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static Pair bfs(int start, int n) {
        boolean[] vis = new boolean[n + 1];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;
        dist[start] = 0;

        int farNode = start;
        long farDist = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Edge e : g[cur]) {
                if (!vis[e.to]) {
                    vis[e.to] = true;
                    dist[e.to] = dist[cur] + e.w;
                    q.add(e.to);

                    if (dist[e.to] > farDist) {
                        farDist = dist[e.to];
                        farNode = e.to;
                    }
                }
            }
        }
        return new Pair(farNode, farDist);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());

            while (true) {
                int connectionNum = Integer.parseInt(st.nextToken());
                if (connectionNum == -1) break;
                int w = Integer.parseInt(st.nextToken());

                g[nodeNum].add(new Edge(connectionNum, w));
            }
        }

        // 1) 아무 노드(1)에서 가장 먼 노드 A 찾기
        Pair first = bfs(1, n);

        // 2) A에서 가장 먼 거리 = 트리의 지름
        Pair second = bfs(first.node, n);

        System.out.println(second.dist);
    }
}
