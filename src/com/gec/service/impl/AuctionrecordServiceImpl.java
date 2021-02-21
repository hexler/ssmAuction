package com.gec.service.impl;

import com.gec.dao.AuctionrecordMapper;
import com.gec.dao.AuctionuserMapper;
import com.gec.pojo.Auctionrecord;
import com.gec.pojo.Auctionuser;
import com.gec.service.AuctionrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionrecordServiceImpl implements AuctionrecordService {
    @Autowired
    AuctionrecordMapper auctionrecordMapper;
    @Autowired
    AuctionuserMapper auctionuserMapper;
    @Override
    public List<Auctionrecord> getAuctionrecordList(Integer auctionid) {
        List<Auctionrecord> auctionrecordList = auctionrecordMapper.getAuctionrecordList(auctionid);
        for (Auctionrecord auctionrecord:auctionrecordList) {
            //根据用户id查询用户的名字
            Auctionuser auctionuser = auctionuserMapper.getAuctionuserByUserid(auctionrecord.getUserid());
            auctionrecord.setUser(auctionuser);
        }
        return auctionrecordList;
    }

    @Override
    public void saveAuctionrecord(Auctionrecord auctionrecord) {
        auctionrecordMapper.saveAuctionrecord(auctionrecord);
    }


}
