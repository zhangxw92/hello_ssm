package com.athome.controller;

import com.athome.entity.Blog;
import com.athome.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Collection;
import java.util.List;

@Controller
public class JsonController {

    @Autowired
    private BlogService blogService;

    /**
     * 当使用@ResponseBody注解时，将会给浏览器响应文本内容，
     * SpringMvc需要依赖JackSon将文本以json的格式返回给浏览器
     * @return
     */
    @RequestMapping(value = "/testJSON", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Blog> testJson() {
        DispatcherServlet
        List<Blog> list = blogService.list();
        return list;
    }

    /**
     * 下载文件分为三步：1、获取要下载文件的路径；
     * 2、构建一个文件输入流，将文件读到内存中；
     * 3、利用ResponEntity将文件以附件的形式下载下来。
     *
     * @param httpSession
     * @return
     * @throws IOException
     */
    @RequestMapping("/down")
    public ResponseEntity<byte[]> down(HttpSession httpSession) throws IOException {

        //获取项目下文件夹的路径
        String realPath = httpSession.getServletContext().getRealPath("images");
        String path = realPath + File.separator + "aa.jpg";
        System.out.println(path);
        InputStream is = new FileInputStream(path);
        //attachment  /əˈtætʃmənt/ 附件
        byte[] b = new byte[is.available()];
        is.read(b);
        MultiValueMap map = new HttpHeaders();
        map.add("Content-Disposition", "attachment; filename=zz.jpg");
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(b, map, HttpStatus.OK);
        return entity;
    }

    /**
     * 注：上传文件时还需要引入fileupload依赖
     * 上传文件时，1、将要上传的对象用MutilpartFile对象接收，使用该对象
     * 可以获取到对象的所有信息；
     * 2、使用MutilpartFile构造一个输入流，将上传上来的文件写进内存；
     * 3、使用文件输出流将文件写到服务器的指定目录中。
     * 4、因为文件上传时是file类型，接收的时候使用MultipartFile接收，这
     * 中间需要配置CommonsMultipartResolver这个解析器进行解释处理。
     *
     * @param descrepe
     * @param uploadFile
     * @return
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(String descrepe, MultipartFile uploadFile, HttpSession session) throws Exception {

        //String name = uploadFile.getName();
        String originalFilename = uploadFile.getOriginalFilename();
        //System.out.println(name + "--" + originalFilename);

        String path = session.getServletContext().getRealPath("photo") + File.separator + originalFilename;
        System.out.println(path);
        InputStream inputStream = uploadFile.getInputStream();

        OutputStream outputStream = new FileOutputStream(new File(path));

/*        int i = 0;
        while ((i = inputStream.read()) != -1) {
            System.out.println(i);
            outputStream.write(i);
        }*/

        int i = 0;
        byte[] b = new byte[1024];
        while ((i = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, i);
        }

        outputStream.close();
        inputStream.close();
        return "success";
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String upload2(String descrepe, MultipartFile uploadFile, HttpSession session) throws Exception {

        //String name = uploadFile.getName();
        String originalFilename = uploadFile.getOriginalFilename();
        //System.out.println(name + "--" + originalFilename);

        String path = session.getServletContext().getRealPath("photo") + File.separator + originalFilename;
        System.out.println(path);
        File file = new File(path);
        uploadFile.transferTo(file);
        return "success";
    }

//    public static void main(String[] args) {
//        String path = "aa.dd.测试文件截取.jpg";
//        System.out.println(path.lastIndexOf("."));
//        System.out.println(path.substring(path.lastIndexOf(".")));
//    }
}
