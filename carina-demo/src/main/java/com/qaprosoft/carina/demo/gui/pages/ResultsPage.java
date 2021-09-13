package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsPage extends AbstractPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@class=\"s-item__title\"]")
    private List<ExtendedWebElement> results;

    public List<String> getResults() {
        return results.stream().map(r -> r.getText()).collect(Collectors.toList());
    }

    public void setResults(List<ExtendedWebElement> results) {
        this.results = results;
    }

    public ResultsPage(WebDriver driver) {
        super(driver);
    }
}
