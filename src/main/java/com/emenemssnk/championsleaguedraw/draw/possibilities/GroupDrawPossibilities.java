package com.emenemssnk.championsleaguedraw.draw.possibilities;

import com.emenemssnk.championsleaguedraw.common.rules.RussiaUkraineRule;
import com.emenemssnk.championsleaguedraw.common.rules.SameCountryRule;
import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class GroupDrawPossibilities extends DrawPossibilities {

    public GroupDrawPossibilities(Pot pot, DrawResult drawResult){
        super(pot, drawResult);
    }

    @Override
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
}
