package ru.vladimir;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    @Test
    public void testLambdaStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        step("открываем главную страницу ", () -> {
            open("https://github.com/");
        });
        // тоже самое без лямбды
//        step("открываем главную страницу ", new Allure.ThrowableRunnableVoid() {
//            @Override
//            public void run() throws Throwable {
//                open("https://github.com/");
//            }
//        });
//        $(withText("#87")).should(Condition.exist);
        step("ищем репозиторий " + REPOSITORY, () ->{
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("[name='query-builder-test']").sendKeys(REPOSITORY);
            $("[name='query-builder-test']").submit();
        });
        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем вкладку issues ", () -> {
            $("#issues-tab").click();
        });
        step("Проверка наличия issue с номером 87 ", () -> {
            $(withText("#87")).should(Condition.exist);
        });
    }

    @Test
    public void annotatedStep(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;

        WebStep webStep = new WebStep();

        webStep.openMainPage();
        webStep.searchForRepository(REPOSITORY);
        webStep.clickOnRepositoryLink(REPOSITORY);
        webStep.openIssuesTab();
        webStep.shouldSeeIssuesWithNumber();
    }
}
