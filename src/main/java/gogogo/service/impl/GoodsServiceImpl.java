package gogogo.service.impl;

import gogogo.bean.PageBean;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Goods;
import gogogo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 86155
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
	
	private IGoodsDao igd;

	@Autowired
	public GoodsServiceImpl(IGoodsDao igd) {
		this.igd = igd;
	}

	/**
	 * �ϼ�
	 * @param goods ��Ʒʵ��
	 * @return boolean
	 */
	@Override
	public boolean purchase(Goods goods){
		if(igd.isEmpty(goods.getGoodsNo())) {
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
	public List<Object> getAllGoods(){
		return igd.getAllGoods();
	}


	/**
	 * ����������Ʒ,��ҳ��ʾ
	 * @param curPage ��ǰҳ��
	 * @return PageBean
	 */
	@Override
	public PageBean getAllGoods(int curPage){
		return igd.getAllGoods(curPage);
	}


	/**
	 * ���������ֻ�
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllPhone(){
		return igd.getAllPhone();
	}


	/**
	 * ��������Ь��
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllShoes(){
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
		return igd.search(parameter, curPage);
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
		return igd.reduceStock(goodsNo);
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
