package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType.Type;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.time.Duration;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

@DeviceType(pageType = Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @FindBy(id = "formula")
    private ExtendedWebElement formula;

    @FindBy(id = "arrow")
    private ExtendedWebElement arrow;

    @FindBy(id = "fun_log")
    private ExtendedWebElement logButton;


    @FindBy(id = "digit_7")
    private ExtendedWebElement sevenButton;

    @FindBy(id = "digit_3")
    private ExtendedWebElement threeButton;

    @FindBy(id = "digit_1")
    private ExtendedWebElement oneButton;

    @FindBy(id = "digit_0")
    private ExtendedWebElement zeroButton;

    @FindBy(id = "op_add")
    private ExtendedWebElement plusButton;

    @FindBy(id = "eq")
    private ExtendedWebElement equalsButton;

    @FindBy(id = "op_pct")
    private ExtendedWebElement percentButton;


    @FindBy(id = "result_final")
    private ExtendedWebElement result;

    @FindBy(id = "clr")
    private ExtendedWebElement clearButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void calcSum() {
        threeButton.click();
        plusButton.click();
        sevenButton.click();
        equalsButton.click();
    }

    @Override
    public void clear(){
        clearButton.click();
    }

    @Override
    public boolean isPageOpened() {
        return formula.isElementPresent();
    }

    public ExtendedWebElement getResult() {
        return result;

    }

    @Override
    public void log() {
        logButton.click();
        oneButton.click();
        zeroButton.click();
        zeroButton.click();
        equalsButton.click();
    }

    @Override
    public void percentage(){
        oneButton.click();
        zeroButton.click();
        percentButton.click();
        sevenButton.click();
        zeroButton.click();
        equalsButton.click();
    }
}
