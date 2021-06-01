package gogogo.service.impl;

import gogogo.dao.ICartsDao;
import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import gogogo.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 86155
 */
@Service
public class CartsServiceImpl implements ICartsService {
	private ICartsDao icd;
	private IGoodsService igs;

	@Autowired
	public CartsServiceImpl(ICartsDao icd, IGoodsService igs) {
		this.icd = icd;
		this.igs = igs;
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
		//goodsNum参数带有carts_no和add_num
		Object[] goodsNum = icd.getGoodsNum(cart.getUserName(), cart.getGoodsNo());
		//要加入购物车的商品以及存在购物车中
		if(goodsNum!=null){
			cart.setCartsNo((int)goodsNum[0]);
			cart.setAddNum((int)goodsNum[1]+1);
		}

		igs.reduceStock(cart.getGoodsNo());
		icd.addCarts(cart);
		return true;
	}


	/**
	 * 获取某用户购物车
	 * @param cart carts实体
	 * @return List<Object>
	 */
	@Override
	public List<Object> getCart(Carts cart) {
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
		igs.addStock(cart.getGoodsNo(),(int)icd.getGoodsNum(cart.getUserName(), cart.getGoodsNo())[1]);
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
		return icd.isEmpty(cart);
	}

}
