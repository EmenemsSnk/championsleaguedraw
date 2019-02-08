package com.emenemssnk.championsleaguedraw.group;

import com.emenemssnk.championsleaguedraw.team.Team;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;
import java.util.ArrayList;
import java.util.List;

public class Group   {
    public static final int KNOCKOUT_SIZE = 2;
    public static final int GROUP_STAGE_SIZE = 4;
    private static int index = 1;
    private final List<Team> teams;
    private final int number;

    public Group(int size) {
        this.number = index++;
        teams = new ArrayList<>(size);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean containsTeamOfNation(Nation nation) {
        return teams.stream().anyMatch(team -> team.getNation().equals(nation));
    }

    public boolean containsTeam(Team team){
        return teams.stream().anyMatch(t -> t.equals(team));
    }

    public int getNumber() {
        return number;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
