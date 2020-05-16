package features.filter;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(SerenityRunner.class)
public class FilterByPrice {
    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver webdriver;

    @Steps
    public steps.serenity.EndUserSteps anna;

    @Test
    public void enters_valid_price_interval_results_in_data_filtered() {
        anna.is_the_home_page();
        anna.looks_for("Huawei P30 Pro");
        anna.should_see_filter(2000,3000);

    }
    @Test
    public void enters_invalid_price_interval_results_in_data_not_filtered() {
        anna.is_the_home_page();
        anna.looks_for("Huawei P30 Pro");

            anna.should_not_see_filter(-100,0);



    }


}
