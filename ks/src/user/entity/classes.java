package user.entity;

public class classes {
    /**
     * 课程ID
     */
    private String courseId;
    /**
     * 课程名
     */
    private String courseName;
    /**
     * 开设学期
     */
    private String term;
    /**
     * 课时数
     */
    private Integer courseHour;
    /**
     * 姓名
     */
    private String name;

    public classes() {

    }

    @Override
    public String toString() {
        return "classes{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", term='" + term + '\'' +
                ", courseHour=" + courseHour +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(Integer courseHour) {
        this.courseHour = courseHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}