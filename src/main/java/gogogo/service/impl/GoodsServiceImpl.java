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
	 * 查询商品是否已存在
	 * @param goodsNo 商品编号
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String goodsNo){
		return igd.searchGoodsById(goodsNo) == null;
	}

	/**
	 * 上架
	 * @param goods 商品实体
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
	 * 查找所有商品
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllGoods(){
		return igd.getAllGoods();
	}


	/**
	 * 查找所有商品,分页显示
	 * @param curPage 当前页数
	 * @return PageBean
	 */
	@Override
	public PageBean getAllGoods(int curPage){
		String sql = "select * from goods order by goods_stock";
		return gpi.getPageBean(sql, null, curPage);
	}


	/**
	 * 查找所有手机
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllPhone(){
		return igd.getAllPhone();
	}


	/**
	 * 查找所有鞋类
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getAllShoes(){
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
		String sql = "select * from goods where goods_desc like ?";
		Object[] params = {parameter};
		return gpi.getPageBean(sql, params, curPage);
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
		return igd.cutStock(goodsNo);
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
