package gogogo.service.impl;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.GetPageInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	private final IGoodsDao igd;
	private final GetPageInf gpi;
	private final HttpServletRequest request;

	@Autowired
	public GoodsServiceImpl(IGoodsDao igd, GetPageInf gpi, HttpServletRequest request) {
		this.igd = igd;
		this.gpi = gpi;
		this.request = request;
	}

	/**
	 * ��ѯ��Ʒ�Ƿ��Ѵ���
	 * @param goodsNo ��Ʒ���
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String goodsNo){
		return igd.searchGoodsById(goodsNo) == null;
	}

	/**
	 * �ϼ�
	 * @param goods ��Ʒʵ��
	 * @return String
	 */
	@Override
	public String purchase(Goods goods){
		if(isEmpty(goods.getGoodsNo())) {
			igd.purchase(goods);
		}
		return "index";
	}


	/**
	 * ����������Ʒ
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllGoods(){
		return igd.getAllGoods();
	}


	/**
	 * ����������Ʒ,��ҳ��ʾ
	 * @return String
	 */
	@Override
	public String getAllGoodsPage(){
		//��ȡҪ��ת����ҳ
		String curPage1 = request.getParameter("curPage");
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");

		int curPage2 = 1;
		if(curPage1!=null){
			curPage2 = Integer.parseInt(curPage1);
		}

		//��ȡ������Ʒ����ҳ��ʾ
		String sql = "select * from goods order by goods_stock";
		PageBean allGoods = gpi.getPageBean(sql, null, curPage2);

		request.setAttribute("tip", tip);
		request.setAttribute("allGoods", allGoods);

		return "allGoods";
	}


	/**
	 * ���������ֻ�
	 * @return String
	 */
	@Override
	public String getAllPhone(){
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");

		//��ȡ�����ֻ�
		ArrayList<Map<String,Object>> allPhone = (ArrayList<Map<String,Object>>)igd.getAllPhone();

		request.setAttribute("tip", tip);
		request.setAttribute("allPhone", allPhone);

		return "phone";
	}


	/**
	 * ��������Ь��
	 * @return String
	 */
	@Override
	public String getAllShoes(){
		//�ɹ����빺�ﳵ��AddCartServlet.java�����Ĳ�����
		String tip = request.getParameter("tip");

		//��ȡ����Ь��
		ArrayList<Map<String,Object>> allShoes = (ArrayList<Map<String,Object>>)igd.getAllShoes();

		request.setAttribute("tip", tip);
		request.setAttribute("allShoes", allShoes);

		return "shoes";
	}


	/**
	 * ������Ʒ
	 * @return String
	 */
	@Override
	public String search() {
		String tip = request.getParameter("tip");
		String param1 = request.getParameter("search");
		String curPage1 = request.getParameter("curPage");

		String parameter = "%iphone%";
		if(!"".equals(param1)){
			parameter = "%" + param1 + "%";
		}

		int curPage2 = 1;
		if(curPage1!=null){
			curPage2 = Integer.parseInt(curPage1);
		}

		String sql = "select * from goods where goods_desc like ?";
		Object[] params = {parameter};
		PageBean goods = gpi.getPageBean(sql, params, curPage2);

		request.setAttribute("tip", tip);
		request.setAttribute("goods", goods);
		request.setAttribute("param", param1);

		return "search";
	}


	/**
	 * �޸���Ʒ��Ϣ
	 * @param goods  ��Ʒʵ��
	 * @return boolean
	 */
	@Override
	public boolean updateGoodsInf(Goods goods) {
		return igd.updateGoodsInf(goods);
	}


	/**
	 * ���¼�
	 * @param goods ��Ʒʵ��
	 * @return String
	 */
	@Override
	public String onOffShelf(Goods goods){
		//ִ����Ʒ�����¼�
		boolean check = igd.onOffShelf(goods);
		//��ȡ������Ʒ
		List<Map<String,Object>> allGoods = igd.getAllGoods();
		request.setAttribute("allGoods", allGoods);

		if(check){
			/*
			 * ���¼���ʾ
			 */
			String onShelf = "���ϼ�";
			String offShelf = "���¼�";
			if(goods.getGoodsState().equals(onShelf)){
				request.setAttribute("GIChange", "���ϼ�");
			}else if(goods.getGoodsState().equals(offShelf)){
				request.setAttribute("GIChange", "���¼�");
			}
		}else{
			request.setAttribute("GIChange", "������");
		}

		return "admin";
	}

	/**
	 * �����
	 * @param goodsNo ��Ʒ���
	 * @return int
	 */
	@Override
	public int reduceStock(String goodsNo) {
		return igd.cutStock(goodsNo);
	}

	/**
	 * �ӿ��
	 * @param goodsNo ��Ʒ���
	 * @return int
	 */
	@Override
	public int addStock(String goodsNo, int num) {
		return igd.addStock(goodsNo, num);
	}
}
