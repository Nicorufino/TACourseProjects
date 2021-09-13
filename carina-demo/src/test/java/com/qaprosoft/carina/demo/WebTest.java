package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.apache.commons.text.RandomStringGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class WebTest extends AbstractTest {
   private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
   private String query;
    @Test
    @MethodOwner(owner = "nrufino")
    public void searchTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        query = "iphone";
        ResultsPage resultsPage = homePage.search(query);
        Assert.assertTrue(resultsPage.isPageOpened());

        resultsPage.getResults().stream().forEach(result -> Assert.assertTrue(result.getText().contains("iphone")));

    }

    @Test
    @MethodOwner(owner = "nrufino")
    public void openDealsTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        DealsPage dealsPage = homePage.openDeals();
        Assert.assertTrue(dealsPage.isPageOpened());
    }

    @Test
    @MethodOwner(owner = "nrufino")
    public void featuredItemTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        DealsPage dealsPage = homePage.openDeals();
        ItemPage itemPage = dealsPage.openFeatured();
        Assert.assertTrue(itemPage.getBuyButton().isElementPresent());
    }

    @Test
    @MethodOwner(owner = "nrufino")
    public void categoriesMenuTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        Assert.assertFalse(homePage.getTechnologyButton().getElement().isDisplayed());
        homePage.getCategoriesButton().click();
        Assert.assertTrue(homePage.getTechnologyButton().getElement().isDisplayed());
    }

    @Test
    @MethodOwner(owner = "nrufino")
    public void technologyPageTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        TechnologyPage technologyPage = homePage.openTechnology();
        Assert.assertTrue(technologyPage.getCategoryTitle().getText().contains("Tecnología"));
    }
}
