package lottery.bean;
/**
 * 
 * @author MingJun
 * @date 2019/4/22 12:23
 * 中奖记录
 */
public class AwardRecord {
	private int awardRecordId;
	private String userId;
	private String userName;
	private int prizeId;
	private String prizeName;
	private String prizeDesc;
	public int getAwardRecordId() {
		return awardRecordId;
	}
	public void setAwardRecordId(int awardRecordId) {
		this.awardRecordId = awardRecordId;
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
	public int getPrizeId() {
		return prizeId;
	}
	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}
	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public String getPrizeDesc() {
		return prizeDesc;
	}
	public void setPrizeDesc(String prizeDesc) {
		this.prizeDesc = prizeDesc;
	}
	
	
}
