import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    int[] parent;

    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path Compression
        return parent[x];
    }

    boolean union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry)
            return false;

        parent[rx] = ry;
        return true;
    }
}

public class BangaloreMetroKruskal {

    public static void main(String[] args) {

        String[] station = {
            "M", "K", "W", "S", "E", "Y", "H"
        };

        List<Edge> edges = new ArrayList<>();

        // Candidate edges from diagram
        edges.add(new Edge(0, 1, 8));   // M-K
        edges.add(new Edge(0, 2, 12));  // M-W
        edges.add(new Edge(0, 3, 10));  // M-S
        edges.add(new Edge(0, 4, 7));   // M-E
        edges.add(new Edge(0, 5, 9));   // M-Y
        edges.add(new Edge(0, 6, 11));  // M-H

        edges.add(new Edge(1, 2, 5));   // K-W
        edges.add(new Edge(1, 3, 6));   // K-S
        edges.add(new Edge(2, 4, 4));   // W-E
        edges.add(new Edge(3, 5, 8));   // S-Y
        edges.add(new Edge(4, 6, 9));   // E-H
        edges.add(new Edge(5, 6, 14));  // Y-H

        Collections.sort(edges);

        UnionFind uf = new UnionFind(7);

        int totalCost = 0;

        System.out.println("MST Edges:");

        for (Edge e : edges) {

            if (uf.union(e.src, e.dest)) {

                System.out.println(
                        station[e.src] + " - " +
                        station[e.dest] +
                        " : ₹" + e.weight + " crore");

                totalCost += e.weight;
            }
        }

        System.out.println("\nTotal MST Cost = ₹" +
                totalCost + " crore");
    }
}