package gogogo.servlet;
/*
 * ���ƽ����ﳵ�е���Ʒɾ��
 */

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 86155
 */
@WebServlet("/DeleteUserCartGoodsServlet")
public class DeleteUserCartGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICartsService service = WebUtil.getBean(ICartsService.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String goodsNo = request.getParameter("goodsNo");

		//ִ��ɾ������
		Carts cart = new Carts(userName, goodsNo);
		boolean check = false;

		try {
			check = service.deleteUserCartGoods(cart);
		}catch (ArithmeticException e){
			e.printStackTrace();
		}

		if(check){
			HttpSession session = request.getSession(true);
			String userName1 = (String)session.getAttribute("userName");
			//����ת����UserCartServlet
			request.getRequestDispatcher("UserCartServlet?userName="+userName1).forward(request, response);
		}else{
			request.setAttribute("deleteError", "���ڲ���֪ԭ��ɾ��ʧ�ܣ�");
			HttpSession session = request.getSession(true);
			String userName1 = (String)session.getAttribute("userName");
			request.getRequestDispatcher("UserCartServlet?userName="+userName1).forward(request, response);
		}
			
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
