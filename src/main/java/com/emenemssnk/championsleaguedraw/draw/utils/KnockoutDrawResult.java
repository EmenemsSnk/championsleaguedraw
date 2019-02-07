package com.emenemssnk.championsleaguedraw.draw.utils;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnockoutDrawResult implements DrawResult{
    private final List<Group> groups;

    public KnockoutDrawResult(int knockoutStage) {
        groups = Stream.generate(() -> new Group(Group.GROUP_STAGE_SIZE))
            .limit(knockoutStage)
            .collect(Collectors.toList());
    }

    public void addTeam2Group(Team team, int idGroup) {
        groups.get(idGroup).addTeam(team);
    }

    public void print() {
        System.out.println("KNOCKOUT STAGE DRAW RESULT:");
        groups.stream().forEach(group -> {
            System.out.println("Pair: " + group.getNumber());
            group.getTeams().stream().forEach(System.out::println);
            System.out.println();
        });
    }

    public List<Group> getGroups() {
        return groups;
    }
}
