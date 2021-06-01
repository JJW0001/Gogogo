package gogogo.servlet;
/*
 * 控制更换头像
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
		//上传时编码
		request.setCharacterEncoding("UTF-8");
		//响应时编码
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		/*
		 * 先上传本地图片并保存到当前项目的images文件夹中
		 */
		try {
			
			//得到去除路径的文件名
			String filename = null;
			//专门保存图片的文件夹images
			String imgPath = null;
			//判断是否成功上传
			boolean successUpload = false;
			
			//实例一个硬盘文件工厂，用来配置上传组件ServletFileUpload
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//设置缓冲区大小，这里是4kb
			factory.setSizeThreshold(4096);
			//用以上工厂实例化上传组件
			ServletFileUpload upload = new ServletFileUpload(factory);
			//设置最大文件尺寸，这里是4MB
			upload.setSizeMax(4194304);
			Thread.sleep(1000);
			//设置上传的地址，上传到当前项目的imges文件夹中
			String uploadPath = "E://MavenWorkSpace/Gogogo/src/main/webapp";
			//解析request的请求
			List<FileItem> fileList = upload.parseRequest(request);
			//逐条处理
			for (FileItem fi : fileList) {
				//得到当前文件流
				//得到文件的完整路径
				String path = fi.getName();
				//得到去除路径的文件名
				filename = path.substring(path.lastIndexOf("\\") + 1);
				//专门保存图片的文件夹images
				imgPath = "images/";
				//将文件保存在Web目录的images文件夹中
				String filePath = uploadPath + "/" + imgPath + filename;
				/*
				 * 只有获取到文件文件路径才上传
				 */
				if (!"".equals(filename)) {
					//开始把文件写道你指定的上传文件夹
					fi.write(new File(filePath));
					successUpload = true;
				}
			}
			
			
			/*
			 * 开始更换头像
			 */
			HttpSession session = request.getSession(true);
			String userName = (String)session.getAttribute("userName");
			
			User user = new User();
			user.setUserName(userName);
			//将头像保存的地址作为参数
			user.setUserHead(imgPath+filename);
			
			//获取用户信息
			Map<String, Object> userInf = service.searchUserByName(userName);
			
			request.setAttribute("userInf", userInf);
			//成功上传头像successUpload的值为true
			if(successUpload){
				//更换头像
				boolean check = service.updateUserHead(user);
				if(check){
					session.setAttribute("userHead", imgPath+filename);
					request.setAttribute("headChanged", "更换头像成功！");
					request.getRequestDispatcher("personalData.jsp").forward(request, response);
				}
			}else{
				request.setAttribute("headChanged", "更换头像失败，未选择图片！");
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
