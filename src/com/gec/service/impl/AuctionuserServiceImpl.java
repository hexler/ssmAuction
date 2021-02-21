package com.gec.service.impl;

import com.gec.dao.AuctionuserMapper;
import com.gec.pojo.Auctionuser;
import com.gec.service.AuctionuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//spring容器创建对象
public class AuctionuserServiceImpl implements AuctionuserService {
    //DI依赖注入 自动注入需要的东西
    @Autowired //默认按类型自动装配 自动注入对象
    AuctionuserMapper auctionuserMapper;
    @Override
    public Auctionuser getAuctionuserByUserNameAndUserPassWord(Auctionuser auctionuser) {
        Auctionuser user = auctionuserMapper.getAuctionuserByUserNameAndUserPassWord(auctionuser);
        return user;
    }

    /*public void setAuctionuserMapper(AuctionuserMapper auctionuserMapper) {
        this.auctionuserMapper = auctionuserMapper;
    }*/
}
