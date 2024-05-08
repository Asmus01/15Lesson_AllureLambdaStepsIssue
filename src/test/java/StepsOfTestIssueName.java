import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StepsOfTestIssueName {

    @Step("Открываем страницу GitHub")
    public void openGithubPage() {
        open("https://github.com/Asmus01?tab=repositories");
    }
    @Step("Выбираем репозиторий")
    public void selectRepo() {
        $("#user-repositories-list").$(byText("RepeatingDemoqaTestWithFaker")).click();
    }

    @Step("Проверяем наименование Issue")
    public void testOfIssueName() {
        $("#issues-tab").click();
        $(".js-navigation-container").shouldHave(text("My first Issue"));
    }
}
