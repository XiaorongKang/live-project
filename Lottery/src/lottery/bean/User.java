package lottery.bean;

public class User {
	private int id;
	private String userId;
	private String userName;
	private int userType;
	private boolean isUseKeyword;
	private boolean isInTime;
	private int activeDay;
	private int continuousActiveDay;
	private int activeRecord;
	private boolean isPrize;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public boolean isUseKeyword() {
		return isUseKeyword;
	}
	public void setUseKeyword(boolean isUseKeyword) {
		this.isUseKeyword = isUseKeyword;
	}
	public boolean isInTime() {
		return isInTime;
	}
	public void setInTime(boolean isInTime) {
		this.isInTime = isInTime;
	}
	public int getActiveDay() {
		return activeDay;
	}
	public void setActiveDay(int activeDay) {
		this.activeDay = activeDay;
	}
	public int getContinuousActiveDay() {
		return continuousActiveDay;
	}
	public void setContinuousActiveDay(int continuousActiveDay) {
		this.continuousActiveDay = continuousActiveDay;
	}
	public int getActiveRecord() {
		return activeRecord;
	}
	public void setActiveRecord(int activeRecord) {
		this.activeRecord = activeRecord;
	}
	public boolean isPrize() {
		return isPrize;
	}
	public void setPrize(boolean isPrize) {
		this.isPrize = isPrize;
	}
	
	
}
