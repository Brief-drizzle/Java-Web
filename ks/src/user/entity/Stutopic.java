package user.entity;

import java.util.Date;

public class Stutopic {
	/** StuTopicID */
	private String stutopicId;
	/** 学号 */
	private String studentId;
	/** 主题ID */
	private String topicId;
	/** 选题时间 */
	private Date selectTime;
	/** 是否已经上传论文（0表示未上传，1表示已上传） */
	private String flag;

	public void setStutopicId(String stutopicId) {
		this.stutopicId = stutopicId;
	}
	
	public String getStutopicId() {
		return this.stutopicId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	
	public String getTopicId() {
		return this.topicId;
	}
	
	public void setSelectTime(Date selectTime) {
		this.selectTime = selectTime;
	}
	
	public Date getSelectTime() {
		return this.selectTime;
	}
	
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public String getFlag() {
		return this.flag;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Stutopic that = (Stutopic) o;
        return stutopicId.equals(that.stutopicId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(stutopicId);
    }
    
    @Override
    public String toString() {
        return "Stutopic{" +
				"stutopicId=" + stutopicId +
						",studentId='" + studentId + "'" + 
						",topicId='" + topicId + "'" + 
						",selectTime='" + selectTime + "'" + 
						",flag='" + flag + "'" + 
		                '}';
    }
	
}