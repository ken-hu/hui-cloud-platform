package com.hui.cloud.uc;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <code>BaseJunitTest</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/9/21 0:21.
 *
 * @author Gary.Hu
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("junit")
@RunWith(SpringRunner.class)
public abstract class BaseJunitTest {
}
