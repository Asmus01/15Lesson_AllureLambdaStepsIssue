import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;

public class TestIssueRepository {

    @BeforeAll
    static void setUp() {

        Configuration.browser = "firefox";
        Configuration.browserSize = "1100x1080";

    }

    @Test
    @DisplayName("Тест на проверку задачи с использованием Listener")
    @Story("Проверка названия задачи на github")
    void testGithubPageWithListener() {
        addListener("allure", new AllureSelenide());
        open("https://github.com/Asmus01?tab=repositories");
        $("#user-repositories-list").$(byText("RepeatingDemoqaTestWithFaker")).click();
        $("#issues-tab").click();
        $(".js-navigation-container").shouldHave(text("My first Issue"));

    }

    @Test
    @Story("Проверка названия задачи на github")
    @DisplayName("Тест на проверку задачи с использованием Lambda")
    void testGithubPageWithLambda() {
        addListener("allure", new AllureSelenide());
        step("Открываем страницу репозитория", () -> {
            open("https://github.com/Asmus01?tab=repositories");
        });

        step("Выбираем репозиторий", () -> {
            $("#user-repositories-list").$(byText("RepeatingDemoqaTestWithFaker")).click();
        });

        step("Проверяем наименование Issue ", () -> {
            $("#issues-tab").click();
            $(".js-navigation-container").shouldHave(text("My first Issue"));
        });

    }

    @Test
    @Story("Проверка названия задачи на github")
    @DisplayName("Тест на проверку задачи с использованием Steps")
    public void testGithubPageWithSteps() {

        addListener("allure", new AllureSelenide());
        StepsOfTestIssueName steps = new StepsOfTestIssueName();

        steps.openGithubPage();
        steps.selectRepo();
        steps.testOfIssueName();
    }

}
