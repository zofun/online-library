package daoTest;

import com.web.onlineLibrary.OnlineLibraryApplication;
import com.web.onlineLibrary.dao.ContentMapper;
import com.web.onlineLibrary.dao.UserMapper;
import com.web.onlineLibrary.domain.Content;
import com.web.onlineLibrary.domain.ContentDetail;
import com.web.onlineLibrary.domain.ContentInfo;
import com.web.onlineLibrary.domain.User;
import com.web.onlineLibrary.utils.DateUtils;
import lombok.AllArgsConstructor;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Dao单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes={OnlineLibraryApplication.class})
public class Test {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ContentMapper contentMapper;

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

    @org.junit.Test
    public void contentTest(){
        Content content=new Content();
        content.setRecommend("yes");
        content.setAuthor(1);
        System.out.println(contentMapper.insert(content));

    }


    @org.junit.Test
    public void contentQueryTest() throws UnsupportedEncodingException {
        List<ContentInfo> list = contentMapper.query(null, null, new Date());

        for(ContentInfo info:list){
            System.out.println(info.toString());
        }

        ContentDetail detail = contentMapper.queryContentDetailById(4);

        System.out.println(detail.toString());

    }

    @org.junit.Test
    public void utilsTest() throws ParseException {
        String str="2019-08-22";
        Date date = DateUtils.toDate(str);
        System.out.println(date.toString());
    }
}
