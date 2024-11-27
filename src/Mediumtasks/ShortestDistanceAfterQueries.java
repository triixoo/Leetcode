package Mediumtasks;
import java.util.*;
public class ShortestDistanceAfterQueries {
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            // Adjacency list representation of the graph
            List<List<int[]>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            // Initialize the linear graph
            for (int i = 0; i < n - 1; i++) {
                graph.get(i).add(new int[] {i + 1, 1});
            }

            int[] result = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                int u = queries[i][0];
                int v = queries[i][1];
                graph.get(u).add(new int[] {v, 1}); // Add the new road

                // Use Dijkstra's algorithm to find the shortest path
                result[i] = dijkstra(graph, n);
            }

            return result;
        }

        private int dijkstra(List<List<int[]>> graph, int n) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;

            pq.offer(new int[] {0, 0}); // Start from city 0 with distance 0

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int node = curr[0];
                int distance = curr[1];

                if (distance > dist[node]) {
                    continue;
                }

                for (int[] neighbor : graph.get(node)) {
                    int nextNode = neighbor[0];
                    int weight = neighbor[1];
                    if (dist[node] + weight < dist[nextNode]) {
                        dist[nextNode] = dist[node] + weight;
                        pq.offer(new int[] {nextNode, dist[nextNode]});
                    }
                }
            }

            return dist[n - 1];
        }
    }

}
