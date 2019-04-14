package com.linxu.pillow;

import com.linxu.pillow.utils.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PillowApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void testUtil(){
        System.err.println(DateUtil.addDay("2019-03-31"));
    }

}
