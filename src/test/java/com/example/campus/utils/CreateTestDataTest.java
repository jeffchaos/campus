package com.example.campus.utils;

import com.example.campus.CampusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yuyy
 * @date 2020/6/6 21:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {CampusApplication.class})
public class CreateTestDataTest {

    @Autowired
    private CreateTestData createTestData;

    @org.junit.Test
    public void createDataOfProduct() {
        createTestData.createDataOfProduct();
    }

    @Test
    public void createDataOfPost() {
        createTestData.createDataOfPost();
    }
}