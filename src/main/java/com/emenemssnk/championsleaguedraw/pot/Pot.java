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

    public Team pullTeam(int index){
        Team team = teams.get(index);
        teams.remove(index);

        return team;
    }

    public int getCurrentSize(){
        return teams.size();
    }

    public List<Team> getTeams() {
        return teams;
    }
}
