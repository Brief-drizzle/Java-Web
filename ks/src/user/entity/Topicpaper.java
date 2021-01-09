package user.entity;


public class Topicpaper {
	/** TopicPaperID */
	private String topicpaperId;
	/** StuTopicID */
	private String stutopicId;
	/** 论文ID */
	private String paperId;
	/** 相关程度(0-1 之 间的数值 ) */
	private Float relevancy;

	public void setTopicpaperId(String topicpaperId) {
		this.topicpaperId = topicpaperId;
	}
	
	public String getTopicpaperId() {
		return this.topicpaperId;
	}
	
	public void setStutopicId(String stutopicId) {
		this.stutopicId = stutopicId;
	}
	
	public String getStutopicId() {
		return this.stutopicId;
	}
	
	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}
	
	public String getPaperId() {
		return this.paperId;
	}
	
	public void setRelevancy(Float relevancy) {
		this.relevancy = relevancy;
	}
	
	public Float getRelevancy() {
		return this.relevancy;
	}
	

	@Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) {return false;}
        Topicpaper that = (Topicpaper) o;
        return topicpaperId.equals(that.topicpaperId);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(topicpaperId);
    }
    
    @Override
    public String toString() {
        return "Topicpaper{" +
				"topicpaperId=" + topicpaperId +
						",stutopicId='" + stutopicId + "'" + 
						",paperId='" + paperId + "'" + 
						",relevancy='" + relevancy + "'" + 
		                '}';
    }
	
}