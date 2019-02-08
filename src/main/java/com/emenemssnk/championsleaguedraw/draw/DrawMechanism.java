package com.emenemssnk.championsleaguedraw.draw;

import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class DrawMechanism {
    private final DrawResult drawResult;
    private final List<Pot> pots;
    private DrawPossibilities drawPossibilities;

    public DrawMechanism(List<Pot> pots, DrawResult drawResult) {
        this.pots = pots;
        this.drawResult = drawResult;
    }

    public void draw() {
        pots.forEach(pot -> {
            drawPossibilities = new DrawPossibilities(pot, drawResult);
            drawPossibilities.calculateAllPossibilities();

            while (!pot.isEmpty()) {
                Team chosenTeam = drawTeam(pot);
                drawPossibilities.validatePossibilities4Team(chosenTeam);

                Group chosenGroup = drawGroup4Team(chosenTeam);
                drawResult.addTeam2Group(chosenTeam, chosenGroup.getNumber() - 1);
            }
        });
    }

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
