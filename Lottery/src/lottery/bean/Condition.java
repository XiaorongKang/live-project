package lottery.bean;

/**
 * 
 * @author MingJun
 * @date 2019/4/22 12:23
 * 抽奖条件
 */
public class Condition {
	int conditionId;
	String activityName;
	String keyword;
	String copyWriting;
	String fileName;
	String startTime;
	String endTime;
	String showTime;
	int filter;
	
	public int getConditionId() {
		return conditionId;
	}
	public void setConditionId(int conditionId) {
		this.conditionId = conditionId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCopyWriting() {
		return copyWriting;
	}
	public void setCopyWriting(String copyWriting) {
		this.copyWriting = copyWriting;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public int getFilter() {
		return filter;
	}
	public void setFilter(int filter) {
		this.filter = filter;
	}

	
}
