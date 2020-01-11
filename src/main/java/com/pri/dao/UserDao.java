package com.pri.dao;
import com.pri.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * className: UserDao <BR>
 * description: <BR>
 * remark: <BR>
 * auther: ChenQi <BR>
 * date: 2020/1/11 19:47 <BR>
 * version 1.0 jdk1.8 <BR>
 */
public interface UserDao extends JpaRepository<User,Long>{
    /** 根据年纪查询用户 ChenQi*/
    User findByAge(Integer age);

    /** 根据年纪和姓名查询 ChenQi*/
    User findByNameAndAge(String name, Integer age);
    /**
     * description: 对于复杂查询可以使用@Query 编写sql
     * author: ChenQi <BR>
     * createDate: 2020-01-11 19:49  <BR>
     */
    // @Query("from User u where u.name= ?1")
    @Query("from User u where u.name= :name")
    User findUser(@Param("name") String name);

    /**
     * description: 报错：SqlExceptionHelper   : Column 'addr' not found.
     * author: ChenQi <BR>
     * createDate: 2020-01-11 21:45  <BR>
     */
    @Query(value = "select id,name,age from t_user  where name= :name",nativeQuery = true)
    List<User> findQuery(@Param("name") String name);
}
