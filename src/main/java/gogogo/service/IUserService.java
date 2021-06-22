package gogogo.service;

import java.util.Map;

import gogogo.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 86155
 */
public interface IUserService {

	/**
	 * ��ѯ�û��Ƿ��Ѵ���
	 * @param userName �û���
	 * @return boolean
	 */
	boolean isEmpty(String userName);

	/**
	 * ע��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean addUser(User user);


	/**
	 * ��¼
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean login(User user);


	/**
	 * ����ͷ��
	 * @return  boolean
	 */
	boolean updateUserHead();


	/**
	 * ��ȡ�û���Ϣ
	 * @param userName �û���
	 * @return String
	 */
	String searchUserByName(String userName);
}
