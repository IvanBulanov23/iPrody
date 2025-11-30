import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceLogger {
    private Map<String, List<String>> hoursOfVisiting = new HashMap<>();
    private Map<String, List<String>> peopleVisit = new HashMap<>();
    private String maxHour = null;
    private int maxHourVisits = 0;

    public void registVisit(String name, String time) {
        if (name.isEmpty() || time.isEmpty()) {
            throw new IllegalArgumentException("Введены не верные данные");
        }
        String hours = time.split(":")[0];

        if (!hoursOfVisiting.containsKey(hours)) {
            hoursOfVisiting.put(hours, new ArrayList<>());
        }

        var listOfHours = hoursOfVisiting.get(hours);
        listOfHours.add(time);

        if (maxHour == null || maxHourVisits < listOfHours.size()) {
            maxHour = hours;
            maxHourVisits = listOfHours.size();
        }

        if (!peopleVisit.containsKey(name))
            peopleVisit.put(name, new ArrayList<>());
        peopleVisit.get(name).add(time);

    }

    public void getMostPopularHour() {
        for (var entry : peopleVisit.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }
    }

    public void getMaxHourStatistic() {
        if (maxHour == null) {
            System.out.println("Hour is empty");
            return;
        }
        System.out.println(maxHour + ":00 " + "(" + hoursOfVisiting.get(maxHour).size() + " посещений/я: " + hoursOfVisiting.get(maxHour) + ")");
    }
}
