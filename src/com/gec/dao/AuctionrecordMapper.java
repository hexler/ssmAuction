package com.gec.dao;

import com.gec.pojo.Auctionrecord;

import java.util.List;

public interface AuctionrecordMapper {
    /**
     * 根据商品id查询竞拍记录
     * @param auctionid
     * @return
     */
    List<Auctionrecord> getAuctionrecordList(Integer auctionid);

    void saveAuctionrecord(Auctionrecord auctionrecord);
}
