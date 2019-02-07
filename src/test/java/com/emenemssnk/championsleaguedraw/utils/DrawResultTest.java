/*
package com.emenemssnk.championsleaguedraw.utils;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DrawResultTest {

    private DrawResult drawResult;

    @BeforeEach
    void setUp() {
        drawResult = new DrawResult();
    }

    @Test
    void shouldAddTeam2ThirdGroup() {
        List<Group> groups = drawResult.getGroups();
        Group thirdGroup = groups.get(2);
        List<Team> thirdGroupTeams = thirdGroup.getTeams();
        Team team = new Team("FC Barcelona", Nation.SPAIN);

        assumeTrue(thirdGroupTeams.isEmpty());
        drawResult.addTeam2Group(team, 2);
        assertAll(() -> {
            assertFalse(thirdGroupTeams.isEmpty());
            assertTrue(thirdGroupTeams.contains(team));
        });
    }
}
*/
