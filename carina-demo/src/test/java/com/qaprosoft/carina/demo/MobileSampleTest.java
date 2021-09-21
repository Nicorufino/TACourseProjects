package com.qaprosoft.carina.demo;

import com.zebrunner.agent.core.annotation.TestLabel;
import io.cucumber.java.bs.A;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.demo.utils.MobileContextUtils;
import com.qaprosoft.carina.demo.utils.MobileContextUtils.View;


public class MobileSampleTest implements IAbstractTest, IMobileUtils {
    private WelcomePageBase welcomePage;

    @BeforeClass
    public void openApp(){
        welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened());
    }

    @AfterMethod
    public void clear(){
        welcomePage.clear();
    }

    @Test()
    @MethodOwner(owner = "nrufino")
    public void sumTest() throws InterruptedException {

        Thread.sleep(3000);

        welcomePage.calcSum();
        Assert.assertEquals(welcomePage.getResult().getText(), "10", "value not equal");

    }

    @Test(dependsOnMethods = "sumTest")
    @MethodOwner(owner = "nrufino")
    public void logTest(){

        welcomePage.log();
        Assert.assertEquals(welcomePage.getResult().getText(), "2", "value not equal");

    }

    @Test(dependsOnMethods = "logTest")
    @MethodOwner(owner = "nrufino")
    public void percentageTest(){

        welcomePage.percentage();
        Assert.assertEquals(welcomePage.getResult().getText(), "7", "value not equal");

    }

}