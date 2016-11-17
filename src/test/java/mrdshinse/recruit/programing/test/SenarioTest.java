package mrdshinse.recruit.programing.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mrdShinse
 */
public class SenarioTest {

    /**
     * 標準出力を読み取るストリーム
     */
    private ByteArrayOutputStream outContent;

    /**
     * 標準出力を読み取るストリームを解放する。
     */
    @After
    public void after() {
        System.setOut(null);
    }

    /**
     * 標準出力を読み取るストリームを生成する。
     */
    @Before
    public void before() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void A1_B4_C5isA_MIN() {
        String[] args = new String[]{"A=1", "B=4", "C=5"};
        new IndianPorkerManager(args).startGame();
        assertThat(outContent.toString(), is("A =>MIN"));
    }

    @Test
    public void A1_B2_C4isB_MID() {
        String[] args = new String[]{"A=1", "B=2", "C=4"};
        new IndianPorkerManager(args).startGame();
        assertThat(outContent.toString(), is("A =>?,B =>MID"));
    }

}
