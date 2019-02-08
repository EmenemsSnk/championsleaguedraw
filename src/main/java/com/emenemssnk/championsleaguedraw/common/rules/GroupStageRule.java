package com.emenemssnk.championsleaguedraw.common.rules;

import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.team.Team;

public class GroupStageRule {

    public static boolean isPerseved(DrawResult drawResult, Team firstTeam, Team secondTeam){
        return drawResult.getGroups().stream()
            .anyMatch(group -> group.containsTeam(firstTeam) && group.containsTeam(secondTeam));
    }

}
