package com.emenemssnk.championsleaguedraw.model;

import static org.junit.jupiter.api.Assertions.*;
import com.emenemssnk.championsleaguedraw.model.Team.Nation;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PotTest {

    private Pot pot;

    @BeforeEach
    void setUp() {
        List<Team> teams = new ArrayList<>();
        teams.add(new Team("FC Barcelona", Nation.SPAIN));
        teams.add(new Team("FC Barcelona", Nation.SPAIN));
        teams.add(new Team("Chelsea FC", Nation.ENGLAND));
        pot = new Pot(1, teams);
    }

    @Test
    void shouldReturnProperNumberOfTeams() {
        assertAll(() -> {
            assertEquals(0, pot.getCountTeamsOfSameNation(Nation.POLAND));
            assertEquals(1, pot.getCountTeamsOfSameNation(Nation.ENGLAND));
            assertEquals(2, pot.getCountTeamsOfSameNation(Nation.SPAIN));
        });
    }

    @Test
    void potShouldNotBeEmpty() {
        List<Team> teams = pot.getTeams();

        assertFalse(teams.isEmpty());
    }
}
