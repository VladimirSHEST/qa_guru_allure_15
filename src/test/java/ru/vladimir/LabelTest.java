package ru.vladimir;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelTest {
    @Test
    @Feature("Issue в репозитории ")   //  отражается в Behaviors
    @Story("Создание Issue ")    //  отражается в Behaviors
    @Owner("Вова")  // хозяин теста
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "GitHub", url = "https://testing.github.com")  //ссылка
    @DisplayName("Создание Issue для пользователя")// имя теста

    public void labelStaticTest() {

    }

    @Test  // тоже что и сверху только через методы
    public void dynamicLabelTest() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создание Issue для пользователя")
        );
        Allure.feature("Issue в репозитории ");
        Allure.story("Создание Issue ");
        Allure.label("Owner","Вова");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("GitHub","https://testing.github.com");
    }
}
