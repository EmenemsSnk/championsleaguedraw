package com.emenemssnk.championsleaguedraw.draw.utils;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;

public interface DrawResult {
    int GROUP_STAGE = 8;
    int ONE_OF_EIGHT = 8;
    int QUATER_FINAL = 4;
    int SEMI_FINAL = 2;

    void addTeam2Group(Team team, int idGroup);
    void print();
    List<Group> getGroups();
}
