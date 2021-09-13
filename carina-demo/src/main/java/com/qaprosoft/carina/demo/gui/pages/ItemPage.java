package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(xpath = "//div[@class=\"u-flL\"]/a")
    private ExtendedWebElement buyButton;

    public ExtendedWebElement getBuyButton() {
        return buyButton;
    }

    public void setBuyButton(ExtendedWebElement buyButton) {
        this.buyButton = buyButton;
    }

    public ItemPage(WebDriver driver) {
        super(driver);
    }
}
