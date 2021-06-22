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
         * ���ϴ�����ͼƬ�����浽��ǰ��Ŀ��images�ļ�����
         */
        try {
            //�õ�ȥ��·�����ļ���
            String filename;
            //ר�ű���ͼƬ���ļ���images
            String imgPath;
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
                    return imgPath + filename;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
