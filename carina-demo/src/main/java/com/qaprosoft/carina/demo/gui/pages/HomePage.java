package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private final static Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "gh-ac")
    private ExtendedWebElement searchBar;

    @FindBy(id = "gh-btn")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//li[@id=\"gh-p-1\"]/a")
    private ExtendedWebElement dailyDealsButton;

    @FindBy(id = "gh-shop-a")
    private ExtendedWebElement categoriesButton;

    @FindBy(xpath = "//a[@_sp=\"m570.l3413\"]")
    private ExtendedWebElement technologyButton;

    public TechnologyPage openTechnology(){
        categoriesButton.click();
        technologyButton.click();
        return new TechnologyPage(driver);
    }

    public DealsPage openDeals(){
        dailyDealsButton.click();
        return new DealsPage(driver);
    }

    public ResultsPage search(String query){
        searchBar.type(query);
        searchButton.click();
        return new ResultsPage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ExtendedWebElement getSearchBar() {
        return searchBar;
    }

    public void setSearchBar(ExtendedWebElement searchBar) {
        this.searchBar = searchBar;
    }

    public ExtendedWebElement getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(ExtendedWebElement searchButton) {
        this.searchButton = searchButton;
    }

    public ExtendedWebElement getDailyDealsButton() {
        return dailyDealsButton;
    }

    public void setDailyDealsButton(ExtendedWebElement dailyDealsButton) {
        this.dailyDealsButton = dailyDealsButton;
    }

    public ExtendedWebElement getCategoriesButton() {
        return categoriesButton;
    }

    public void setCategoriesButton(ExtendedWebElement categoriesButton) {
        this.categoriesButton = categoriesButton;
    }

    public ExtendedWebElement getTechnologyButton() {
        return technologyButton;
    }

    public void setTechnologyButton(ExtendedWebElement technologyButton) {
        this.technologyButton = technologyButton;
    }
}
