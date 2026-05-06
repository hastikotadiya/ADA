import java.util.*;
class Edge {
    int u, v, w;
}
public class pr8{
    static int find(int parent[], int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }
    static void union(int parent[], int x, int y) {
        parent[y] = x;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        Edge edges[] = new Edge[E];
        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].u = sc.nextInt();
            edges[i].v = sc.nextInt();
            edges[i].w = sc.nextInt();
        }
        long start = System.nanoTime();
        for (int i = 0; i < E - 1; i++) {
            for (int j = i + 1; j < E; j++) {
                if (edges[i].w > edges[j].w) {
                    Edge temp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = temp;
                }
            }
        }
        int parent[] = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        int count = 0;
        int total = 0;

        System.out.println("Edges in MST:");

        for (int i = 0; i < E && count < V - 1; i++) {
            int u = edges[i].u;
            int v = edges[i].v;

            int setU = find(parent, u);
            int setV = find(parent, v);

            if (setU != setV) {
                System.out.println(u + " - " + v + " -> " + edges[i].w);
                total += edges[i].w;
                union(parent, setU, setV);
                count++;
            }
        }

        long end = System.nanoTime();

        System.out.println("Total cost = " + total);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }
}
