package user.entity;


public class Course {
	/** 课程ID */
	private String courseId;
	/** 课程名 */
	private String courseName;
	/** 开设学期 */
	private String term;
	/** 课时数 */
	private Integer courseHour;

    public Course(String courseId, String courseName, String term, Integer courseHour) {
    }

    public Course() {

    }

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public String getTerm() {
		return this.term;
	}
	
	public void setCourseHour(Integer courseHour) {
		this.courseHour = courseHour;
	}
	
	public Integer getCourseHour() {
		return this.courseHour;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Course that = (Course) o;
        return courseId.equals(that.courseId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(courseId);
    }
    
    @Override
    public String toString() {
        return "Course{" +
				"courseId=" + courseId +
						",courseName='" + courseName + "'" + 
						",term='" + term + "'" + 
						",courseHour='" + courseHour + "'" + 
		                '}';
    }
	
}