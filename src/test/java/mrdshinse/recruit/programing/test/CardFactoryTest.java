package mrdshinse.recruit.programing.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author mrdShinse
 */
public class CardFactoryTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void whenInputNull_throwNulPointerException() {
        thrown.expect(NullPointerException.class);
        CardFactory.create(null);
    }
}
