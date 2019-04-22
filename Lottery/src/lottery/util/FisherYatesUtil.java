package lottery.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import lottery.bean.AwardRecord;
import lottery.bean.Condition;
import lottery.bean.Prize;
import lottery.bean.User;
import lottery.dao.ConditionDAO;
import lottery.dao.PrizeDAO;

public class FisherYatesUtil {
	static Condition condition = new Condition();
	static ArrayList<Prize> prizes = new ArrayList<Prize>();
	static ArrayList<User> users = new ArrayList<User>();
	static ArrayList<AwardRecord> awardRecords = new ArrayList<AwardRecord>();
	static HashMap<String, Integer> awardUsers = new HashMap<String, Integer>();
	static int weight = 2;
	public void initalData() {
		//从数据库获取抽奖条件
		ConditionDAO conditionDAO = new ConditionDAO();
		condition = conditionDAO.getAll();
		//从数据库获取奖项
		PrizeDAO prizeDAO = new PrizeDAO();
		prizes = prizeDAO.getAll();
		//从数据库获取符合抽奖条件的用户
		//...
	}
	/**
	 * @param 
	 * @return ArrayList<AwardRecord>
	 * @author mingjun
	 * @date 2019/4/22 16:07
	 * @description 幸运抽奖-使用费雪耶兹置乱算法
	 */
	public ArrayList<AwardRecord>  Luckdraw(){
		ArrayList<AwardRecord> awardRecords = new ArrayList<AwardRecord>();
		ArrayList<User> activeUsers = new ArrayList<User>();
		ArrayList<User> normalUsers = new ArrayList<User>();
		//分类用户
		for(int i = 0; i < users.size(); ++i) {
			User user = users.get(i);
			int[] input = {user.getActiveDay(),user.getContinuousActiveDay(),user.getActiveRecord()};
			if(PerceptionUtil.comPerc(input) == 1) {
				activeUsers.add(user);
			}else {
				normalUsers.add(user);
			}
		}
		
		//初始化待乱序数组
		int count = 0;
		String[] arr = new String[activeUsers.size()*weight+normalUsers.size()];
		for(int j = 0; j < activeUsers.size(); ++j) {
			for(int k = 0; k < weight; ++k ) {
				arr[count++] = activeUsers.get(j).getUserId();
			}	
		}
		for(int j = 0; j < normalUsers.size(); ++j) {
			arr[count++] = activeUsers.get(j).getUserId();
		}
		
		//费雪耶兹置乱算法
		for (int i = arr.length - 1; i > 0; i--) {
			//随机数生成器，范围[0, i]
			int rand = (new Random()).nextInt(i+1);
			System.out.print(" " + rand);
			String temp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = temp;
		}
		
		//取topk为获奖者
		int countAward = 0;
		for(int i = 0; i < prizes.size(); ++i) {
			for(int j = 0; j < prizes.get(i).getNumber(); ++j) {
				if(awardUsers.get(arr[countAward]) == null) {
					AwardRecord awardRecord = new AwardRecord();
					awardRecord.setPrizeId(prizes.get(i).getPrizeId());
					awardRecord.setPrizeName(prizes.get(i).getPrizeName());
					awardRecord.setPrizeDesc(prizes.get(i).getPrizeDesc());
					awardRecord.setUserId(arr[countAward]);
					awardRecords.add(awardRecord);
					awardUsers.put(arr[countAward], 1);
				}	
			}
		}
		return awardRecords;
	}
}
