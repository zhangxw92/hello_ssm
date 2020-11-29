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

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
}
