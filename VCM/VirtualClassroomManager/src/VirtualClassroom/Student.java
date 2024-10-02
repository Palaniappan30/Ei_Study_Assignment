package VirtualClassroom;

public class Student {
    private String studentId;
    private String className;

    public Student(String studentId, String className) {
        this.studentId = studentId;
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }
}
