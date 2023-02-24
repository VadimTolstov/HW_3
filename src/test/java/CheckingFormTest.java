import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckingFormTest {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
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

      //  $("#hobbies-checkbox-3").parent().click();
        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-2]").click();
        $("label[for=hobbies-checkbox-3]").click();

        File file = new File("src/test/resources/pictures/JAVA_20.6_10.jpg");
        $("#uploadPicture").uploadFile(file);

        $("#currentAddress").setValue("Hello");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();

        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(exactText("Алексей Иванович Ivanov"));
        $("table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(exactText("Ivanov@google.com"));
        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(exactText("Female"));

        $(".modal-content").shouldHave(text("7878787878"));
        $(".modal-content").shouldHave(text("25 May,1988"));
        $(".modal-content").shouldHave(text("Sports, Reading, Music"));
        $(".modal-content").shouldHave(text("JAVA_20.6_10.jpg"));
        $(".modal-content").shouldHave(text("Hello"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
        $("#closeLargeModal").click();

    }
}
