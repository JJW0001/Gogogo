package gogogo.service;

import java.util.Map;

import gogogo.entity.User;

/**
 * @author 86155
 */
public interface IUserService {

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
	 * @param user �û�ʵ��
	 * @return  boolean
	 */
	boolean updateUserHead(User user);


	/**
	 * ��ȡ�û���Ϣ
	 * @param userName �û���
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchUserByName(String userName);
}
