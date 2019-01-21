package com.emenemssnk.championsleaguedraw.draw.mechanism;

import com.emenemssnk.championsleaguedraw.draw.DrawPossibilities;
import com.emenemssnk.championsleaguedraw.draw.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class GroupStageDraw implements DrawMechanism{
    private final DrawResult drawResult = new DrawResult();
    private DrawPossibilities drawPossibilities;

    public GroupStageDraw(DrawResult drawResult) {
//        this.drawResult = drawResult;
    }

    public void draw() {
        /*Pot pot;
        drawPossibilities = new DrawPossibilities(pot, drawResult);
        drawPossibilities.calculateAllPossibilities();
        List<Team> teams2Draw = pot.getTeams();

        while(!pot.isEmpty()) {
            Team chosenTeam = drawTeam(teams2Draw);
            drawPossibilities.validatePossibilities4Team(chosenTeam);
            List<Group> possibleGroups = drawPossibilities.getPossibleCombinations(chosenTeam);
            Group chosenGroup = drawGroup(possibleGroups);
            drawResult.addTeam2Group(chosenTeam, chosenGroup.getNumber()-1);
        }*/
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

/*    public DrawResult getDrawResult() {
        return drawResult;
    }*/
}
