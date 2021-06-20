package gogogo.service.impl;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import gogogo.util.GetPageInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	private final IGoodsDao igd;
	private final GetPageInf gpi;

	@Autowired
	public GoodsServiceImpl(IGoodsDao igd, GetPageInf gpi) {
		this.igd = igd;
		this.gpi = gpi;
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
	 * @return boolean
	 */
	@Override
	public boolean purchase(Goods goods){
		if(isEmpty(goods.getGoodsNo())) {
			return igd.purchase(goods);
		} else {
			return false;
		}
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
	 * @param curPage ��ǰҳ��
	 * @return PageBean
	 */
	@Override
	public PageBean getAllGoods(int curPage){
		String sql = "select * from goods order by goods_stock";
		return gpi.getPageBean(sql, null, curPage);
	}


	/**
	 * ���������ֻ�
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllPhone(){
		return igd.getAllPhone();
	}


	/**
	 * ��������Ь��
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllShoes(){
		return igd.getAllShoes();
	}


	/**
	 * ������Ʒ
	 * @param parameter �����ؼ���
	 * @param curPage  ��ǰҳ��
	 * @return PageBean
	 */
	@Override
	public PageBean search(String parameter, int curPage) {
		String sql = "select * from goods where goods_desc like ?";
		Object[] params = {parameter};
		return gpi.getPageBean(sql, params, curPage);
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
	 * @return boolean
	 */
	@Override
	public boolean onOffShelf(Goods goods){
		return igd.onOffShelf(goods) > 0;
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
