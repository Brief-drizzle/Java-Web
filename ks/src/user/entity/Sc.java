package user.entity;


public class Sc {
	/** SCID */
	private String scId;
	/** 课程ID */
	private String courseId;
	/** 学号 */
	private String studentId;
	/** 成绩 */
	private Integer score;

	public void setScId(String scId) {
		this.scId = scId;
	}
	
	public String getScId() {
		return this.scId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	public Integer getScore() {
		return this.score;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Sc that = (Sc) o;
        return scId.equals(that.scId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(scId);
    }
    
    @Override
    public String toString() {
        return "Sc{" +
				"scId=" + scId +
						",courseId='" + courseId + "'" + 
						",studentId='" + studentId + "'" + 
						",score='" + score + "'" + 
		                '}';
    }
	
}