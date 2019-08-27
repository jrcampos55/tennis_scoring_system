package test.com.jrcampos.tennis;

import com.jrcampos.tennis.MatchSet;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        MatchTest.class,
        MatchSetTest.class,
        GameTest.class,
        TiebreakGameTest.class
})
public class JunitTestSuite {
}
