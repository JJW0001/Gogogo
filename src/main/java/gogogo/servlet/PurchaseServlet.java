package gogogo.servlet;
/*
 * ���Ƽ��ͨ����goods������¼��
 */

import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 86155
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IGoodsService service = WebUtil.getBean(IGoodsService.class);
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String goodsNo = "shoes6";
			String shelvesAdr = "images/list06.jpg";
			String cartAdr = "images/clist06.png";
			float goodsPrice = 236.00f;
			int goodsStock = 1253;
			String goodsDesc = "Ь���к��泱���˶���ʿѧ�������ϵ�Ь�ٴ�������Ьins��Ь";
			String goodsState = "���ϼ�";
			Goods goods = new Goods(goodsNo, shelvesAdr, cartAdr, goodsPrice, goodsStock, goodsDesc,goodsState);
			
			if(service.purchase(goods)){
				System.out.println("��ӳɹ���");
				response.sendRedirect("shoes.jsp");
				return;
			}
			else {
				System.out.println("���ʧ�ܣ�");
			}
	}
		

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
