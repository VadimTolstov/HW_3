import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckingFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Алексей Иванович");
        $("[id=lastName]").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@google.com");
        $("[for=gender-radio-2]").click();
        $("#userNumber").setValue("7878787878");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("May")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1988")).click();
        $("[aria-label='Choose Wednesday, May 25th, 1988']").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-3").parent().click();

    }
}
