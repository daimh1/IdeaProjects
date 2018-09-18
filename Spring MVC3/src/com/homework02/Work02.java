package com.homework02;


import com.bean.Work02User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class Work02 {

    @RequestMapping("/work02")
    public ModelAndView register(HttpServletRequest request, Work02User user, MultipartFile image){
        //使用封装user中的setimage名不能和传过来的文件名相同
        System.out.println(user);
        String saveDir=request.getServletContext().getRealPath("/headers");

        String originalFilename=image.getOriginalFilename();
        File destFile=new File(saveDir,originalFilename);

        try {
            image.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setImage1("headers/"+originalFilename);
        System.out.println(user);


        ModelAndView mv=new ModelAndView();
        mv.setViewName("/admin.jsp");
        mv.addObject("admin",user);
        return mv;
    }
}
