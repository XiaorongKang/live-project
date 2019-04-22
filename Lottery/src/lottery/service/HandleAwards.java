package lottery.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.*;

import lottery.bean.AwardsForm;
/**
 * 处理json数据生成奖项列表并返回
 * @author LITM
 *
 */
public class HandleAwards {
	public static List<AwardsForm> handleJson(HttpServletRequest request) throws UnsupportedEncodingException, IOException {
		
		String strAwards = null;
		if(!request.getParameter("Awards").equals(null)) {strAwards = request.getParameter("Awards");}
		else {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
			StringBuilder sb = new StringBuilder();
			try {
				while ((strAwards = br.readLine()) != null) {
					sb.append(strAwards);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//将json字符串转换为json对象数组
		List<AwardsForm> awardsForms= JSON.parseArray(strAwards,AwardsForm.class);
		//设置每个奖项的id
		int id = 1;
		for(AwardsForm awardsForm : awardsForms) {
			awardsForm.setId(id);
			id++;
		}
		return awardsForms;
	}
}
