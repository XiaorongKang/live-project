package lottery.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;

import lottery.bean.LotteryConditions;

public class HandleConditions {
	/**
	 * 生成抽奖条件对象
	 * @param request
	 * @return 
	 * @throws ParseException 
	 */
	public static LotteryConditions handleConditions(HttpServletRequest request) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		LotteryConditions lotteryContitions = new LotteryConditions();
		lotteryContitions.setActivityName(request.getParameter("activityName"));
		lotteryContitions.setCopyWriting(request.getParameter("copyWriting"));
		lotteryContitions.setFileName(request.getParameter("fileName"));
		lotteryContitions.setKeyword(request.getParameter("keyword"));
		lotteryContitions.setStartTime(sdf.parse(request.getParameter("startTime")));
		lotteryContitions.setEndTime(sdf.parse(request.getParameter("endTime")));
		lotteryContitions.setShowTime(sdf.parse(request.getParameter("showTime")));
		lotteryContitions.setFilter(Integer.parseInt(request.getParameter("filter")));
		//设置抽奖条件id
		int id =1;
		lotteryContitions.setConditionId(id);
		return lotteryContitions;
	}
}
