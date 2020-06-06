package com.example.campus.utils;

import com.example.campus.CampusApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuyy
 * @date 2020/6/6 21:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CampusApplication.class})
public class CreateTestDataTest {

    @org.junit.Test
    public void createDataOfProduct() {
        CreateTestData createTestData=new CreateTestData();
        createTestData.createDataOfProduct();
    }
}