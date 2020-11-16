public class Student {
    private int code;
    private int areaCode;

    public Student(int code, int areaCode){
        this.code = code;
        this.areaCode = areaCode;
    }

    @Override
    public String toString(){
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
}
