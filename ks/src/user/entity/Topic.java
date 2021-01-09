package user.entity;

import java.util.Date;

public class Topic {
	/** 主题ID */
	private String topicId;
	/** 课程ID */
	private String courseId;
	/** 出题教师 ID */
	private String teacherId;
	/** 主题名 */
	private String topic;
	/** 关键词 */
	private String keyword;
	/** 创建时间 */
	private Date creationTime;
	/** 已选学生人数（每个主题最多被 5 名学生所选） */
	private Integer studentNum;

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	
	public String getTopicId() {
		return this.topicId;
	}
	
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	public String getTeacherId() {
		return this.teacherId;
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getTopic() {
		return this.topic;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
	
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	
	public Date getCreationTime() {
		return this.creationTime;
	}
	
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	
	public Integer getStudentNum() {
		return this.studentNum;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Topic that = (Topic) o;
        return topicId.equals(that.topicId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(topicId);
    }
    
    @Override
    public String toString() {
        return "Topic{" +
				"topicId=" + topicId +
						",courseId='" + courseId + "'" + 
						",teacherId='" + teacherId + "'" + 
						",topic='" + topic + "'" + 
						",keyword='" + keyword + "'" + 
						",creationTime='" + creationTime + "'" + 
						",studentNum='" + studentNum + "'" + 
		                '}';
    }
	
}