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

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Collection;
import java.util.List;

@Controller
public class JsonController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/testJSON", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Blog> testJson() {
        List<Blog> list = blogService.list();
        return list;
    }

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
     * 上传文件时还需要引入fileupload依赖
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
