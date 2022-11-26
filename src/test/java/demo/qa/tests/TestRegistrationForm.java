package demo.qa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestRegistrationForm extends TestBase {

    @Test

    void simpleTest(){

        String BaseUrl = "/automation-practice-form"; //создали переменную для страницы которую будем тестирвоать
        open(BaseUrl); //открываем станицу которую будем тестировать через переменную

        $("#firstName").setValue("Орлов"); //Заполянем Имя
        $("#lastName").setValue("Алексей"); //Заполянем Фамилию
        $("#userEmail").setValue("aorlov@site.com"); //Заполянем емейл
        $("#gender-radio-1").doubleClick(); //Кликаем на пол
        $("#userNumber").setValue("9777742959"); //заполняем моб

        $("#dateOfBirthInput").click(); //кликаем на поле чтобы открыть календарь
        $(".react-datepicker__month-select").selectOption("July"); //Выбираем месяц через selectOption
        $(".react-datepicker__year-select").selectOption("1997"); //Выбираем год через selectOption
        $(".react-datepicker__day--020").click(); //Выбираем дату

        $("#subjectsInput").setValue("Hindi").pressEnter(); // выбираем навык
        $("#hobbiesWrapper").$(byText("Music")).click(); //выбираем увлечение
        $("#currentAddress").setValue("Moskva, Krasnopresnenskaya nab., 12-17"); //заполняем адресс

        File file = new File("src/test/java/demo/qa/resources/CKtO-Q6I1ks.jpeg");//создаем переменную для файла
        $("#uploadPicture").uploadFile(file);//загружаем файл

        $("#react-select-3-input").setValue("NCR").pressEnter(); //выбираем штат
        $("#react-select-4-input").setValue("Noida").pressEnter(); //выбираем город

        executeJavaScript("$('#fixedban').remove()"); //убираем футер
        executeJavaScript("$('footer').remove()");

        $("#submit").click(); //Кликаем на подтвержение формы

        //Проверяем поля
        $(".table-responsive").shouldHave(text("Орлов"));
        $(".table-responsive").shouldHave(text("Алексей"));
        $(".table-responsive").shouldHave(text("aorlov@site.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("9777742959"));
        $(".table-responsive").shouldHave(text("Hindi"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("20 July,1997"));
        $(".table-responsive").shouldHave(text("CKtO-Q6I1ks.jpeg"));
        $(".table-responsive").shouldHave(text("Moskva, Krasnopresnenskaya nab., 12-17"));
        $(".table-responsive").shouldHave(text("NCR Noida"));
    }
}
