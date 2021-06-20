package gogogo.service.impl;

import gogogo.dao.ICartsDao;
import gogogo.dao.IGoodsDao;
import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class CartsServiceImpl implements ICartsService {
	private final ICartsDao icd;
	private final IGoodsDao igd;

	@Autowired
	public CartsServiceImpl(ICartsDao icd, IGoodsDao igd) {
		this.icd = icd;
		this.igd = igd;
	}

	/**
	 * 加入购物车
	 * 先获取要加入购物车的商品在购物车中的数量
	 * @param cart carts实体
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
    public boolean addCart(Carts cart) {
		/*
		先查询购物车中是否存在某样商品，若不存在则新加入购物车，若存在则更新数量
		 */
		Map<String, Object> goods = icd.getGoods(cart);
		if(goods == null){
			igd.cutStock(cart.getGoodsNo());
			icd.addCarts(cart);
		}else{
			cart.setCartsNo((int)goods.get("carts_no"));
			cart.setAddNum((int)goods.get("add_num")+1);
			igd.cutStock(cart.getGoodsNo());
			icd.updateCarts(cart);
		}

		return true;
	}


	/**
	 * 获取某用户购物车
	 * @param cart carts实体
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getCart(Carts cart) {
		return icd.getCart(cart);
	}


	/**
	 * 删除某用户购物车某件商品
	 * @param cart carts实体
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean deleteUserCartGoods(Carts cart) {
		Map<String, Object> goods = icd.getGoods(cart);
		igd.addStock(cart.getGoodsNo(),(int)goods.get("add_num"));
		icd.deleteUserCartGoods(cart);
		return true;
	}


	/**
	 * 查询某用户是否已经把某商品加入购物车
	 * @param cart carts实体
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(Carts cart) {
		return icd.getGoods(cart) == null;
	}

}
