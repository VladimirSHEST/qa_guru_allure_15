package ru.vladimir;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    public void testIssueSearch(){
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("[name='query-builder-test']").sendKeys("eroshenkoam/allure-example");
        $("[name='query-builder-test']").submit();
        $(linkText("eroshenkoam/allure-example")).click();  // поиск по ссылке и клик по ней
        $("#issues-tab").click();
        $(withText("#87")).should(Condition.exist);   // проверка по тексту
    }
}
