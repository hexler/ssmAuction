package com.gec.dao;

import com.gec.pojo.Auctionuser;

public interface AuctionuserMapper {
    /**
     * 根据用户名和密码查询用户
     * @param auctionuser
     * @return
     */
    Auctionuser getAuctionuserByUserNameAndUserPassWord(Auctionuser auctionuser);

    /**
     * 根据userid查询用户
     * @param userid
     * @return
     */
    Auctionuser getAuctionuserByUserid(Integer userid);
}
