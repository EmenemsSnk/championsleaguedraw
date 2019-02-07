package com.emenemssnk.championsleaguedraw.pot;

import com.emenemssnk.championsleaguedraw.team.Team;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;
import java.util.List;

public class Pot {
    private final int number;
    private final List<Team> teams;

    public Pot(int number, List<Team> teams) {
        this.number = number;
        this.teams = teams;
    }

    public int getCountTeamsOfSameNation(Nation nation) {
        return (int) teams.stream().filter(team -> team.getNation().equals(nation)).count();
    }

    public boolean isEmpty() {
        return teams.isEmpty();
    }

    public List<Team> getTeams() {
        return teams;
    }
}
