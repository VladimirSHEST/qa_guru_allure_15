package ru.vladimir;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStep {
    @Description("открываем главную страницу ")
    public void openMainPage(){
        open("https://github.com/");
    }
    @Description("ищем репозиторий {repo} ")
    public void searchForRepository(String repo){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[name='query-builder-test']").sendKeys(repo);
        $("[name='query-builder-test']").submit();
    }
    @Step("Кликаем по ссылке репозитория ")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Открываем вкладку issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверка наличия issue с номером 87 ")
    public void shouldSeeIssuesWithNumber(){
        $(withText("#87")).should(Condition.exist);
    }

}
