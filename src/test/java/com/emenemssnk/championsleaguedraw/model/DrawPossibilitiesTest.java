package com.emenemssnk.championsleaguedraw.model;

import com.emenemssnk.championsleaguedraw.utils.DrawResult;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class DrawPossibilitiesTest {

    private DrawPossibilities drawPossibilities;

    @Mock
    Pot pot;
    @Mock
    DrawResult drawResult;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        drawPossibilities = new DrawPossibilities(pot, drawResult);
    }

    @Test
    void calculateAllPossibilities() {
        List<Team> teams2Draw = new ArrayList<>();
        List<Group> groups = new ArrayList<>();

        



    }

    @Test
    void validatePossibilities() {
    }

    @Test
    void updatePossibilities() {
    }

    @Test
    void getPossibleCombinations() {
    }
}
