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
	 * ���빺�ﳵ
	 * �Ȼ�ȡҪ���빺�ﳵ����Ʒ�ڹ��ﳵ�е�����
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
    public boolean addCart(Carts cart) {
		//goodsNum��������carts_no��add_num
		Object[] goodsNum = icd.getGoodsNum(cart.getUserName(), cart.getGoodsNo());
		//Ҫ���빺�ﳵ����Ʒ�Լ����ڹ��ﳵ��
		if(goodsNum!=null){
			cart.setCartsNo((int)goodsNum[0]);
			cart.setAddNum((int)goodsNum[1]+1);
		}

		igs.reduceStock(cart.getGoodsNo());
		icd.addCarts(cart);
		return true;
	}


	/**
	 * ��ȡĳ�û����ﳵ
	 * @param cart cartsʵ��
	 * @return List<Object>
	 */
	@Override
	public List<Object> getCart(Carts cart) {
		return icd.getCart(cart);
	}


	/**
	 * ɾ��ĳ�û����ﳵĳ����Ʒ
	 * @param cart cartsʵ��
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
	 * ��ѯĳ�û��Ƿ��Ѿ���ĳ��Ʒ���빺�ﳵ
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(Carts cart) {
		return icd.isEmpty(cart);
	}

}
