package com.qaprosoft.carina.demo.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WelcomePageBase extends AbstractPage  {

    public WelcomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void calcSum();

    public abstract void clear();

    public abstract ExtendedWebElement getResult();

    public abstract void log();

    public abstract void percentage();


}
