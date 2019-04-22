package lottery.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lottery.bean.Condition;
import lottery.util.DatabaseUtil;

public class ConditionDAO {
	
    /**
     * @param 
     * @return Condition
     * @author mingjun
     * @date 2019/4/21 14:31
     * @description 获取抽奖条件
     */
	public Condition getAll() {
		Condition condition = new Condition();
        try (Connection c = DatabaseUtil.getInstance(); Statement s = c.createStatement()) {
            String sql = "select * from condition";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                String conditionId = rs.getString("conditionId");
                condition.setConditionId(Integer.parseInt(conditionId));
                
                String activityName = rs.getString("activityName");
                condition.setActivityName(activityName);
                
                String keyword = rs.getString("keyword");
                condition.setKeyword(keyword);
                
                String copyWriting = rs.getString("copyWriting");
                condition.setCopyWriting(copyWriting);
                
                String fileName = rs.getString("fileName");
                condition.setFileName(fileName);
                
                String startTime = rs.getString("startTime");
                condition.setStartTime(startTime);
                
                String endTime = rs.getString("endTime");
                condition.setEndTime(endTime);
                
                String showTime = rs.getString("showTime");
                condition.setShowTime(showTime);
                
                String filter = rs.getString("filter");
                condition.setFilter(Integer.parseInt(filter));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }

}
