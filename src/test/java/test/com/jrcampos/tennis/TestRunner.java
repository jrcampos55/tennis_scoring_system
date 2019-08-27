package test.com.jrcampos.tennis;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(JunitTestSuite.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("\\\\ (•◡•) //  TestSuite runs successfully. \\\\ (•◡•) //");
        } else {
            System.out.println("( ˘︹˘ ) There was an issue running the TestSuite. ( ˘︹˘ )");
        }
    }
}
