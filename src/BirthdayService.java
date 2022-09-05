import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Возьмем в пн какую-нибудь простую задачку:
// Например, с консоли вводится ДР в формате: "10.10.1992"
// Нужно считать Сканнером и вывести в консоль:
// "Вам 29 лет. ДР через 1 месяц и 5 дней"
//"7.08.1992"

public class BirthdayService{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String birthdayString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);
        LocalDate now = LocalDate.now();
        Period currentAge = Period.between(birthday, now);
        int age = currentAge.getYears();
        int day = birthday.getDayOfMonth();
        int month = birthday.getMonthValue();
        int year = now.getYear();
        LocalDate nextBirthday = LocalDate.of(year, month, day);
        if (nextBirthday.isBefore(now)){
            nextBirthday = nextBirthday.plusYears(1);
        }
        Period beforeBirthdayMonths = Period.between(now, nextBirthday);
        int monthsLeft = beforeBirthdayMonths.getMonths();
        LocalDate monthOfNextBirthday = now.plusMonths(monthsLeft);
        Period beforeBirthdayDays = Period.between(monthOfNextBirthday, nextBirthday);
        int daysLeft = beforeBirthdayDays.getDays();

        System.out.println("Вам " + age + " лет. ДР через " + monthsLeft + " месяц(ев) и " + daysLeft + " дней");
    }
}