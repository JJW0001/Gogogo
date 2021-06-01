package gogogo.dao;

import java.util.List;
import java.util.Map;

import gogogo.entity.User;

public interface IUserDao {
	/**
	 * ��ѯ�û��Ƿ��Ѵ���
	 * @param userName �û���
	 * @return boolean
	 */
	boolean isEmpty(String userName);


	/**
	 * �����û�
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean addUser(User user);


	/**
	 * ͨ���û��������û�
	 * @param userName �û���
	 * @return Map<String, Object>
	 */
	Map<String, Object> searchUserByName(String userName);


	/**
	 * �޸��û���Ϣ
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean updateUserInf(User user);


	/**
	 * ����ͷ��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean updateUserHead(User user);


	/**
	 * ���������û���Ϣ
	 * @return List<Object>
	 */
	List<Object> getAllUser();


	/**
	 * ͨ���û���ɾ���û�
	 * @param userName �û���
	 * @return boolean
	 */
	boolean deleteUserByName(String userName);


	/**
	 * �û���¼
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	boolean login(User user);
}