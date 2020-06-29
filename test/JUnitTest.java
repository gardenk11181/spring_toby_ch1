import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/springboot/ch1/junit.xml")
public class JUnitTest{
    @Autowired
    ApplicationContext context;
    static ApplicationContext contextObject = null;
    // Spring Context가 하나만 생성되는지 검정

    static Set<JUnitTest> testObjects = new HashSet<>();
    // JUnit이 매번 새로운 오브젝트를 만드는지 검정

    @Test
    public void test1() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertThat(contextObject==null || contextObject == this.context,is(true));
        contextObject = this.context;
    }

    @Test
    public void test2() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertThat(contextObject==null || contextObject == this.context,is(true));
        contextObject = this.context;
    }

    @Test
    public void test3() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);

        assertThat(contextObject==null || contextObject == this.context,is(true));
        contextObject = this.context;
    }
}
