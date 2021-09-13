package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ResultsPage extends AbstractPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"srp-river-results\"]/ul/li/div")
    private List<ExtendedWebElement> results;

    public List<ExtendedWebElement> getResults() {
        return results;
    }

    public void setResults(List<ExtendedWebElement> results) {
        this.results = results;
    }

    public ResultsPage(WebDriver driver) {
        super(driver);
    }
}
