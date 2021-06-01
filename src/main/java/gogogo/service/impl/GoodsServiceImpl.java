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
	 * 上架
	 * @param goods 商品实体
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
	 * 查找所有商品
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllGoods(){
		return igd.getAllGoods();
	}


	/**
	 * 查找所有商品,分页显示
	 * @param curPage 当前页数
	 * @return PageBean
	 */
	@Override
	public PageBean getAllGoods(int curPage){
		return igd.getAllGoods(curPage);
	}


	/**
	 * 查找所有手机
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllPhone(){
		return igd.getAllPhone();
	}


	/**
	 * 查找所有鞋类
	 * @return List<Object>
	 */
	@Override
	public List<Object> getAllShoes(){
		return igd.getAllShoes();
	}


	/**
	 * 搜索商品
	 * @param parameter 搜索关键字
	 * @param curPage  当前页数
	 * @return PageBean
	 */
	@Override
	public PageBean search(String parameter, int curPage) {
		return igd.search(parameter, curPage);
	}


	/**
	 * 修改商品信息
	 * @param goods  商品实体
	 * @return boolean
	 */
	@Override
	public boolean updateGoodsInf(Goods goods) {
		return igd.updateGoodsInf(goods);
	}


	/**
	 * 上下架
	 * @param goods 商品实体
	 * @return boolean
	 */
	@Override
	public boolean onOffShelf(Goods goods){
		return igd.onOffShelf(goods) > 0;
	}

	/**
	 * 减库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int reduceStock(String goodsNo) {
		return igd.reduceStock(goodsNo);
	}

	/**
	 * 加库存
	 * @param goodsNo 商品编号
	 * @return int
	 */
	@Override
	public int addStock(String goodsNo, int num) {
		return igd.addStock(goodsNo, num);
	}
}
