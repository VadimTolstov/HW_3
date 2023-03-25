import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

    @Test
    @Feature("Issue в репозитории")// похоже на название набор тестов
    @Story("Создание Issue") // списко в нутри наборов тестов
    @Owner("eroshenkoam") // отображает автора теста
    @Severity(SeverityLevel.BLOCKER)//отображается в отчете
    @Link(value = "Testing", url = "https://testing.Github.com") // позволяет прикладывать ссылку к тесту
    @DisplayName("Создания Issue для авторизованного пользователя") // название теста
    public void testStaticLabels() {

    }

    @Test //Подобное что и сверху
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Создания Issue для авторизованного пользователя")
        );
        Allure.feature("Issue в репозитории");
        Allure.story("Создание Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity",SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.Github.com");
    }

}
