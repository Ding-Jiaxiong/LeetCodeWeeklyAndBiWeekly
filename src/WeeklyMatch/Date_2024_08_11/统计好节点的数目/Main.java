package WeeklyMatch.Date_2024_08_11.统计好节点的数目;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static List<List<Integer>> tree;
    static int[] subtreeSizes;
    static int goodNodes;

    public static int countGoodNodes(int[][] edges) {

        int n = edges.length + 1;

        tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            tree.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        subtreeSizes = new int[n];

        goodNodes = 0;

        dfs(0, -1);

        return goodNodes;
    }

    private static int dfs(int node, int parent) {

        subtreeSizes[node] = -1;

        Map<Integer, Integer> subtreeSizeCount = new HashMap<>();

        for (Integer neighbor : tree.get(node)) {

            if (neighbor == parent) continue;

            int size = dfs(neighbor, node);
            subtreeSizes[node] += size;
            subtreeSizeCount.put(size, subtreeSizeCount.getOrDefault(size, 0) + 1);
        }

        if (subtreeSizeCount.size() <= 1) {
            goodNodes++;
        }

        return subtreeSizes[node];
    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}};

        System.out.println(countGoodNodes(edges));
    }
}
