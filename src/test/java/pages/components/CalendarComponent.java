package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class CalendarComponent {
    public void setDate(int day, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        if (day >= 10)
            $(".react-datepicker__day--0" + day + ":not(react-datepicker__day--outside-month").click();

        if (day < 10)
            $(".react-datepicker__day--00" + day + ":not(react-datepicker__day--outside-month").click();
    }
}

