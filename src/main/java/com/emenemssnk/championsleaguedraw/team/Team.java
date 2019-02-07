package com.emenemssnk.championsleaguedraw.team;

public final class Team {
    private final String name;
    private final Nation nation;

    public Team(String name, Nation nation) {
        this.name = name;
        this.nation = nation;
    }

    public String getName() {
        return name;
    }

    public Nation getNation() {
        return nation;
    }

    @Override
    public String toString() {
        return name + ", " + nation;
    }

    public enum Nation {
        ENGLAND("ENG"), POLAND("PL"), SPAIN("ESP"), ITALY("ITA"), GERMANY("GER"), PORTUGAL("POR"), HOLAND("HOL"),
        FRANCE("FRA"), CROATIA("CRO"), SLOVAKIA("SLO"), BELGIUM("BEL"), SWITZERLAND("SWI"), GREECE("GRE"), UKRAINE("UKR"),
        CZECH_REPUBLIC("CZE"), TURKEY("TUR"), SERBIA("SER"), RUSSIA("RUS");

        private String shortcut;

        Nation(String shortcut){
            this.shortcut = shortcut;
        }

        public String getShortcut() {
            return shortcut;
        }
    }
}
