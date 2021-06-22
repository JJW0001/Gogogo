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
	 * ��ѯ�û��Ƿ��Ѵ���
	 * @param userName �û���
	 * @return boolean
	 */
	@Override
	public boolean isEmpty(String userName){
		return iud.searchUserByName(userName) == null;
	}

	/**
	 * ע��
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
    public boolean addUser(User user) {
		//�Ȳ�ѯ���û����Ƿ�ע���
		if(isEmpty(user.getUserName()))
		{
			user.setUserHead("images/head.jpg");
			if(iud.addUser(user)){
				request.setAttribute("alert", "ע��ɹ������¼ȷ�ϣ�");
				return true;
			}else {
				request.setAttribute("alert", "���ڲ���֪ԭ��ע��ʧ�ܣ�");
				return false;
			}
		} else {
			request.setAttribute("alert", "ע��ʧ�ܣ����û����ѱ�ע�ᣡ");
			return false;
		}
	}


	/**
	 * ��¼
	 * @param user �û�ʵ��
	 * @return boolean
	 */
	@Override
	public boolean login(User user){
		String userName = user.getUserName();

		if(iud.login(user) != null){
			//��ȡĳ�û���Ϣ
			Map<String, Object> userInf = iud.searchUserByName(userName);
			//�õ��û�ͷ��
			String userHead = (String)userInf.get("user_head");

			Carts cart = new Carts(userName);
			//��ȡĳ�û����ﳵ��Ϣ
			ArrayList<Map<String,Object>> userCart = (ArrayList<Map<String,Object>>)icd.getCart(cart);
			//�õ�ĳ�û����ﳵ�в�ͬ��Ʒ����
			int goodsNum = Calculation.getGoodsNum(userCart);

			HttpSession session = request.getSession();
			session.setAttribute("userHead", userHead);
			session.setAttribute("userName", userName);
			session.setAttribute("goodsNum", goodsNum);
			session.setMaxInactiveInterval(1800);

			return true;
		}else{
			request.setAttribute("alert", "��¼ʧ�ܣ��û����������������");
			return false;
		}
	}


	/**
	 * ����ͷ��
	 * @return boolean
	 */
	@Override
	public boolean updateUserHead() {
		//�ϴ�ͷ��
		String headPath = updateUserHeadUtil.updateUserHead(request);
		/*
		 * ��ʼ����ͷ��
		 */
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");

		User user = new User();
		user.setUserName(userName);
		//��ͷ�񱣴�ĵ�ַ��Ϊ����
		user.setUserHead(headPath);

		//��ȡ�û���Ϣ
		Map<String, Object> userInf = iud.searchUserByName(userName);
		request.setAttribute("userInf", userInf);

		//�ɹ��ϴ�ͷ��successUpload��ֵΪtrue
		if(headPath.endsWith(".jpg") || headPath.endsWith(".png")){
			//����ͷ��
			boolean check = iud.updateUserHead(user);
			if(check){
				session.setAttribute("userHead", headPath);
				request.setAttribute("headChanged", "����ͷ��ɹ���");
				return true;
			}else {
				request.setAttribute("headChanged", "����ͷ��ʧ�ܣ�");
				return false;
			}
		}else{
			request.setAttribute("headChanged", "�ϴ�ͷ��ʧ�ܣ�δѡ��ͼƬ��");
			return false;
		}
	}


	/**
	 * ��ȡ�û���Ϣ
	 * @param userName �û���
	 * @return String
	 */
	@Override
	public String searchUserByName(String userName) {
		//��ȡ�û���Ϣ
		Map<String, Object> userInf = iud.searchUserByName(userName);

		request.setAttribute("userInf", userInf);

		return "personalData";
	}
	
}
