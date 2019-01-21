package com.emenemssnk.championsleaguedraw.draw.utils;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DrawResult {
    private static final int GROUP_STAGE = 8;
    public static final int ONE_OF_EIGHT = 8;
    public static final int QUATER_FINAL = 4;
    public static final int SEMI_FINAL = 2;
    //private final List<Group> groups = Stream.generate(Group::new).limit(NUMBER_OF_GROUPS).collect(Collectors.toList());

    public void addTeam2Group(Team team, int idGroup) {
        groups.get(idGroup).addTeam(team);
    }

    public void print() {
        /*System.out.println("GROUP STAGE DRAW RESULT:");
        groups.stream().forEach(group -> {
            System.out.println("Group: " + group.getNumber());
            group.getTeams().stream().forEach(System.out::println);
            System.out.println();
        });*/
    }

    public List<Group> getGroups() {
        return groups;
    }
}
