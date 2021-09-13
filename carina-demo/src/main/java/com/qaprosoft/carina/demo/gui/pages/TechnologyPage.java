package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TechnologyPage extends AbstractPage {

    @FindBy(className = "b-pageheader__text")
    private ExtendedWebElement categoryTitle;


    public TechnologyPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getCategoryTitle() {
        return categoryTitle;
    }
}
