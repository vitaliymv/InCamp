package week2.day1.groupbirthday.service;

import week2.day1.groupbirthday.model.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;

public class CollectDataService {
    private Employee ivan = new Employee();
    private Employee petr = new Employee();
    private Employee stas = new Employee();
    private Employee nikola = new Employee();

    private HashMap<LocalDate, String> employees = new HashMap<>();

    public HashMap<LocalDate, String> getEmployee() {

        LocalDate date = LocalDate.of(2001, 3, 4);
        ivan.setFullName("Ваня Іванов");
        ivan.setBirthday(date);

        LocalDate date1 = LocalDate.of(1998, 3, 10);
        petr.setFullName("Петя Петров");
        petr.setBirthday(date1);

        LocalDate date2 = LocalDate.of(1997, 2, 13);
        stas.setFullName("Стас Рождественский");
        stas.setBirthday(date2);

        LocalDate date3 = LocalDate.of(2000, 2, 15);
        nikola.setFullName("Коля Новогодний");
        nikola.setBirthday(date3);

        employees.put(ivan.getBirthday(), ivan.getFullName());
        employees.put(petr.getBirthday(), petr.getFullName());
        employees.put(stas.getBirthday(), stas.getFullName());
        employees.put(nikola.getBirthday(), nikola.getFullName());

        return employees;

    }

}
