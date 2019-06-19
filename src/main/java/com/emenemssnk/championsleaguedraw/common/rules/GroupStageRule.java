package com.emenemssnk.championsleaguedraw.common.rules;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public class GroupStageRule {

    public static boolean isPerseved(Team team2put, List<Team> teamsOfGroup, List<Group> groupStageResult){
        return teamsOfGroup.isEmpty() || groupStageResult.stream()
            .noneMatch(group -> group.contains(team2put) && group.contains(teamsOfGroup.get(0)));
    }
}
