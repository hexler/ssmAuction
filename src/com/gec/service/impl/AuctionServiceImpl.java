package com.gec.service.impl;

import com.gec.dao.AuctionMapper;
import com.gec.pojo.Auction;
import com.gec.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {
    @Autowired
    AuctionMapper auctionMapper;
    @Override
    public List<Auction> getAuctionList() {

        List<Auction> auctionList = auctionMapper.getAuctionList();
        return auctionList;
    }

    @Override
    public Auction getAuctionByAuctionid(Integer auctionid) {
        return auctionMapper.getAuctionByAuctionid(auctionid);
    }
}
