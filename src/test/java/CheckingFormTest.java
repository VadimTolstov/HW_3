import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CheckingFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Антон Иванович");
        $("[id=lastName]").setValue("Ivanov");
        $("#userEmail").setValue("Ivanov@google.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("7878787878");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__year-select").selectOption("1988");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();


//        $("label[for=hobbies-checkbox-1]").click();
//        $("label[for=hobbies-checkbox-2]").click();
//        $("label[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("pictures/JAVA_20.6_10.jpg");
//      $("#uploadPicture").uploadFile(new File("src/test/resources/pictures/JAVA_20.6_10.jpg"));
//      File file = new File("src/test/resources/pictures/JAVA_20.6_10.jpg");
//      $("#uploadPicture").uploadFile(file);


        $("#currentAddress").setValue("Hello");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#submit").click();

//        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
//        $("table tbody tr:nth-child(1) td:nth-child(2)").shouldHave(exactText("Алексей Иванович Ivanov"));
//        $("table tbody tr:nth-child(2) td:nth-child(2)").shouldHave(exactText("Ivanov@google.com"));
//        $("table tbody tr:nth-child(3) td:nth-child(2)").shouldHave(exactText("Female"));

        $(".modal-dialog").should(appear);
        $(".modal-content").shouldHave(
                text("Thanks for submitting the form"),
                text("Антон Иванович Ivanov"),
                text("Ivanov@google.com"),
                text("Female"),
                text("7878787878"),
                text("30 April,1988"),
                text("Music, Reading, Sports"),
                text("JAVA_20.6_10.jpg"),
                text("Hello"),
                text("NCR Delhi")
        );
//        $(".modal-content").shouldHave(text("Алексей Иванович Ivanov"));
//        $(".modal-content").shouldHave(text("Ivanov@google.com"));
//        $(".modal-content").shouldHave(text("Female"));
//        $(".modal-content").shouldHave(text("7878787878"));
//        $(".modal-content").shouldHave(text("25 May,1988"));
//        $(".modal-content").shouldHave(text("Music, Reading, Sports"));
//        $(".modal-content").shouldHave(text("JAVA_20.6_10.jpg"));
//        $(".modal-content").shouldHave(text("Hello"));
//        $(".modal-content").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();

        // sleep(2000);


    }
}
