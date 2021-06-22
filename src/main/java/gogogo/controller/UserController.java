package gogogo.controller;

import gogogo.entity.User;
import gogogo.service.IGoodsService;
import gogogo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author 86155
 */
@Controller
public class UserController {
    private final IUserService ius;
    private final IGoodsService igs;
    private final HttpServletRequest request;

    @Autowired
    public UserController(IUserService ius, IGoodsService igs, HttpServletRequest request){
        this.ius = ius;
        this.igs = igs;
        this.request = request;
    }


    /**
     * 注册
     * @param user 用户信息
     * @return 请求页面
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addUser(User user){
        boolean success = ius.addUser(user);
        if(success){
            return "login";
        }
        else{
            return "register";
        }
    }


    /**
     * 管理员操作
     * @return 请求页面
     */
    @RequestMapping(value = "/AdminServlet", method = RequestMethod.GET)
    public String adminAction() {
        String userName = (String)request.getSession().getAttribute("userName");
        String managerName = "韦俊锦";

        if(userName.equals(managerName)){
            List<Map<String, Object>> allGoods = igs.getAllGoods();
            request.setAttribute("allGoods", allGoods);
            return "admin";
        }else{
            request.setAttribute("admin", "对不起，您不是管理员");
            return "index";
        }
    }


    /**
     * 注销
     * @param request request
     * @return 请求页面
     */
    @RequestMapping(value = "/CancelledServlet", method = RequestMethod.GET)
    public String cancelAction(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "index";
    }


    /**
     * 获取用户信息
     * @param session session
     * @return 请求页面
     */
    @RequestMapping(value = "/GetUserInfServlet", method = RequestMethod.GET)
    public String getUserInf(HttpSession session){
        String userName = (String) session.getAttribute("userName");
        return ius.searchUserByName(userName);
    }


    /**
     * 登录
     * @param user 用户信息
     * @return 请求页面
     */
    @RequestMapping(value = "/LoginServlet", method = RequestMethod.POST)
    public String loginServlet(User user){
        boolean success = ius.login(user);
        if (success){
            return "index";
        }else {
            return "login";
        }
    }


    /**
     * 更换头像
     * @return 请求页面
     */
    @RequestMapping(value = "/UpdateHeadServlet", method = RequestMethod.POST)
    public String updateHeadServlet() {
        ius.updateUserHead();
        return "personalData";
    }
}
