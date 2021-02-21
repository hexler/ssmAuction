package com.gec.dao;

import com.gec.pojo.Auction;

import java.util.List;

public interface AuctionMapper {

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
