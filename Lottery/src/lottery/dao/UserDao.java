package lottery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lottery.pojo.User;
import lottery.util.DatabaseUtil;

import static lottery.util.DatabaseUtil.getInstance;


public class UserDao {
	
	
	//抽奖时间段：SELECT	* FROM lottery.chat_record where userId=10000 and time >= '2022-10-25 00:00:00.0' AND time <= '2022-12-25 12:00:00.0'^^
	//用户类型：SELECT	* FROM lottery.chat_record where userName like '%教师%'^^
	//有效发言条数：SELECT	count(*) FROM lottery.chat_record where numberOfCharacters!=0 and userId=83604395^^
	//有效发言天数:SELECT	date_format(time,'%Y%m%d') FROM lottery.chat_record where numberOfCharacters!=0 and userId=83604395 group by date_format(time,'%Y%m%d') order by date_format(time,'%Y%m%d')^^ 
	public static void storeUser(User user) {
		try {
			String sql = "insert into user(userId,userName,userType,isUseKeyword,isInTime,activeDay,continuousActiveDay,activeRecord,isPrize) " +
					"					values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = getInstance().prepareStatement(sql);
			preparedStatement.setString(1,user.getUserId());
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setInt(3, user.getUserType());
			preparedStatement.setBoolean(4, user.getIsUseKeyword());
			preparedStatement.setBoolean(5,user.getIsInTime());
			preparedStatement.setInt(6,user.getActiveDay());
			preparedStatement.setInt(7,1);
			preparedStatement.setInt(8,user.getActiveRecord());
			preparedStatement.setBoolean(9,user.getIsPrize());
			preparedStatement.execute();
			preparedStatement.close();
		} catch (SQLException e) {
//			e.printStackTrace();
			System.out.println("Incorrect string value: '\\xF0\\x9F\\x92\\xA9' for column 'userName' at row 1.");
		}
	}
	public  void setUser() {

		try {
			clearTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		User user=null;
		Connection c = null; 
		Statement s = null;
        ResultSet rs = null;
        
	    Statement sInfo = null;
		ResultSet rsInfo = null;
		
		Statement sTextCount = null;
		ResultSet rsTextCount = null;
		
		Statement sUserType = null;
		ResultSet rsUserType = null;
		
		Statement sIntime = null;
		ResultSet rsIntime = null;
		
		Statement sActiveDay = null;
		ResultSet rsActiveDay = null;

		Statement sGetInTime = null;
		ResultSet rsGetInTime = null;

		
		try {
			c= DatabaseUtil.getConnection();
			String sql = "select userId from chat_record group by userId";
			s=c.createStatement();
			rs=s.executeQuery(sql);
			sInfo = c.createStatement();
			sTextCount = c.createStatement();
			sUserType = c.createStatement();
			sIntime = c.createStatement();
			sActiveDay = c.createStatement();
			sGetInTime =c.createStatement();
			
			while(rs.next()) {
				user=new User();
				user.setIsPrize(false);
				String userId="'"+rs.getString(1)+"'";
				String teacher= "'%教师%'";
				String teachAssistant="'%助教%'";
				String system="'系统消息'";
				String startTime=null;
				String endTime=null;
				int ActiveDay=0;
				
				String sqlInfo = "select * from chat_record where userId="+userId;
				String sqlTextCount = "SELECT count(*) FROM lottery.chat_record where numberOfCharacters!=0 and userId="+userId;
				String sqlUserType = "SELECT * FROM lottery.chat_record where userId ="+userId+" and userName like " ;
				String sqlIntime = "SELECT	* FROM lottery.chat_record where userId=10000 and time >= "+startTime+" AND time <= "+endTime;
				String sqlActiveDay ="SELECT date_format(`time`,'%Y%m%d') FROM lottery.chat_record where numberOfCharacters!=0 and userId="+userId+"group by date_format(`time`,'%Y%m%d') order by date_format(time,'%Y%m%d')";
				String sqlGetTime="select startTime,endTime from lottery.condition";
				
				rsTextCount = sTextCount.executeQuery(sqlTextCount);

				rsGetInTime = sGetInTime.executeQuery(sqlGetTime);
				while(rsGetInTime.next()){
					startTime=rsGetInTime.getString("startTime");
					endTime=rsGetInTime.getString("endTime");
				}
				
				user.setUserId(userId);//用户qq

				user.setUserType(0);
				rsUserType = sUserType.executeQuery(sqlUserType+teacher);
				if(rsUserType.next()) {
					user.setUserType(2);//老师
				}
				rsUserType = sUserType.executeQuery(sqlUserType+teachAssistant);
 				if(rsUserType.next()) {
					user.setUserType(1);//助教
				}
				rsUserType = sUserType.executeQuery(sqlUserType+system);
				if(rsUserType.next()) {
					user.setUserType(3);//助教
				}
				
				rsIntime = sIntime.executeQuery(sqlIntime);
				if(rsIntime.next()) {
					user.setIsInTime(true);//是否在抽奖时间段
				}
				
				rsActiveDay = sActiveDay.executeQuery(sqlActiveDay);
				while(rsActiveDay.next()) {
					ActiveDay++;
				}
				user.setActiveDay(ActiveDay);//有效活跃天数
				
				rsInfo = sInfo.executeQuery(sqlInfo);
				while(rsTextCount.next()) {
					user.setActiveRecord(rsTextCount.getInt(1));//用户有效发言条数
				}
				while(rsInfo.next()) {
					user.setUserName(rsInfo.getString(3));//用户名
					if(rsInfo.getBoolean(5)) {
						user.setIsUseKeyword(true);//用户是否使用关键词
					}
			        
				}
				this.storeUser(user);
			}
			DatabaseUtil.close(rsInfo,sInfo,null);
			DatabaseUtil.close(rsTextCount,sTextCount,null);
			DatabaseUtil.close(rsUserType,sUserType,null);
			DatabaseUtil.close(rsIntime,sIntime,null);
			DatabaseUtil.close(rsActiveDay,sActiveDay,null);
			DatabaseUtil.close(rs,s,null);
			DatabaseUtil.close(rsGetInTime,sGetInTime,null);
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void clearTable() throws SQLException {

		String sql = "DELETE FROM `user` WHERE userId > ''; ";
		PreparedStatement preparedStatement = getInstance().prepareStatement(sql);
		preparedStatement.execute();
		preparedStatement.close();
	}
}
