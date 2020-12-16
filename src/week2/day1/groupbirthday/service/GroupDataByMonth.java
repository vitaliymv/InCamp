package week2.day1.groupbirthday.service;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GroupDataByMonth {
    private CollectDataService collectDataService = new CollectDataService();

    public void getGroupingEmployee() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Write month");
        int amount = sc.nextInt();


        for (int i = 0; i <= amount; i++) {
            LocalDate date = LocalDate.now().plusMonths(i);
            Month month = date.getMonth();
            System.out.println(month + " " + date.getYear());
            for (Map.Entry<LocalDate, String> entry : collectDataService.getEmployee().entrySet()) {
                LocalDate dateEmployee = entry.getKey();

                if (entry.getKey().getMonth().equals(date.getMonth())) {
                    String geString = String.format("(%d)  -  %s (%d)",
                            entry.getKey().getDayOfMonth(),
                            entry.getValue(),
                            calculateAge(dateEmployee, date));
                    System.out.println(geString);
                }
            }
        }

    }


//    Декабрь 2020
//    (20) - Ваня Иванов (23 года)
//    (23) - Петя Петров (25 лет)
//    Январь 2021
//    (01) - Коля Новогодний (21 год)
//    (07) - Стас Рождественский (30 лет)

    public int calculateAge(LocalDate dateEmployee, LocalDate currentDate) {
        return Period.between(dateEmployee, currentDate).getYears();
    }

}
