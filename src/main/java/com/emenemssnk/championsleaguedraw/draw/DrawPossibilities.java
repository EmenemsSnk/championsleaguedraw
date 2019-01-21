package com.emenemssnk.championsleaguedraw.draw;

import com.emenemssnk.championsleaguedraw.common.rules.RussiaUkraineRule;
import com.emenemssnk.championsleaguedraw.common.rules.SameCountryRule;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DrawPossibilities {
    private Map<Team, List<Group>> combinations = new HashMap<>();
    private Pot pot;
    DrawResult drawResult;

    public DrawPossibilities(Pot pot, DrawResult drawResult){
        this.pot = pot;
        this.drawResult = drawResult;
        pot.getTeams().forEach(team -> combinations.put(team, new ArrayList<>()));
    }

    public void calculateAllPossibilities() {
        List<Team> teams = pot.getTeams();
        for (Team team: teams) {
            List<Group> possibleCombinations = getPossibleCombinations(team);
            List<Group> groups = drawResult.getGroups();

            groups.stream()
                .filter(group -> SameCountryRule.isPreserved(team.getNation(), group))
                .filter(group -> RussiaUkraineRule.isPreserved(team.getNation(), group))
                .forEach(possibleCombinations::add);
        }
    }

    public void validatePossibilities4Team(Team team){
        Set groups2Extract = getGroups2Extract();
        List<Group> possibleGroups = getPossibleCombinations(team);

        possibleGroups.removeAll(groups2Extract);
    }

    public void removeAssignedGroup(Group group){
        combinations.entrySet().stream()
            .filter(t -> t.getValue().contains(group))
            .forEach(t -> t.getValue().remove(group));
    }

    public List<Group> getPossibleCombinations(Team team) {
        return combinations.get(team);
    }

    private Set<Group> getGroups2Extract() {
        Set<Group> groups2Extract = new HashSet<>();
        List<Team> teams2Draw = pot.getTeams();
        teams2Draw.stream()
            .filter(team -> hasLimitedPossibilities(team) || isSingleCombination(team))
            .map(this::getPossibleCombinations)
            .forEach(groups2Extract::addAll);

        return groups2Extract;
    }

    private boolean hasLimitedPossibilities(Team team) {
        Nation nation = team.getNation();

        return getCountPossibleCombinations(team) == pot.getCountTeamsOfSameNation(nation);
    }

    private int getCountPossibleCombinations(Team team) {
        return getPossibleCombinations(team).size();
    }

    private boolean isSingleCombination(Team team) {
        List<Group> groups = combinations.get(team);
        return groups.size() == 1;
    }

}
