package com.gec.controller;

import com.gec.pojo.Auctionrecord;
import com.gec.pojo.Auctionuser;
import com.gec.service.AuctionrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class AuctionrecordController {

    @Autowired
    AuctionrecordService auctionrecordService;

    @RequestMapping("/saveAuctionrecord")
    public String saveAuctionrecord(Model model, Auctionrecord auctionrecord, HttpSession session){
        //封装数据
        auctionrecord.setAuctiontime(new Date());
        Auctionuser userinfo = (Auctionuser) session.getAttribute("userinfo");
        auctionrecord.setUserid(userinfo.getUserid());
        //调用service的方法
        auctionrecordService.saveAuctionrecord(auctionrecord);
        //model.addAttribute("auctionid",auctionrecord.getAuctionid());

        return "redirect:toAuction?auctionid="+auctionrecord.getAuctionid();
    }
}
