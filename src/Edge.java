class Edge implements Comparable<Edge> {
    private int src;
    private int dest;
    private int weight;

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    public Edge() {
    }

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }

    @Override
    public String toString() {
        return "\n" + (src + 1) + " -- "
                + (dest + 1)
                + " == " + weight;
    }
}