package gogogo.servlet;
/*
 * ���Ƹ���ͷ��
 */

import gogogo.entity.User;
import gogogo.service.IUserService;
import gogogo.util.WebUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class FileUploadServlet
 * @author 86155
 */
@WebServlet("/UpdateHeadServlet")
public class UpdateHeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserService service = WebUtil.getBean(IUserService.class);
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//�ϴ�ʱ����
		request.setCharacterEncoding("UTF-8");
		//��Ӧʱ����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * ���ϴ�����ͼƬ�����浽��ǰ��Ŀ��images�ļ�����
		 */
		try {
			
			//�õ�ȥ��·�����ļ���
			String filename = null;
			//ר�ű���ͼƬ���ļ���images
			String imgPath = null;
			//�ж��Ƿ�ɹ��ϴ�
			boolean successUpload = false;
			
			//ʵ��һ��Ӳ���ļ����������������ϴ����ServletFileUpload
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//���û�������С��������4kb
			factory.setSizeThreshold(4096);
			//�����Ϲ���ʵ�����ϴ����
			ServletFileUpload upload = new ServletFileUpload(factory);
			//��������ļ��ߴ磬������4MB
			upload.setSizeMax(4194304);
			Thread.sleep(1000);
			//�����ϴ��ĵ�ַ���ϴ�����ǰ��Ŀ��imges�ļ�����
			String uploadPath = "E://MavenWorkSpace/Gogogo/src/main/webapp";
			//����request������
			List<FileItem> fileList = upload.parseRequest(request);
			//��������
			for (FileItem fi : fileList) {
				//�õ���ǰ�ļ���
				//�õ��ļ�������·��
				String path = fi.getName();
				//�õ�ȥ��·�����ļ���
				filename = path.substring(path.lastIndexOf("\\") + 1);
				//ר�ű���ͼƬ���ļ���images
				imgPath = "images/";
				//���ļ�������WebĿ¼��images�ļ�����
				String filePath = uploadPath + "/" + imgPath + filename;
				/*
				 * ֻ�л�ȡ���ļ��ļ�·�����ϴ�
				 */
				if (!"".equals(filename)) {
					//��ʼ���ļ�д����ָ�����ϴ��ļ���
					fi.write(new File(filePath));
					successUpload = true;
				}
			}
			
			
			/*
			 * ��ʼ����ͷ��
			 */
			HttpSession session = request.getSession(true);
			String userName = (String)session.getAttribute("userName");
			
			User user = new User();
			user.setUserName(userName);
			//��ͷ�񱣴�ĵ�ַ��Ϊ����
			user.setUserHead(imgPath+filename);
			
			//��ȡ�û���Ϣ
			Map<String, Object> userInf = service.searchUserByName(userName);
			
			request.setAttribute("userInf", userInf);
			//�ɹ��ϴ�ͷ��successUpload��ֵΪtrue
			if(successUpload){
				//����ͷ��
				boolean check = service.updateUserHead(user);
				if(check){
					session.setAttribute("userHead", imgPath+filename);
					request.setAttribute("headChanged", "����ͷ��ɹ���");
					request.getRequestDispatcher("personalData.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("headChanged", "����ͷ��ʧ�ܣ�δѡ��ͼƬ��");
				request.getRequestDispatcher("personalData.jsp").forward(request, response);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
