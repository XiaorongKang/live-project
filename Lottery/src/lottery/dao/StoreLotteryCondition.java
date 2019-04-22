package lottery.dao;

import java.sql.*;


import lottery.bean.LotteryConditions;
import lottery.util.DatabaseUtil;

public class StoreLotteryCondition {
	public static void storeLotteryCondition(LotteryConditions lotteryConditions) throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		String sql = "insert into condition(conditionId,activityName,keyword,copyWriting,fileName,startTime,endTime,showTime,filter)"
				+ "values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, lotteryConditions.getConditionId());
		preparedStatement.setString(2,lotteryConditions.getActivityName());
		preparedStatement.setString(3, lotteryConditions.getKeyword());
		preparedStatement.setString(4, lotteryConditions.getCopyWriting());
		preparedStatement.setString(5, lotteryConditions.getFileName());
		preparedStatement.setDate(6, (java.sql.Date)lotteryConditions.getStartTime());
		preparedStatement.setDate(7, (java.sql.Date)lotteryConditions.getEndTime());
		preparedStatement.setDate(8, (java.sql.Date)lotteryConditions.getShowTime());
		preparedStatement.setInt(9, lotteryConditions.getFilter());
		preparedStatement.close();
		connection.close();
	}
}
