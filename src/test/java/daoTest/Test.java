package daoTest;

import com.web.onlineLibrary.OnlineLibraryApplication;
import com.web.onlineLibrary.dao.UserMapper;
import com.web.onlineLibrary.domain.User;
import lombok.AllArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Dao单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={OnlineLibraryApplication.class})
public class Test {

    @Autowired
    private UserMapper userMapper;


    @org.junit.Test
    public void userTest(){
        int count=userMapper.queryUsernameCountById("1234567");
        System.out.println(count);
        User user=new User();
        user.setName("faf");
        user.setSalt("e");
        user.setUsername("12");
        user.setPassword("33");
        user.setUserRole(1);
        userMapper.insert(user);

        System.out.println(userMapper.querySaltByUsername("123"));
    }
}
