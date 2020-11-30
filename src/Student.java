import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Student {
    private int code;
    private int areaCode;

    public Student(int code, int areaCode) {
        this.code = code;
        this.areaCode = areaCode;
    }

    @Override
    public String toString() {
        return "Student " + this.code + " - Area: " + this.areaCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public static List<StudentEdge> relation(List<SearchArea> searchAreaList, List<Student> studentList) {
        Student[] studentsArray = new Student[0];
        studentsArray = studentList.toArray(studentsArray);
        List<StudentEdge> edgeList = new ArrayList<StudentEdge>();

        for (int i = 0; i < studentsArray.length; i++) {
            Student student1 = studentsArray[i];

            for (int j = i + 1; j < studentsArray.length; j++) {
                Student student2 = studentsArray[j];

                int relationWeigth = -1;

                for (SearchArea sra : searchAreaList) {
                    if (sra.getCode() == student1.getAreaCode()) {
                        Map<Integer, Integer> aux = sra.getDissimilarity();
                        relationWeigth = aux.get(student2.getAreaCode());
                        break;
                    }
                }
                edgeList.add(new StudentEdge(student1, student2, relationWeigth));
            }
        }

        return edgeList;
    }
}
