package gogogo.service.impl;

import gogogo.dao.ICartsDao;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.util.Calculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class CartsServiceImpl implements ICartsService {
	private final ICartsDao icd;
	private final IGoodsDao igd;
	private final HttpServletRequest request;

	@Autowired
	public CartsServiceImpl(ICartsDao icd, IGoodsDao igd, HttpServletRequest request) {
		this.icd = icd;
		this.igd = igd;
		this.request = request;
	}

	/**
	 * ���빺�ﳵ
	 * @param userName �û���
	 * @param goodsNo ��Ʒ���
	 * @param thisPage ��ǰҳ��
	 * @param curPage ��ҳҳ��
     * @param search �����ؼ���
	 * @return String
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
    public String addCart(String userName, String goodsNo, String thisPage, String curPage, String search) {
		//��ȡ��ǰʱ�����
		Date date=new Date();
		//����һ����ʽ�����ڶ���
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String addTime = simpleDateFormat.format(date);

		/*
		 * �û�ֻ���ڵ�½��userName���ԲŲ�Ϊ�գ�
		 * �ڶ�Ӧҳ�������빺�ﳵ��AddCartServlet.java��Ӧ
		 */
		if(!"".equals(userName)){
			Carts cart = new Carts(null,userName, goodsNo, 1, addTime);

			//��ѯ��Ӧ�û��Ƿ񽫶�Ӧ��Ʒ��������ﳵ
			boolean empty = isEmpty(cart);
			boolean check = false;

			/*
			�Ȳ�ѯ���ﳵ���Ƿ����ĳ����Ʒ�������������¼��빺�ﳵ�����������������
			*/
			Map<String, Object> goods = icd.getGoods(cart);
			try {
				if(goods == null){
					igd.cutStock(cart.getGoodsNo());
					check = icd.addCarts(cart);
				}else{
					cart.setCartsNo((int)goods.get("carts_no"));
					cart.setAddNum((int)goods.get("add_num")+1);
					igd.cutStock(cart.getGoodsNo());
					check = icd.updateCarts(cart);
				}
			}catch (Exception e){
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
					HttpSession session = request.getSession();
					int goodsNum = (int)session.getAttribute("goodsNum");
					session.setAttribute("goodsNum", goodsNum+1);
				}

				//�ɹ����빺�ﳵ��ʾ
				String tip = "tip";
				String phone = "phone.jsp", shoes = "shoes.jsp", allGoods = "allGoods.jsp", searchJsp = "search.jsp";
				if(phone.equals(thisPage)){
					return "GetAllPhoneServlet?tip="+tip;

				}else if(shoes.equals(thisPage)){
					return "GetAllShoesServlet?tip="+tip;

				}else if(allGoods.equals(thisPage)){
					return "GetAllGoodsServlet?curPage="+curPage+"&tip="+tip;

				}else if(searchJsp.equals(thisPage)){
					return "SearchServlet?curPage="+curPage+"&search="+search+"&tip="+tip;
				}
			}
		}else{
			return "login.jsp";
		}

		return "login.jsp";
	}


	/**
	 * ��ȡĳ�û����ﳵ
	 * @param userName �û���
	 * @return String
	 */
	@Override
	public String getCart(String userName) {
		if(!"".equals(userName)){
			Carts cart = new Carts(userName);
			//��ȡĳ�û��Ĺ��ﳵ��Ϣ
			List<Map<String,Object>> userCart = icd.getCart(cart);

			Iterator<Map<String,Object>> it = userCart.iterator();
			//��userCart�е�Ԫ�ظ���Ϊ0��˵�����û����ﳵΪ��
			if(!it.hasNext()){
				HttpSession session = request.getSession();
				//���ﳵ�в�ͬ��Ʒ����Ϊ0
				session.setAttribute("goodsNum", 0);
				//����request��Χ����Ч��cartEmpty���ԣ�����ֵΪcartEmpty����ʾ���ﳵΪ��
				request.setAttribute("cartEmpty", "cartEmpty");
			}else{
				//�ܼ�
				float totalPrice = Calculation.getTotalPrice(userCart);
				int goodsNum = Calculation.getGoodsNum(userCart);

				HttpSession session = request.getSession(true);
				session.setAttribute("goodsNum", goodsNum);

				request.setAttribute("totalPrice", totalPrice);
				request.setAttribute("userCart", userCart);
			}

			return "cart";
		}else{
			return "login";
		}
	}


	/**
	 * ɾ��ĳ�û����ﳵĳ����Ʒ
	 * @param cart cartsʵ��
	 * @return String
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public String deleteUserCartGoods(Carts cart) {
		boolean check = false;

		try {
			//ִ��ɾ������
			Map<String, Object> goods = icd.getGoods(cart);
			igd.addStock(cart.getGoodsNo(),(int)goods.get("add_num"));
			check = icd.deleteUserCartGoods(cart);
		}catch (Exception e){
			e.printStackTrace();
		}

		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		if (!check) {
			request.setAttribute("deleteError", "���ڲ���֪ԭ��ɾ��ʧ�ܣ�");
		}
		return "UserCartServlet";
	}


	/**
	 * ��ѯĳ�û��Ƿ��Ѿ���ĳ��Ʒ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(Carts cart) {
		return icd.getGoods(cart) == null;
	}

}
