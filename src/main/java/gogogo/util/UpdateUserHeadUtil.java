package gogogo.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

/**
 * @author 86155
 */
@Component
public class UpdateUserHeadUtil {
    public String updateUserHead(HttpServletRequest request){
        /*
         * 先上传本地图片并保存到当前项目的images文件夹中
         */
        try {
            //得到去除路径的文件名
            String filename;
            //专门保存图片的文件夹images
            String imgPath;
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
                    return imgPath + filename;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
