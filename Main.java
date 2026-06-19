import java.util.*;

class DijkstraExpressway {

    static class Pair implements Comparable<Pair> {
        String node;
        int cost;

        Pair(String node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(Pair other) {
            return this.cost - other.cost;
        }
    }

    public static void dijkstra(Map<String, List<Pair>> graph, String source, String destination) {

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String node : graph.keySet()) {
            dist.put(node, Integer.MAX_VALUE);
        }

        dist.put(source, 0);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            String u = current.node;
            int currentCost = current.cost;

            for (Pair neighbor : graph.get(u)) {
                String v = neighbor.node;
                int weight = neighbor.cost;

                if (currentCost + weight < dist.get(v)) {
                    dist.put(v, currentCost + weight);
                    parent.put(v, u);
                    pq.add(new Pair(v, dist.get(v)));
                }
            }
        }

        List<String> path = new ArrayList<>();
        String node = destination;

        while (node != null) {
            path.add(node);
            node = parent.get(node);
        }

        Collections.reverse(path);

        System.out.println("Shortest Path: " + String.join(" -> ", path));
        System.out.println("Minimum Toll Cost: ₹" + dist.get(destination));
    }

    public static void main(String[] args) {

        Map<String, List<Pair>> graph = new HashMap<>();

        graph.put("KIR", Arrays.asList(
                new Pair("URS", 12),
                new Pair("KHA", 15)
        ));

        graph.put("URS", Arrays.asList(
                new Pair("TLG", 18)
        ));

        graph.put("KHA", Arrays.asList(
                new Pair("KRD", 14)
        ));

        graph.put("TLG", Arrays.asList(
                new Pair("DEH", 8)
        ));

        graph.put("KRD", Arrays.asList(
                new Pair("DEH", 20)
        ));

        graph.put("DEH", Arrays.asList(
                new Pair("PUN", 10)
        ));

        graph.put("PUN", new ArrayList<>());

        dijkstra(graph, "KIR", "PUN");
    }
}