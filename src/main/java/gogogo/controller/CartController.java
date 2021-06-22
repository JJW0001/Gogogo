package gogogo.controller;

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 86155
 */
@Controller
public class CartController {
    private final ICartsService ics;

    @Autowired
    public CartController(ICartsService ics){
        this.ics = ics;
    }

    /**
     * 加入购物车
     * @param userName 用户名
     * @param goodsNo 商品编号
     * @param thisPage 当前页
     * @param curPage 当前分页
     * @param search 搜索关键词
     * @return 请求页面
     */
    @RequestMapping(value = "/AddCart", method = RequestMethod.GET)
	public String addCart(@RequestParam(value = "userName") String userName,
						  @RequestParam(value = "goodsNo") String goodsNo,
						  @RequestParam(value = "thisPage") String thisPage,
						  @RequestParam(value = "curPage",required = false, defaultValue = "") String curPage,
						  @RequestParam(value = "search",required = false, defaultValue = "") String search){


		String page = ics.addCart(userName, goodsNo, thisPage, curPage, search);
		return "forward:/" + page;
	}


	/**
	 * 删除购物车商品
	 * @param cart 购物车信息
	 * @return 请求页面
	 */
	@RequestMapping(value = "/DeleteUserCartGoodsServlet", method = RequestMethod.GET)
	public String deleteCartGoods(Carts cart){
		String page = ics.deleteUserCartGoods(cart);
		return "forward:/" + page;
	}


	/**
	 * 获取用户购物车信息
	 * @param userName 用户名
	 * @return 请求页面
	 */
	@RequestMapping(value = "/UserCartServlet", method = RequestMethod.GET)
	public String userCart(@RequestParam("userName") String userName) {
		return ics.getCart(userName);
	}
}
