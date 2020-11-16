public class Student {
    private int code;
    private int areaCode;

    Student(int code, int areaCode){
        this.code = code;
        this.areaCode = areaCode;
    }

    @Override
    public String toString(){
        return "Student " + this.code + " - Area: " + this.areaCode;
    }
}
