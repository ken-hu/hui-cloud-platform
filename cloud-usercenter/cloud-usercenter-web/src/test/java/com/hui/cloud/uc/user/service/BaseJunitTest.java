package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.UcTestApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <code>BaseJunitTest</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/21 0:21.
 *
 * @author Gary.Hu
 */
@SpringBootTest(classes = {UcTestApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseJunitTest {
}
