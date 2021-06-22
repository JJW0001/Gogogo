package gogogo.service.impl;

import gogogo.dao.ICartsDao;
import gogogo.dao.IUserDao;
import gogogo.entity.Carts;
import gogogo.entity.User;
import gogogo.service.IUserService;
import gogogo.util.Calculation;
import gogogo.util.UpdateUserHeadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author 86155
 */
@Service
public class UserServiceImpl implements IUserService {

	private final IUserDao iud;
	private final ICartsDao icd;
	private final HttpServletRequest request;
	private final UpdateUserHeadUtil updateUserHeadUtil;

	@Autowired
	public UserServiceImpl(IUserDao iud, ICartsDao icd, HttpServletRequest request, UpdateUserHeadUtil updateUserHeadUtil) {
		this.iud = iud;
		this.icd = icd;
		this.request = request;
		this.updateUserHeadUtil = updateUserHeadUtil;
	}

	/**
	 * 查询用户是否已存在
	 * @param userName 用户名
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String userName){
		return iud.searchUserByName(userName) == null;
	}

	/**
	 * 注册
	 * @param user 用户实体
	 * @return boolean
	 */
	@Override
    public boolean addUser(User user) {
		//先查询该用户名是否被注册过
		if(isEmpty(user.getUserName()))
		{
			user.setUserHead("images/head.jpg");
			if(iud.addUser(user)){
				request.setAttribute("alert", "注册成功，请登录确认！");
				return true;
			}else {
				request.setAttribute("alert", "由于不可知原因注册失败！");
				return false;
			}
		} else {
			request.setAttribute("alert", "注册失败，该用户名已被注册！");
			return false;
		}
	}


	/**
	 * 登录
	 * @param user 用户实体
	 * @return boolean
	 */
	@Override
	public boolean login(User user){
		String userName = user.getUserName();

		if(iud.login(user) != null){
			//获取某用户信息
			Map<String, Object> userInf = iud.searchUserByName(userName);
			//得到用户头像
			String userHead = (String)userInf.get("user_head");

			Carts cart = new Carts(userName);
			//获取某用户购物车信息
			ArrayList<Map<String,Object>> userCart = (ArrayList<Map<String,Object>>)icd.getCart(cart);
			//得到某用户购物车中不同商品数量
			int goodsNum = Calculation.getGoodsNum(userCart);

			HttpSession session = request.getSession();
			session.setAttribute("userHead", userHead);
			session.setAttribute("userName", userName);
			session.setAttribute("goodsNum", goodsNum);
			session.setMaxInactiveInterval(1800);

			return true;
		}else{
			request.setAttribute("alert", "登录失败，用户名或密码输入错误！");
			return false;
		}
	}


	/**
	 * 更换头像
	 * @return boolean
	 */
	@Override
	public boolean updateUserHead() {
		//上传头像
		String headPath = updateUserHeadUtil.updateUserHead(request);
		/*
		 * 开始更换头像
		 */
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");

		User user = new User();
		user.setUserName(userName);
		//将头像保存的地址作为参数
		user.setUserHead(headPath);

		//获取用户信息
		Map<String, Object> userInf = iud.searchUserByName(userName);
		request.setAttribute("userInf", userInf);

		//成功上传头像successUpload的值为true
		if(headPath.endsWith(".jpg") || headPath.endsWith(".png")){
			//更换头像
			boolean check = iud.updateUserHead(user);
			if(check){
				session.setAttribute("userHead", headPath);
				request.setAttribute("headChanged", "更换头像成功！");
				return true;
			}else {
				request.setAttribute("headChanged", "更换头像失败！");
				return false;
			}
		}else{
			request.setAttribute("headChanged", "上传头像失败，未选择图片！");
			return false;
		}
	}


	/**
	 * 获取用户信息
	 * @param userName 用户名
	 * @return String
	 */
	@Override
	public String searchUserByName(String userName) {
		//获取用户信息
		Map<String, Object> userInf = iud.searchUserByName(userName);

		request.setAttribute("userInf", userInf);

		return "personalData";
	}
	
}
