package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class DealsPage extends AbstractPage {

    @FindBy(id = "anchor")
    private ExtendedWebElement captcha;

    @FindBy(xpath = "//div[@class=\"ebayui-dne-summary-card card ebayui-dne-item-featured-card--topDeals\"]/div/div/a")
    private ExtendedWebElement featuredDeal;



    public ItemPage openFeatured(){
        featuredDeal.click();
        return new ItemPage(driver);
    }

    public boolean isPageOpened(){
        return (this.getTitle().contains("Daily Deals on eBay | Best deals and Free Shipping"));
    }

    public DealsPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCaptcha() {

        return captcha;
    }

    public void setCaptcha(ExtendedWebElement captcha) {
        this.captcha = captcha;
    }

    public ExtendedWebElement getFeaturedDeal() {
        return featuredDeal;
    }

    public void setFeaturedDeal(ExtendedWebElement featuredDeal) {
        this.featuredDeal = featuredDeal;
    }
}
