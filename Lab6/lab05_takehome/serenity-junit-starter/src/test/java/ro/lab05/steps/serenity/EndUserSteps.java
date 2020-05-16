package steps.serenity;

import pages.ErrorPage;
import pages.DictionaryPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import sun.security.util.ArrayUtil;

import java.text.DecimalFormat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.core.IsNot.not;


public class EndUserSteps extends ScenarioSteps {

    DictionaryPage dictionaryPage;
    ErrorPage errorPage;
    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
    }
    @Step
    public void should_see_error(String error){
        assertThat(errorPage.getErrors(), hasItem(containsString(error)));
    }
    @Step
    public void should_see_filter(int startPrice, int endPrice){
        List<String> stringList = dictionaryPage.filterByPrice(startPrice,endPrice);
        stringList.forEach(item -> System.out.println("FOUND: " + item + " #####################################################################"));
        DecimalFormat df = new DecimalFormat("###,###,##0");
        assertThat(stringList,hasItem(containsString(df.format(startPrice).replace(',','.') + " - " + df.format(endPrice).replace(',','.'))));
    }
    @Step
    public void should_not_see_filter(int startPrice, int endPrice){
        List<String> stringList = dictionaryPage.filterByPrice(startPrice,endPrice);
        stringList.forEach(item -> System.out.println("FOUND: " + item + " #####################################################################"));
        DecimalFormat df = new DecimalFormat("###,###,##0");
        assertThat(stringList, not(hasItem(containsString(df.format(startPrice).replace(',','.') + " - " + df.format(endPrice).replace(',','.')))));
    }
    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}