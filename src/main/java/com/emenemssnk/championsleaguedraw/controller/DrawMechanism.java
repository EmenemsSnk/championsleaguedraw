package com.emenemssnk.championsleaguedraw.controller;

import com.emenemssnk.championsleaguedraw.model.DrawPossibilities;
import com.emenemssnk.championsleaguedraw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.model.Group;
import com.emenemssnk.championsleaguedraw.model.Pot;
import com.emenemssnk.championsleaguedraw.model.Team;
import java.util.List;

public class DrawMechanism {
    private final DrawResult drawResult;
    private DrawPossibilities drawPossibilities;

    public DrawMechanism(DrawResult drawResult) {
        this.drawResult = drawResult;
    }

    public void draw(Pot pot) {
        drawPossibilities = new DrawPossibilities(pot, drawResult);
        drawPossibilities.calculateAllPossibilities();
        List<Team> teams2Draw = pot.getTeams();

        while(!pot.isEmpty()) {
            Team chosenTeam = drawTeam(teams2Draw);
            drawPossibilities.validatePossibilities4Team(chosenTeam);
            List<Group> possibleGroups = drawPossibilities.getPossibleCombinations(chosenTeam);
            Group chosenGroup = drawGroup(possibleGroups);
            drawResult.addTeam2Group(chosenTeam, chosenGroup.getNumber()-1);
        }
    }

    private Team drawTeam(List<Team> teams2Draw) {
        int chosenTeamIndex = getRandomIndex(teams2Draw.size());
        Team team = teams2Draw.get(chosenTeamIndex);
        teams2Draw.remove(team);

        return team;
    }

    private Group drawGroup(List<Group> possibleGroups) {
        int groupIndex = getRandomIndex(possibleGroups.size());
        Group chosenGroup = possibleGroups.get(groupIndex);
        drawPossibilities.removeAssignedGroup(chosenGroup);

        return chosenGroup;
    }

    private int getRandomIndex(int range) {
        return (int) (Math.random() * range);
    }
}
