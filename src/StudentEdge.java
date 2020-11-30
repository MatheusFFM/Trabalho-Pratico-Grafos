public class StudentEdge implements Comparable<StudentEdge> {
    private static int count = 0;
    private final Student student1;    //an edge has 2 vertices & a weight
    private final Student student2;
    private final int weight;
    private final int id;

    public StudentEdge(Student student1, Student student2, int weight) {
        this.id = count++;
        this.student1 = student1;
        this.student2 = student2;
        this.weight = weight;
    }

    public Student getStudent1() {
        return student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(StudentEdge otherEdge) {                //Compare based on edge weight (for sorting)
        return this.getWeight() - otherEdge.getWeight();
    }

    @Override
    public String toString() {
        return "\n" + id + " - Edge (" + getStudent1() + ", " + getStudent2() + ") weight=" + getWeight();
    }
}
