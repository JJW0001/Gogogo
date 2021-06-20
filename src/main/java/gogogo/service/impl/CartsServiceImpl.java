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
	 * ���빺�ﳵ
	 * �Ȼ�ȡҪ���빺�ﳵ����Ʒ�ڹ��ﳵ�е�����
	 * @param cart cartsʵ��
	 * @return boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
    public boolean addCart(Carts cart) {
		/*
		�Ȳ�ѯ���ﳵ���Ƿ����ĳ����Ʒ�������������¼��빺�ﳵ�����������������
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
	 * ��ȡĳ�û����ﳵ
	 * @param cart cartsʵ��
	 * @return List<Object>
	 */
	@Override
	public List<Map<String,Object>> getCart(Carts cart) {
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
		Map<String, Object> goods = icd.getGoods(cart);
		igd.addStock(cart.getGoodsNo(),(int)goods.get("add_num"));
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
		return icd.getGoods(cart) == null;
	}

}
