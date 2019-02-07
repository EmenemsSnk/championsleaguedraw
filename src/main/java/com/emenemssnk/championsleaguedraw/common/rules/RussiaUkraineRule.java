package com.emenemssnk.championsleaguedraw.common.rules;

import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.team.Team.Nation;

public class RussiaUkraineRule {

    /*
     * Russia and Ukraine cannot play together in one group
     */
    public static boolean isPreserved(Nation nation, Group group) {
        switch(nation){
        case UKRAINE:
            return !group.containsTeamOfNation(Nation.RUSSIA);
        case RUSSIA:
            return !group.containsTeamOfNation(Nation.UKRAINE);
        default:
            return true;
        }
    }

}
