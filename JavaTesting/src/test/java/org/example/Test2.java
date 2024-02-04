package org.example;

import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class Test2 {

    @Issue("issue_link")
    @Test
    public void test2() {
        Assert.assertTrue(false);
    }

    @Feature("Login")
    @Story("Valid login")
    @Test
    public void test3() {
        throw new SkipException("test skipped message");
    }

    @Test
    public void test4() {
        Assert.assertTrue(true);
    }
}
