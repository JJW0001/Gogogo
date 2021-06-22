package gogogo.service;

import java.util.Map;

import gogogo.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 86155
 */
public interface IUserService {

	/**
	 * 查询用户是否已存在
	 * @param userName 用户名
	 * @return boolean
	 */
	boolean isEmpty(String userName);

	/**
	 * 注册
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean addUser(User user);


	/**
	 * 登录
	 * @param user 用户实体
	 * @return boolean
	 */
	boolean login(User user);


	/**
	 * 更换头像
	 * @return  boolean
	 */
	boolean updateUserHead();


	/**
	 * 获取用户信息
	 * @param userName 用户名
	 * @return String
	 */
	String searchUserByName(String userName);
}
