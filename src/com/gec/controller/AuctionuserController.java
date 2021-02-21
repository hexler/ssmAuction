package com.gec.controller;

import com.gec.pojo.Auctionuser;
import com.gec.service.AuctionuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
public class AuctionuserController {
    @Autowired
    AuctionuserService auctionuserService;

    @RequestMapping("/toLogin") //设置映射路径 在网页中访问
    public ModelAndView toLogin(){
        System.out.println("==========");
        ModelAndView modelAndView = new ModelAndView();
        //设置逻辑视图的名字
        modelAndView.setViewName("login");///WEB-INF/jsp/ login .jsp

        //跳转到login.jsp
        return modelAndView;
    }
    @RequestMapping("/login")
    public String login(Auctionuser auctionuser, HttpSession session, Model model){
        // 对象入参 ：表单的name的值要与类的属性名一致 name="userpassword"  private String userpassword;
        System.out.println("这是登录的方法");
        System.out.println("name: " +auctionuser.getUsername() + "   密码："+auctionuser.getUserpassword());
        //调用service的方法
        Auctionuser user = auctionuserService.getAuctionuserByUserNameAndUserPassWord(auctionuser);
        //判断是否登录成功
        if(user != null){//不为空 表示用户名和密码中正确 登录成功
            //将用户信息保存到session
            session.setAttribute("userinfo",user);
            //跳转到首页
            //先去查询首页的数据   redirect:重定向  不是一个请求   forward: 请求转发 一个请求
            return "forward:toIndex";
        }else{//登录失败
            System.out.println("登录失败");
            //错误提示信息  保存在session会一直存在 （浏览器不关闭）
            /*session.setAttribute("msg","用户名或密码错误，请重新登录！！");*/
            //一个请求有效
            model.addAttribute("msg","用户名或密码错误，请重新登录！！");
            //回到登录页面
            return "login";
        }
    }

    @RequestMapping("/quit")
    public String quit(HttpSession session){
        System.out.println("这是退出的方法");
        //清空session的数据
        session.invalidate();
        //回到登录页面
        return "login";
    }

   /* @RequestMapping("/login")
    public String login(String name,Integer password){
        System.out.println("这是登录的方法");
        System.out.println("name: " +name + "   密码："+password);
        return null;
    }*/

}
