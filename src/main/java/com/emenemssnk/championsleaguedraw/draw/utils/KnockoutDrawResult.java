package com.emenemssnk.championsleaguedraw.draw.utils;

import com.emenemssnk.championsleaguedraw.group.Pair;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KnockoutDrawResult {

    private final List<Pair> pairs;

    public KnockoutDrawResult(int knockoutStage) {
        pairs = Stream.generate(Pair::new).limit(knockoutStage).collect(Collectors.toList());
    }

    /*public void addTeam2Group(Team team, int idGroup) {
        groups.get(idGroup).addTeam(team);
    }

    public void print() {
        System.out.println("GROUP STAGE DRAW RESULT:");
        groups.stream().forEach(group -> {
            System.out.println("Group: " + group.getNumber());
            group.getTeams().stream().forEach(System.out::println);
            System.out.println();
        });

    }

    public List<Group> getGroups() {
        return groups;
    }*/
}
