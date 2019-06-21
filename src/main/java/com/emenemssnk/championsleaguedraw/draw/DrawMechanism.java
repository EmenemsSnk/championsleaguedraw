package com.emenemssnk.championsleaguedraw.draw;

import com.emenemssnk.championsleaguedraw.draw.possibilities.DrawPossibilities;
import com.emenemssnk.championsleaguedraw.draw.possibilities.GroupDrawPossibilities;
import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class DrawMechanism {
    private final DrawResult drawResult;
    private final List<Pot> pots;
    private DrawResult groupStageResult;
    private DrawPossibilities drawPossibilities;

    public DrawMechanism(List<Pot> pots, DrawResult drawResult) {
        this.pots = pots;
        this.drawResult = drawResult;
    }

    public DrawMechanism(List<Pot> pots, DrawResult drawResult, DrawResult groupStageResult) {
        this.pots = pots;
        this.drawResult = drawResult;
        this.groupStageResult = groupStageResult;
    }

    public void draw() {
        pots.forEach(pot -> {
            drawPossibilities = new GroupDrawPossibilities(pot, drawResult);
            drawPossibilities.calculateAllPossibilities();

            while (!pot.isEmpty()) {
                Team chosenTeam = drawTeam(pot);
                drawPossibilities.validatePossibilities4Team(chosenTeam);

                Group chosenGroup = drawGroup4Team(chosenTeam);
                drawResult.addTeam2Group(chosenTeam, chosenGroup);
            }
        });
    }
/*

    public void draw8() {
        pots.forEach(pot -> {
            drawPossibilities = new OneEightDrawPossibilities(pot, drawResult, groupStageResult);
            drawPossibilities.calculateAllPossibilities();

            while (!pot.isEmpty()) {
                Team chosenTeam = drawTeam(pot);
                drawPossibilities.validatePossibilities4Team(chosenTeam);

                Group chosenGroup = drawGroup4Team(chosenTeam);
                drawResult.addTeam2Group(chosenTeam, chosenGroup);
            }
        });
    }
*/

    private Team drawTeam(Pot pot) {
        int chosenTeamIndex = getRandomIndex(pot.getCurrentSize());

        return pot.pullTeam(chosenTeamIndex);
    }

    private Group drawGroup4Team(Team team) {
        int numberOfPossibilities = drawPossibilities.getNumberOfPossibleCombinations4Team(team);
        int groupIndex = getRandomIndex(numberOfPossibilities);

        return drawPossibilities.pullGroup4Team(groupIndex, team);
    }

    private int getRandomIndex(int range) {
        return (int) (Math.random() * range);
    }
}
