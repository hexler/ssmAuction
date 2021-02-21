package com.gec.service;

import com.gec.pojo.Auction;

import java.util.List;

public interface AuctionServcie {
    //List 可以保存多个对象

    /**
     * 查询所有的商品信息
     * @return
     */
    List<Auction> getAuctionList();

    /**
     * 根据id查询auction
     * @param auctionid
     * @return
     */
    Auction getAuctionByAuctionid(Integer auctionid);
}
