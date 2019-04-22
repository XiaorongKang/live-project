package lottery.dao;

import lottery.bean.AwardsForm;
import lottery.util.DatabaseUtil;

import java.sql.*;
import java.util.List;

public class StoreAwardsForm {
	public static void storeAwardsForm(List<AwardsForm> awardsForms) throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		
		String sql ="insert into prize(prizeId,prizeName,prizeDesc,number)"
				+ "values(?,?,?,?)";
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 for(AwardsForm awardsForm : awardsForms) {
			 preparedStatement.setInt(1, awardsForm.getId());
			 preparedStatement.setString(2, awardsForm.getPrizeName());
			 preparedStatement.setString(3, awardsForm.getPrizeDesc());
			 preparedStatement.setInt(4, awardsForm.getNumber());
			 preparedStatement.execute();
		 }
		 preparedStatement.close();
		 connection.close();
	}
}
