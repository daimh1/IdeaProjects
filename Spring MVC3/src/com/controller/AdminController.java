package com.controller;

import com.bean.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request, Admin admin, MultipartFile photo){
        String saveDir=request.getServletContext().getRealPath("/headers");

        //原来的文件名
        String originalFilename = photo.getOriginalFilename();


        File destFile = new File(saveDir,originalFilename);
        try {
            photo.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }


        admin.setPhotoPath("headers/"+originalFilename);

        ModelAndView mv =new ModelAndView();
        mv.setViewName("/admin.jsp");
        mv.addObject("admin",admin);


        return mv;
    }

    @RequestMapping("/register2")
    public ModelAndView register(HttpServletRequest request,MultipartFile[] photo){
        String saveDir=request.getServletContext().getRealPath("/headers");

        if(photo!=null){
            for(MultipartFile file:photo){
                String originalFilename=file.getOriginalFilename();

                File destFile=new File(saveDir,originalFilename);

                try {
                    file.transferTo(destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("save ok!"+destFile.getAbsolutePath());
            }
        }

        ModelAndView mv=new ModelAndView();
        mv.setViewName("/admin.jsp");

        return mv;
    }
}
