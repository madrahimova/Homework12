import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import pro.sky.java.course1.homework12.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class Main {
    private static int getYearFromDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Faker faker = new Faker();
        Book book = null;

        for (int i = 0; i < 2; i++) {
            Name fakeName = faker.name();
            Author author = new Author(fakeName.firstName(), fakeName.lastName());
            book = new Book(faker.book().title(), author, getYearFromDate(faker.date().birthday()));
        }

        logger.info(book.toString());
        book.setYear(book.getYear() + 1);
        logger.info(book.toString());
    }
}