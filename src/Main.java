public class Main {
    public static void main(String[] args) {
        AttendanceLogger attendanceLogger = new AttendanceLogger();
        attendanceLogger.registVisit("user1", "09:15");
        attendanceLogger.registVisit("user2", "10:25");
        attendanceLogger.registVisit("user1", "11:45");
        attendanceLogger.registVisit("user3", "09:05");
        attendanceLogger.registVisit("user4", "09:30");
        attendanceLogger.registVisit("user3", "11:00");
        attendanceLogger.registVisit("user1", "09:25");
        attendanceLogger.registVisit("user2", "10:15");
        attendanceLogger.registVisit("user1", "08:15");
        attendanceLogger.registVisit("user4", "08:50");
        attendanceLogger.registVisit("user1", "12:15");
        attendanceLogger.registVisit("user3", "10:55");
        attendanceLogger.registVisit("user1", "11:45");
        attendanceLogger.registVisit("user3", "8:55");

        attendanceLogger.getMostPopularHour();
        attendanceLogger.getMaxHourStatistic();
    }

}
