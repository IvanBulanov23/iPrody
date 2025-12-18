import java.util.*;


public class Camp {
    private final List<Boyscout> scouts;

    public Camp(List<Boyscout> scouts) {
        this.scouts = scouts;
    }

    public Map<Team, List<Boyscout>> split() {
        Map<Team, List<Boyscout>> teams = new HashMap<>();

        for (Boyscout scout : scouts) {
            teams.computeIfAbsent(scout.getTeam(), k -> new ArrayList<>()).add(scout);
        }

        for (List<Boyscout> team : teams.values()) {
            team.sort(Comparator.comparingInt(Boyscout::getAge).reversed());
        }

        return teams;
    }

}

