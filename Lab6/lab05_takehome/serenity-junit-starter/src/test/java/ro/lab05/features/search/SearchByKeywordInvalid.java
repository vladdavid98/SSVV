package features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.serenity.EndUserSteps;

@RunWith(SerenityRunner.class)

public class SearchByKeywordInvalid {

    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver webdriver;

    @Steps
    public EndUserSteps anna;

    @Test
    public void search_by_invalid_keyword_should_return_error() {
        anna.is_the_home_page();
        anna.looks_for("invalid search term");
        anna.should_see_error("0 rezultate");
    }

} 