package com.pri.service;

import com.pri.mapper.WxUserMapper;
import com.pri.entity.TestUser;
import com.pri.entity.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: WxUserService
 * @Description:
 * @Auther: Chenqi
 * @Date: 2019/4/23 20:23
 * @Version 1.0 jdk1.8
 */
@Service
public class UserService {

    @Autowired
    private WxUserMapper wxUserMapper;


    public List<WxUser> userList(){
        return wxUserMapper.userList();
    }

    /**
     *@MethodName:  selectByPrimaryKey
     *@Description: 根据主键查询
     *@Param: [id]
     *@Return: com.pri.entity.WxUser
     *@author: ChenQi
     *@CreateDate: 2019/5/7 14:14
     */
    public WxUser selectByPrimaryKey(Integer id){
        return wxUserMapper.selectByPrimaryKey(id);
    }

    public List<WxUser> selectUserListByCondition(WxUser wxUser){
        return wxUserMapper.selectUserListByCondition(wxUser);
    }

    /**
     *@MethodName:  deleteLoginById
     *@Description: 根据主键进行逻辑删除
     *@Param: [id]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/5/7 13:28
     */
    public int deleteLoginById(Integer id){
        return wxUserMapper.deleteLoginById( id );
    }

    /**
     *@MethodName:  lock
     *@Description: 禁用、解禁
     *@Param: [id, type -1.禁用1.正常]
     *@Return: int
     *@author: ChenQi
     *@CreateDate: 2019/5/7 17:59
     */
    public int lock(Integer id, Integer type){
        return wxUserMapper.lock( id,type );
    }

    /**
     *@MethodName:  testAddUserList
     *@Description: 测试批量插入
     *@Param: [testUsers]
     *@Return: int
     *@Author: ChenQi
     *@CreateDate: 2019/7/14 0014 下午 10:11
     */
    public int testAddUserList(List<TestUser> testUsers){
        return wxUserMapper.insertUserList(testUsers);
    }

    //测试批量删除 ChenQi;
    public int testDelUserList(List<TestUser> testUsers){
        return wxUserMapper.delUserList(testUsers);
    }
    //批量插入数据，数据存在时更新，不存在时插入 ChenQi;
    public int testAddUserListOrUpdate(List<TestUser> testUsers){
        return wxUserMapper.testAddUserListOrUpdate(testUsers);
    }

    //批量插入数据，数据存在时忽略，不存在时插入 ChenQi;
    public int testAddUserListOrIgnore(List<TestUser> testUsers){
        return wxUserMapper.testAddUserListOrIgnore(testUsers);
    }

}
