package user.entity;

public class classes {
    /**
     * �γ�ID
     */
    private String courseId;
    /**
     * �γ���
     */
    private String courseName;
    /**
     * ����ѧ��
     */
    private String term;
    /**
     * ��ʱ��
     */
    private Integer courseHour;
    /**
     * ����
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