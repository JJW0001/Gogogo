package gogogo.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
public class Calculation {

	/**
	 * 计算总价
	 */
	public static float getTotalPrice(List<Map<String,Object>> userCart){
		float totalPrice = 0;
		for(Object o : userCart){
			@SuppressWarnings("unchecked")
			Map<String, Object> map = (HashMap<String, Object>)o;
			totalPrice +=  (float)map.get("goods_price")*(int)map.get("add_num");
		}
		return totalPrice;
	}


	/**
	 * 获取购物车不同商品数量
	 */
	public static int getGoodsNum(List<Map<String,Object>> userCart) {
		int goodsNum = 0;

		for (Object o : userCart) {
			goodsNum += 1;
		}
		
		return goodsNum;
	}
}
