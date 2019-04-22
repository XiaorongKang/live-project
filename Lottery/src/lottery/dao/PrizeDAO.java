package lottery.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import lottery.bean.Condition;
import lottery.bean.Prize;
import lottery.util.DatabaseUtil;

public class PrizeDAO {
	
	/**
     * @param 
     * @return ArrayList<Prize>
     * @author mingjun
     * @date 2019/4/21 15:39
     * @description 获取奖项数据
     */
	public ArrayList<Prize> getAll() {
		ArrayList<Prize> prizes = new ArrayList<Prize>();
        try (Connection c = DatabaseUtil.getInstance(); Statement s = c.createStatement()) {
            String sql = "select * from prize";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
            	Prize prize = new Prize();
                String prizeId = rs.getString("prizeId");
                prize.setPrizeId(Integer.parseInt(prizeId));
                
                String prizeName = rs.getString("prizeName");
                prize.setPrizeName(prizeName);
                
                String prizeDesc = rs.getString("prizeDesc");
                prize.setPrizeDesc(prizeDesc);
                
                String number = rs.getString("number");
                prize.setNumber(Integer.parseInt(number));
                
                prizes.add(prize);

            }
         }catch (Exception e) {
	
         }
		return prizes;
		
	}

}
