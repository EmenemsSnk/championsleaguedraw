package com.emenemssnk.championsleaguedraw.draw.possibilities;

import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.emenemssnk.championsleaguedraw.team.Team;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DrawPossibilities {
     Map<Team, List<Group>> combinations = new HashMap<>();
     Pot pot;
     DrawResult drawResult;
     List<Team> teams2Draw;

    public DrawPossibilities(Pot pot, DrawResult drawResult){
        this.pot = pot;
        this.drawResult = drawResult;
        teams2Draw = pot.getTeams();
        teams2Draw.forEach(team -> combinations.put(team, new ArrayList<>()));
    }

    public void calculateAllPossibilities() {
        List<Team> teams = pot.getTeams();
        for (Team team: teams) {
            List<Group> possibleCombinations = getPossibleCombinations(team);
            List<Group> groups = drawResult.getGroups();

            possibleCombinations.addAll(groups);
        }
    }

    public int getNumberOfPossibleCombinations4Team(Team team){
        return combinations.get(team).size();
    }

    public void validatePossibilities4Team(Team team){
        Set groups2Extract = getGroups2Extract();
        List<Group> possibleGroups = getPossibleCombinations(team);

        possibleGroups.removeAll(groups2Extract);
    }

    List<Group> getPossibleCombinations(Team team) {
        return combinations.get(team);
    }

    private Set<Group> getGroups2Extract() {
        Set<Group> groups2Extract = new HashSet<>();

        teams2Draw.stream()
            .filter(team -> hasLimitedPossibilities(team) || isSingleCombination(team))
            .map(this::getPossibleCombinations)
            .forEach(groups2Extract::addAll);

        return groups2Extract;
    }

    private boolean hasLimitedPossibilities(Team team) {
        Nation nation = team.getNation();

        return getCountOfPossibleCombinations(team) == pot.getCountTeamsOfSameNation(nation);
    }

    private int getCountOfPossibleCombinations(Team team) {
        return getPossibleCombinations(team).size();
    }

    private boolean isSingleCombination(Team team) {
        List<Group> possibleGroups = combinations.get(team);
        return possibleGroups.size() == 1;
    }

    public Group pullGroup4Team(int groupIndex, Team team) {
        List<Group> possibleGroups = combinations.get(team);
        Group group = possibleGroups.get(groupIndex);
        removeAssignedGroup(group);

        return group;
    }

    private void removeAssignedGroup(Group group){
        combinations.entrySet().stream()
            .filter(t -> t.getValue().contains(group))
            .forEach(t -> t.getValue().remove(group));
    }

}
