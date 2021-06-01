package gogogo.servlet;
/*
 * ���ƻ�ȡ������Ʒ����ҳ��ʾ
 */

import gogogo.bean.PageBean;
import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author 86155
 */
@WebServlet("/GetAllGoodsServlet")
public class GetAllGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//��ȡҪ��ת����ҳ
		String curPage1 = request.getParameter("curPage");
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");
		
		int curPage2 = 1;
		if(curPage1!=null){
			curPage2 = Integer.parseInt(curPage1);
		}
		
		//��ȡ������Ʒ����ҳ��ʾ
		PageBean allGoods = service.getAllGoods(curPage2);
		
		request.setAttribute("tip", tip);
		request.setAttribute("allGoods", allGoods);
		request.getRequestDispatcher("allGoods.jsp").forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
