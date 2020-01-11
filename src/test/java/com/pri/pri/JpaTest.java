package com.pri.pri;
import com.pri.dao.UserDao;
import com.pri.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;


@RunWith (SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private UserDao userDao;

    /**
     * methodName: testAddUser <BR>
     * description: 新增用户 <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-01-11 20:44 <BR>
     */
    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("zhangsan");
        user.setAge(12);
        userDao.save(user);

        User user2 = new User();
        user2.setName("lishi");
        user2.setAge(22);
        userDao.save(user2);
    }

    /**
     * methodName: testDelUser <BR>
     * description: 删除用户(根据对象删除时，必须要有ID属性) <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-01-11 20:44 <BR>
     */
    @Test
    public void testDelUser() throws Exception {
        User user = new User();
        user.setId(1L);
        user.setName("zhangsan");
        user.setAge(12);
        userDao.delete(user);
    }

    /**
     * methodName: testUpdUser <BR>
     * description: 修改用户信息 <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-01-11 20:44 <BR>
     */
    @Test
    public void testUpdUser() throws Exception {
        User user = new User();
        user.setId(2L);
        user.setName("zhangsan11");
        user.setAge(122);
        userDao.save(user);
    }

    /**
     * methodName: testQueryUser <BR>
     * description: 查询用户 <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-01-11 20:45 <BR>
     */
    @Test
    public void testQueryUser() throws Exception {
        User user = userDao.findByAge(22);
        System.out.println(user.getName());

        User user2 = userDao.findByNameAndAge("lishi", 22);
        System.out.println(user2.getName());

        try {
            User user3 = userDao.findUser("zhangsan11");
            if (user3 != null) {
                System.out.println(user3.getName());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        /**
         * description: SqlExceptionHelper   : Column 'addr' not found.
         * author: ChenQi <BR>
         * createDate: 2020-01-11 21:46  <BR>
         */
        try {
            List<User> list = userDao.findQuery ("lishi");
            for (User item : list) {
                System.out.println(item.toString ());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * methodName: testQueryUserList <BR>
     * description: 查询所有用户 <BR>
     * remark: <BR>
     * param:  <BR>
     * return: void <BR>
     * author: ChenQi <BR>
     * createDate: 2020-01-11 20:46 <BR>
     */
    @Test
    public void testQueryUserList() throws Exception {
        List<User> list = userDao.findAll();
        for (User user : list) {
        System.out.println(user.getName());
        }
    }
}