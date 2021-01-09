package user.entity;

import org.apache.poi.ss.usermodel.Cell;

import java.util.Date;

public class Paper {
	/** 论文ID */
	private String paperId;
	/** 论文题目 */
	private String title;
	/** 作者 */
	private String author;
	/** 出处 */
	private String source;
	/** 关键词 */
	private String keyword;
	/** 摘要 */
	private String abstracts;
	/** 文件物理位置 */
	private String docLocation;
	/** 学号 */
	private String studentId;
	/** 上传时间 */
	private Date uploadingTime;

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	public String getPaperId() {
		return this.paperId;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return this.keyword;
	}
	
	public void setAbstract(String abstracts) {
		this.abstracts = abstracts;
	}
	
	public String getAbstract() {
		return this.abstracts;
	}
	
	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}
	
	public String getDocLocation() {
		return this.docLocation;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setUploadingTime(Date uploadingTime) {
		this.uploadingTime = uploadingTime;
	}
	
	public Date getUploadingTime() {
		return this.uploadingTime;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Paper that = (Paper) o;
        return paperId.equals(that.paperId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(paperId);
    }
    
    @Override
    public String toString() {
        return "Paper{" +
				"paperId=" + paperId +
						",title='" + title + "'" + 
						",author='" + author + "'" + 
						",source='" + source + "'" + 
						",keyword='" + keyword + "'" + 
						",abstract='" + abstracts + "'" +
						",docLocation='" + docLocation + "'" + 
						",studentId='" + studentId + "'" + 
						",uploadingTime='" + uploadingTime + "'" + 
		                '}';
    }
	
}