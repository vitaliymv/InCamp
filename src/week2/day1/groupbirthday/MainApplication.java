package week2.day1.groupbirthday;


import week2.day1.groupbirthday.service.GroupDataByMonthService;

public class MainApplication {

    public static void main(String[] args) {

        GroupDataByMonthService groupDataByMonthService = new GroupDataByMonthService();
        groupDataByMonthService.getGroupingEmployee();

    }

}
