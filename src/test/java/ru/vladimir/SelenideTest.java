package ru.vladimir;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class SelenideTest {

    @Owner("Владимир Ш.")
    @Description("открыть github")
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $(withText("#87")).should(Condition.exist);
//        $("[data-target='qbsearch-input.inputButtonText']").click();
//        $("[name='query-builder-test']").sendKeys("eroshenkoam/allure-example");
//        $("[name='query-builder-test']").submit();
//        $(linkText("eroshenkoam/allure-example")).click();  // поиск по ссылке и клик по ней
//        $("#issues-tab").click();
//        $(withText("#87")).should(Condition.exist);   // проверка по тексту
    }
    @Owner("Владимир Ш.")
    @Description("открыть google")
    @Test
    public void testGoogle() {
        Configuration.holdBrowserOpen = true;
        open("https://google.com/");
        System.out.println("Привет Hello");
    }
}
