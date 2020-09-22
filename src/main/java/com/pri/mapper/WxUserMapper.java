package com.pri.mapper;

import com.pri.entity.TestUser;
import com.pri.entity.WxUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    /**ChenQi 2019/5/7; 根据主键查询*/
    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);

    List<WxUser> findUserList();

    List<WxUser> userList();

    /**ChenQi 2019/5/5; 根据openid查询用户*/
    WxUser selectByOpenid(@Param("openid") String openid,@Param("nid") String nid);

    /**ChenQi 2019/5/6; 根据条件查询用户集合*/
    List<WxUser> selectUserListByCondition(WxUser wxUser);

    /**ChenQi 2019/5/7; 根据主键进行逻辑删除*/
    int deleteLoginById(Integer id);

    /** 根据主键进行逻辑删除——注解版 ChenQi*/
    @Update("update wx_user set state = 0 where id = #{id}")
    public void deleteLoginById_2(Integer id);

    /**ChenQi 2019/5/7; 禁用、解禁 type:-1.禁用1.正常*/
    int lock(@Param( "id" ) Integer id,@Param( "type" ) Integer type);

    //测试批量插入 ChenQi;
    int insertUserList(@Param("testUsers") List<TestUser> testUsers);

    //测试批量删除 ChenQi;
    int delUserList(@Param("testUsers") List<TestUser> testUsers);

    //批量插入数据，数据存在时更新，不存在时插入 ChenQi;
    int testAddUserListOrUpdate(@Param("testUsers") List<TestUser> testUsers);

    //批量插入数据，数据存在时忽略，不存在时插入 ChenQi;
    int testAddUserListOrIgnore(@Param("testUsers") List<TestUser> testUsers);
}