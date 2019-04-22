package lottery.service;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class HandleFile {
	 	private static final long serialVersionUID = 1L;
     
	    // 上传文件存储目录
	
	    private boolean isMultipart;
	    private int maxFileSize = 1024 * 1024 * 10;
	    private int maxMemSize = 100 * 1024;
	    public  String processRequest(HttpServletRequest request, HttpServletResponse response,ServletContext context)
            throws Exception {
		 // 检查是否有一个文件上传请求
        isMultipart = ServletFileUpload.isMultipartContent(request);
        String result = "";
        response.setContentType("text/html;charset=utf-8");
        if (!isMultipart) {
            result = "未获取到文件";
            response.getWriter().println(result);
            return null;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 文件大小的最大值将被存储在内存中
        factory.setSizeThreshold(maxMemSize);
        // Location to save data that is larger than maxMemSize.
        String path = context.getRealPath("/") + "/";
        factory.setRepository(new File(path));
        // 创建一个新的文件上传处理程序
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 允许上传的文件大小的最大值
        upload.setSizeMax(maxFileSize);       
        // 解析请求，获取文件项
        List fileItems = upload.parseRequest(request);
        // 处理上传的文件项
        Iterator i = fileItems.iterator();
        String realPath = null;
        while (i.hasNext()) {
            FileItem fi = (FileItem) i.next();
            if (!fi.isFormField()) {
                // 写入文件
            	realPath = path + System.currentTimeMillis() / 1000 + ".txt";
                File file = new File(realPath);
                fi.write(file);
            }
        }
      return realPath;
    }
}
