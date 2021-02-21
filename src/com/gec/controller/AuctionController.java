package com.gec.controller;

import com.gec.pojo.Auction;
import com.gec.pojo.Auctionrecord;
import com.gec.service.AuctionServcie;
import com.gec.service.AuctionrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuctionController {
    @Autowired
    AuctionServcie auctionServcie;
    @Autowired
    AuctionrecordService auctionrecordService;

    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        System.out.println("这是首页的方法");
        //从前端获取数据
        //封装数据
        //调用serviceAPI 方法
        List<Auction> auctionList = auctionServcie.getAuctionList();
        for (Auction auction:auctionList) {
            System.out.println(auction);
        }
        //控制跳转

        //保存数据
        model.addAttribute("auctionList",auctionList);
        return "index";
    }

    @RequestMapping("/toAuction")
    public String toAuction(Integer auctionid,Model model){
        System.out.println(auctionid);
        //调用service的方法
        Auction auctionByAuctionid = auctionServcie.getAuctionByAuctionid(auctionid);
        //查询竞拍记录
        List<Auctionrecord> auctionrecordList = auctionrecordService.getAuctionrecordList(auctionid);


        //保存数据到model
        model.addAttribute("auctionByAuctionid",auctionByAuctionid);
        model.addAttribute("auctionrecordList",auctionrecordList);
        model.addAttribute("a1",auctionrecordList.get(0));

        return "auction";
    }
}
