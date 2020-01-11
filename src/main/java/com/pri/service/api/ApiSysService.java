package com.pri.service.api;

import com.pri.mapper.WxUserMapper;
import com.pri.entity.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: ApiSysService
 * @Description:
 * @Auther: Chenqi
 * @Date: 2019/4/24 11:38
 * @Version 1.0 jdk1.8
 */
@Service
public class ApiSysService {
    @Autowired
    private WxUserMapper wxUserMapper;

    /**
     *@MethodName:  selectByOpenid
     *@Description: 根据openid查询用户
     *@Param: [openid]
     *@Return: com.pri.entity.WxUser
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 12:56
     */
    public WxUser selectByOpenid(String openid,String nid){
        return wxUserMapper.selectByOpenid(openid,nid);
    }

    /**
     *@MethodName:  insert
     *@Description: 插入微信用户
     *@Param: [record]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 12:55
     */
    public int insert(WxUser record){
        int re = wxUserMapper.insert(record);
        return re;
    }
    /**
     *@MethodName:  updateByPrimaryKey
     *@Description: 修改用户信息
     *@Param: [record]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/4/24 15:23
     */
    public int updateByPrimaryKey(WxUser record){
        return wxUserMapper.updateByPrimaryKey(record);
    }
}
