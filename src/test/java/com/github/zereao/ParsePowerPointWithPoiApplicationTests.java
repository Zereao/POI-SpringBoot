package com.github.zereao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParsePowerPointWithPoiApplicationTests {

    @Test
    public void contextLoads() {
        String[] a = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        System.out.println(a);
        System.out.println();
        Collections.reverse(Arrays.asList(a));
        System.out.println(a);
    }

}
