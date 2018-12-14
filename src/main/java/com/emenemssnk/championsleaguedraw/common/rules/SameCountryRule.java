package com.emenemssnk.championsleaguedraw.common.rules;

import com.emenemssnk.championsleaguedraw.model.Group;
import com.emenemssnk.championsleaguedraw.model.Team.Nation;

public class SameCountryRule {

    /*
    * There cannot be more than one team of same nationality in one group
    */
    public static boolean isPreserved(Nation nation, Group group) {
        return !group.containsTeamOfNation(nation);
    }

}
