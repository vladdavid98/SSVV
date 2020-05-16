package features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;

import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/EmagTestData.csv")
public class SearchByKeywordStory {

    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver webdriver;

    public Pages pages;
    public String name;
    public String definition;

    @Qualifier
    public String getQualifier(){
        return name;
    }

    @Steps
    public EndUserSteps anna;

    @Test
    public void search_by_valid_keyword_should_return_results() {
        anna.is_the_home_page();
        anna.looks_for(getName());
        anna.should_see_definition(getDefinition());

    }

    public String getName(){
        return name;
    }

    public String getDefinition(){
        return definition;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDefinition(String definition){
        this.definition = definition;
    }


} 