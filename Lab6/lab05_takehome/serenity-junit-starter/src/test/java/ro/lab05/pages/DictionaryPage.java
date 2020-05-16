package pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

@DefaultUrl("https://www.emag.ro/")
public class DictionaryPage extends PageObject {

    @FindBy(name="query")
    private WebElementFacade searchTerms;

    @FindBy(className = "searchbox-submit-button")
    private WebElementFacade lookupButton;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.id("card_grid"));
        List<WebElement> results = definitionList.findElements(By.className("card-section-mid"));
        return convert(results, toStrings());
    }
    public List<String> filterByPrice(int startPrice, int endPrice){
        // class filter-item
        WebElementFacade facade = find(By.cssSelector(".filter[data-name='Pret']"));

        WebElement startPriceInput = facade.findElement(By.className("js-custom-price-min"));
        typeInto(startPriceInput,Integer.toString(startPrice));
        WebElement endPriceInput = facade.findElement(By.className("js-custom-price-max"));
        typeInto(endPriceInput,Integer.toString(endPrice));
        facade.findElement(By.className("js-custom-price-trigger")).click();
        waitABit(5000);
        return convert(find(By.className("js-head-active-filters")).findElements(By.className("ph-label")),toStrings());
    }

    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
}