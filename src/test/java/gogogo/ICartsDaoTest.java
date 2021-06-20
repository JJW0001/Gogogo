package gogogo;

import gogogo.entity.Carts;
import gogogo.service.ICartsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ICartsDaoTest {
    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
    private final ICartsService cartsService = ioc.getBean(ICartsService.class);

    /**
     * 加入购物车
     */
    @Test
    public void TestAddCart() {
        Carts cart = new Carts(null,"www", "ph9", 1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        boolean success = cartsService.addCart(cart);
        System.out.println(success);
    }

    /**
     * 获取某用户购物车
     */
    @Test
    public void testGetCart(){
        Carts cart = new Carts(null,"www", null, 0, null);
        List<Map<String, Object>> cart1 = cartsService.getCart(cart);
        for (Map<String, Object> map : cart1){
            System.out.println(map);
        }
    }

    /**
     * 删除某用户购物者中某样商品
     */
    @Test
    public void testDeleteUserCartGoods(){
        Carts cart = new Carts(null,"www", "ph9", 0, null);
        boolean success = cartsService.deleteUserCartGoods(cart);
        System.out.println(success);
    }
}
