package com.emenemssnk.championsleaguedraw.model;

import com.emenemssnk.championsleaguedraw.model.Team.Nation;
import java.util.ArrayList;
import java.util.List;

public class Group   {
    private static int index = 1;
    private final List<Team> teams = new ArrayList<>(4);
    private final int number;

    public Group() {
        this.number = index++;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean containsTeamOfNation(Nation nation) {
        return teams.stream().anyMatch(team -> team.getNation().equals(nation));
    }

    public int getNumber() {
        return number;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
