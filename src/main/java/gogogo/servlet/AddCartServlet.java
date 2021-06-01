package gogogo.servlet;
/*
 * ���Ƽ��빺�ﳵ
 */

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.WebUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 86155
 */
@WebServlet("/AddCart")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ICartsService service = WebUtil.getBean(ICartsService.class);

    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//��ȡ��ǰʱ�����
		Date date=new Date();
		//����һ����ʽ�����ڶ���
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String goodsNo = request.getParameter("goodsNo");
		String addTime = simpleDateFormat.format(date);

		/*
		 * �û�ֻ���ڵ�½��userName���ԲŲ�Ϊ�գ�
		 * �ڶ�Ӧҳ�������빺�ﳵ��AddCartServlet.java��Ӧ
		 */
		if(!"".equals(userName)){
			Carts cart = new Carts(null,userName, goodsNo, 1, addTime);


			//��ѯ��Ӧ�û��Ƿ񽫶�Ӧ��Ʒ��������ﳵ
			boolean empty = service.isEmpty(cart);
			boolean check = false;
			try {
				check = service.addCart(cart);
			}catch (ArithmeticException e){
				e.printStackTrace();
			}
			/*
			 * �ɹ����빺�ﳵ��checkֵΪtrue�����ж�empty��ֵ��emptyֵΪtrue˵��ĳ��Ʒ��������ﳵ��
			 * ��ʱ��goodsNum��ĳ�û����ﳵ�в�ͬ��Ʒ����������ֵ��1
			 * ���emptyֵΪfalse˵��ĳ��Ʒδ��������ﳵ���򲻽�goodsNum��ֵ��1
			 * 
			 * �����ڲ�ͬҳ�������빺�ﳵ��thisPage��ֵ���᲻ͬ���ж�thisPage��ֵ����ת����ͬ��servlet�Ի�ȡ��Ʒ����
			 */
			if(check){
				if(empty){
					HttpSession session = request.getSession(true);
					int goodsNum = (int)session.getAttribute("goodsNum");
					session.setAttribute("goodsNum", goodsNum+1);
				}

				//�ɹ����빺�ﳵ��ʾ
				String tip = "tip";
				String phone = "phone.jsp", shoes = "shoes.jsp", allGoods = "allGoods.jsp", searchJsp = "search.jsp";
				String thisPage = "thisPage";
				if(phone.equals(request.getParameter(thisPage))){
					response.sendRedirect("GetAllPhoneServlet?tip="+tip);
					return;
					
					
				}else if(shoes.equals(request.getParameter(thisPage))){
					response.sendRedirect("GetAllShoesServlet?tip="+tip);
					return;
					
					
				}else if(allGoods.equals(request.getParameter(thisPage))){
					String curPage = request.getParameter("curPage");
					response.sendRedirect("GetAllGoodsServlet?curPage="+curPage+"&tip="+tip);
					return;
					
					
				}else if(searchJsp.equals(request.getParameter(thisPage))){
					String curPage = request.getParameter("curPage");
					String search = request.getParameter("search");
					response.sendRedirect("SearchServlet?curPage="+curPage+"&search="+search+"&tip="+tip);
					return;
				}
			}
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}

}
