import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentFileReader {
    private String fileName;

    StudentFileReader(String fileName){
        this.fileName = fileName;
    }

    public List<Student> returnAllContent() throws IOException {
        File file = new File(fileName);
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<Student> studentsList = new ArrayList<Student>();
        String aux;

        while ((aux = br.readLine()) != null){
            String[] lineStudent = aux.split(" ");
            int code = Integer.parseInt(lineStudent[0]);
            int area = Integer.parseInt(lineStudent[1]);
            studentsList.add(new Student(code, area));
        }

        return studentsList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
