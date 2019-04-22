package lottery.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lottery.bean.AwardsForm;
import lottery.bean.LotteryConditions;
import lottery.dao.StoreAwardsForm;
import lottery.dao.StoreLotteryCondition;
import lottery.service.HandleConditions;
import lottery.service.HandleFile;
import lottery.service.HandleAwards;

/**
 * Servlet implementation class AwardsForm
 */
@WebServlet(name="AwardsFormServlet",urlPatterns="startLotteryDraw")
public class AwardsFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 生成奖项表、抽奖条件表并存入数据库
	 */
	public void service(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("test");
		try {
			List<AwardsForm> awardsForms = HandleAwards.handleJson(request);
			LotteryConditions lotteryConditions = HandleConditions.handleConditions(request);
			StoreAwardsForm.storeAwardsForm(awardsForms);
			StoreLotteryCondition.storeLotteryCondition(lotteryConditions);
			HandleFile hf = new HandleFile();
			String path = hf.processRequest(request, response, getServletContext());
			RequestDispatcher rd = request.getRequestDispatcher("");
			rd.forward(request, response);
			System.out.println("I am here!");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
