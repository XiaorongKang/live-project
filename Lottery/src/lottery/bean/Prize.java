package lottery.bean;
/**
 * 
 * @author MingJun
 * @date 2019/4/22 12:23
 * 奖项
 */
public class Prize {
	int prizeId;
	String prizeName;
	String prizeDesc;
	//奖项人数
	int number;
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
