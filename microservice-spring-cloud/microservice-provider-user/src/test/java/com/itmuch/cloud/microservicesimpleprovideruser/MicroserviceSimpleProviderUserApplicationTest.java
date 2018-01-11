package com.itmuch.cloud.microservicesimpleprovideruser;

import com.itmuch.cloud.microservicesimpleprovideruser.dao.UserDao;
import com.itmuch.cloud.microservicesimpleprovideruser.obj.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * 控制主体
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MicroserviceSimpleProviderUserApplicationTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MicroserviceSimpleProviderUserApplicationTest.class);
    @Autowired
    private UserDao userDao;

    @Test
    public void main() throws Exception {
        User user = userDao.findById(1);
        LOGGER.info("----------------:" + user + "------------------------");
    }

}