package daoTest;

import com.web.onlineLibrary.OnlineLibraryApplication;
import com.web.onlineLibrary.service.ContentService;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes={OnlineLibraryApplication.class})
public class ServiceTest {

    @Autowired
    private ContentService contentService;

    @Test
    public void contentserviceTest() throws ParseException {
        contentService.getContentInfoList(1,2,null,null,null);
    }
}
