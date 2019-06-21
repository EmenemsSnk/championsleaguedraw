package com.emenemssnk.championsleaguedraw.draw.utils;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DrawResult {
    public static final int GROUP_STAGE = 8;
    public static final int ONE_OF_EIGHT = 8;
    public static final int QUATER_FINAL = 4;
    public static final int SEMI_FINAL = 2;

    private final List<Group> groups;

    public DrawResult(int groupSize, int stage) {
        groups = Stream.generate(() -> new Group(groupSize))
        .limit(stage)
        .collect(Collectors.toList());
    }

    public void addTeam2Group(Team team, Group chosenGroup) {
        chosenGroup.addTeam(team);
    }

    public void print() {
        groups.forEach(group -> {
            group.getTeams().forEach(System.out::println);
            System.out.println();
        });
    }

    public List<Group> getGroups() {
        return groups;
    }
}
