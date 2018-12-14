package com.emenemssnk.championsleaguedraw.utils;

import com.emenemssnk.championsleaguedraw.model.Group;
import com.emenemssnk.championsleaguedraw.model.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrawResult {
    private final List<Group> groups = Stream.generate(Group::new).limit(8).collect(Collectors.toList());

    public void addTeam2Group(Team team, int idGroup) {
        groups.get(idGroup).addTeam(team);
    }

    public void print() {
        System.out.println("DRAW RESULT:");
        groups.stream().forEach(group -> {
            System.out.println("Group: " + group.getNumber());
            group.getTeams().stream().forEach(System.out::println);
            System.out.println();
        });

    }

    public List<Group> getGroups() {
        return groups;
    }
}
