package com.emenemssnk.championsleaguedraw.model;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.emenemssnk.championsleaguedraw.model.Team.Nation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GroupTest {

    private Group group;

    @BeforeEach
    void setUp() {
        group = new Group();
    }

    @Test
    void groupShouldContainsOnlyEnglandTeam() {
        group.addTeam(new Team("Chelsea FC", Nation.ENGLAND));

        assumeTrue(group.getTeams().size() == 1);
        assertAll(() -> {
            assertTrue(group.containsTeamOfNation(Nation.ENGLAND));
            assertFalse(group.containsTeamOfNation(Nation.POLAND));
        });
    }
}
