public class StudentEdge implements Comparable<StudentEdge> {
    private final Student student1;    //an edge has 2 vertices & a weight
    private final Student student2;
    private final int weight;

    public StudentEdge(Student student1, Student student2, int weight) {
        this.student1 = student1;
        this.student2 = student2;
        this.weight = weight;
    }
    public StudentEdge() {
        this.student1 = null;
        this.student2 = null;
        this.weight = 0;
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
        return "\nEdge (" + getStudent1() + ", " + getStudent2() + ") weight=" + getWeight();
    }
}
