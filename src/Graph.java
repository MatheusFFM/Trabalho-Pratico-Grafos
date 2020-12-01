import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Graph {
    int V;
    int E;
    List<Edge> edge;
    Edge[] mst;

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new ArrayList<>();
        for (int i = 0; i < e; ++i)
            edge.add(new Edge());
    }

    Graph(int v, int e, List<Edge> mapedEdges) {
        V = v;
        E = e;
        edge = mapedEdges;
    }

    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank
                < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    Edge[] KruskalMST() {
        Edge[] result = new Edge[V - 1];

        int e = 0;

        int i;
        for (i = 0; i < result.length; ++i)
            result[i] = new Edge();

        Collections.sort(edge);

        Subset[] subsets = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while (e < V - 1) {
            Edge next_edge = edge.get(i++);

            int x = find(subsets, next_edge.getSrc());
            int y = find(subsets, next_edge.getDest());

            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
        }
        this.mst = result;
        return result;
    }

    public List<List<Integer>> getGroups(int k) {
        Arrays.sort(mst, Collections.reverseOrder());

        Edge[] save = new Edge[k - 1];

        for (int i = 0; i < k - 1; i++) {
            save[i] = mst[i];
        }

        Edge[] newArray = Arrays.copyOfRange(mst, k - 1, mst.length);


        List<List<Integer>> list = new ArrayList<>();

        if (k == 1) {
            list.add(this.getVertexConnect(newArray, mst[0].getSrc()));
            return list;
        }

        for (int i = 0; i < save.length; i++) {
            int code1 = save[i].getSrc();
            int code2 = save[i].getDest();

            boolean found1 = false;
            boolean found2 = false;

            for (List<Integer> group : list) {
                if (!found1)
                    found1 = group.contains(code1);
                if (!found2)
                    found2 = group.contains(code2);
            }

            if (!found1) {
                List<Integer> group1 = this.getVertexConnect(newArray, code1);
                list.add(group1);
            }
            if (!found2) {
                List<Integer> group2 = this.getVertexConnect(newArray, code2);
                list.add(group2);
            }
        }

        return list;
    }

    private List<Integer> getVertexConnect(Edge[] newArray, int code1) {
        List<Edge> clone = new ArrayList<>(Arrays.asList(newArray));
        List<Integer> list = new ArrayList<>();
        list.add(code1);

        for (int j = 0; j < list.size(); j++) {
            code1 = list.get(j);
            List<Edge> src = new ArrayList<>();
            List<Edge> dest = new ArrayList<>();
            for (int i = 0; i < clone.size(); i++) {
                Edge actualEdge = clone.get(i);
                boolean isSrc = code1 == actualEdge.getSrc();
                boolean isDest = code1 == actualEdge.getDest();
                if (isSrc || isDest) {
                    if (isSrc) {
                        src.add(actualEdge);
                        int aux = actualEdge.getDest();
                        list.add(aux);
                    } else {
                        dest.add(actualEdge);
                        int aux = actualEdge.getSrc();
                        list.add(aux);
                    }
                    clone.remove(actualEdge);
                    i = -1;
                }
            }
            clone.removeAll(src);
            clone.removeAll(dest);
        }


        return list;
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<Edge> getEdge() {
        return edge;
    }

    public void setEdge(List<Edge> edge) {
        this.edge = edge;
    }

    public Edge[] getMst() {
        return mst;
    }
}