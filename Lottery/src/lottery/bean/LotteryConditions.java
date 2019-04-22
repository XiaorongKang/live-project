package lottery.bean;

import java.util.Date;
/**
 * 抽奖条件对象
 * @author LITM
 *
 */
public class LotteryConditions {
	private int conditionId;
	private String activityName;
	private String keyword;
	private String copyWriting;
	private String fileName;
	private Date startTime;
	private Date endTime;
	private Date showTime;
	private int filter;
	
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getShowTime() {
		return showTime;
	}
	public void setShowTime(Date showTime) {
		this.showTime = showTime;
	}
	public int getFilter() {
		return filter;
	}
	public void setFilter(int filter) {
		this.filter = filter;
	}
}
