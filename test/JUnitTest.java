import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class JUnitTest{
    static Set<JUnitTest> testObjects = new HashSet<>();
    // JUnit이 매번 새로운 오브젝트를 만드는지 검정

    @Test
    public void test1() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);
    }

    @Test
    public void test2() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);
    }

    @Test
    public void test3() {
        assertThat(testObjects,not(hasItem(this)));
        testObjects.add(this);
    }
}
