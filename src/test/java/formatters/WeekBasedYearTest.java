package formatters;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeekBasedYearTest {

    @Test
    @DisplayName("Locale.PL uses WeekFields.ISO")
    public void localePlUsesWeekFieldsIso() {
        DateTimeFormatter formatterPl = DateTimeFormatter.ofPattern("YYYY-MM-dd ww", Locale.forLanguageTag("pl-PL"));
        assertEquals(LocalDate.of(2021, 12, 25).format(formatterPl), "2021-12-25 51");
        assertEquals(LocalDate.of(2021, 12, 26).format(formatterPl), "2021-12-26 51");
        assertEquals(LocalDate.of(2021, 12, 27).format(formatterPl), "2021-12-27 52");
        assertEquals(LocalDate.of(2021, 12, 28).format(formatterPl), "2021-12-28 52");
        assertEquals(LocalDate.of(2021, 12, 29).format(formatterPl), "2021-12-29 52");
        assertEquals(LocalDate.of(2021, 12, 30).format(formatterPl), "2021-12-30 52");
        assertEquals(LocalDate.of(2021, 12, 31).format(formatterPl), "2021-12-31 52");
        assertEquals(LocalDate.of(2022, 1, 1).format(formatterPl), "2021-01-01 52");
        assertEquals(LocalDate.of(2022, 1, 2).format(formatterPl), "2021-01-02 52");
        assertEquals(LocalDate.of(2022, 1, 3).format(formatterPl), "2022-01-03 01");
    }

    @Test
    @DisplayName("Locale.US uses WeekFields.SUNDAY_START")
    public void localeUsUsesWeekFieldsSundayStart() {
        DateTimeFormatter formatterUs = DateTimeFormatter.ofPattern("YYYY-MM-dd ww", Locale.US);
        assertEquals(LocalDate.of(2021, 12, 25).format(formatterUs), "2021-12-25 52");
        assertEquals(LocalDate.of(2021, 12, 26).format(formatterUs), "2022-12-26 01");
        assertEquals(LocalDate.of(2021, 12, 27).format(formatterUs), "2022-12-27 01");
        assertEquals(LocalDate.of(2021, 12, 28).format(formatterUs), "2022-12-28 01");
        assertEquals(LocalDate.of(2021, 12, 29).format(formatterUs), "2022-12-29 01");
        assertEquals(LocalDate.of(2021, 12, 30).format(formatterUs), "2022-12-30 01");
        assertEquals(LocalDate.of(2021, 12, 31).format(formatterUs), "2022-12-31 01");
        assertEquals(LocalDate.of(2022, 1, 1).format(formatterUs), "2022-01-01 01");
        assertEquals(LocalDate.of(2022, 1, 2).format(formatterUs), "2022-01-02 02");
        assertEquals(LocalDate.of(2022, 1, 3).format(formatterUs), "2022-01-03 02");
    }
}
