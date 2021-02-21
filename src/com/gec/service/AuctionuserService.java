package com.gec.service;

import com.gec.pojo.Auctionuser;

public interface AuctionuserService {
    /**
     * 根据用户名和密码查询用户
     * @param auctionuser
     * @return
     */
    Auctionuser getAuctionuserByUserNameAndUserPassWord(Auctionuser auctionuser);
}
