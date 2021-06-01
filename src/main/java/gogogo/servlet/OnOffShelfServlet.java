package gogogo.servlet;
/*
 * �����ϼ��¼ܣ�ͨ������goods���е�goods_state�ֶ�״̬��ʵ����Ʒ���¼�
 */

import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @author 86155
 */
@WebServlet("/OnOffShelfServlet")
public class OnOffShelfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String goodsNo = request.getParameter("goodsNo");
		String goodsState = request.getParameter("goodsState");
		
		Goods goods = new Goods(goodsNo, goodsState);
		
		//ִ����Ʒ�����¼�
		boolean check = service.onOffShelf(goods);
		//��ȡ������Ʒ
		List<Object> allGoods = service.getAllGoods();
		/*
		 * ���¼���ʾ
		 */
		String onShelf = "���ϼ�";
		String offShelf = "���¼�";
		if(goodsState.equals(onShelf)){
			request.setAttribute("GIChange", "���ϼ�");
		}else if(goodsState.equals(offShelf)){
			request.setAttribute("GIChange", "���¼�");
		}
		
		if(check){
			request.setAttribute("allGoods", allGoods);
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}else{
			System.out.println("��������");
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
