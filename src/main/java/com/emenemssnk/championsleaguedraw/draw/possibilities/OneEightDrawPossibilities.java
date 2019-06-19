package com.emenemssnk.championsleaguedraw.draw.possibilities;

import com.emenemssnk.championsleaguedraw.common.rules.SameCountryRule;
import com.emenemssnk.championsleaguedraw.common.rules.GroupStageRule;
import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class OneEightDrawPossibilities extends DrawPossibilities {
    private final DrawResult groupStageResult;

    public OneEightDrawPossibilities(Pot pot, DrawResult drawResult, DrawResult groupStageResult){
        super(pot, drawResult);
        this.groupStageResult = groupStageResult;
    }

    public void calculateAllPossibilities() {
        List<Team> teams = pot.getTeams();
        for (Team team: teams) {
            List<Group> possibleCombinations = getPossibleCombinations(team);
            List<Group> groups = drawResult.getGroups();

            groups.stream()
                .filter(group -> GroupStageRule.isPerseved(team, group.getTeams(), groupStageResult.getGroups()))
                .filter(group -> SameCountryRule.isPreserved(team.getNation(), group))
                .forEach(possibleCombinations::add);
        }
    }
}
