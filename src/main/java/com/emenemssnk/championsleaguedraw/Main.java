package com.emenemssnk.championsleaguedraw;

import com.emenemssnk.championsleaguedraw.draw.mechanism.GroupStageDraw;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class Main {
    private static final String JSON_PATH = "/home/micdzied/Projects/InteliJ/prywatne/championsleaguedraw/src/main/resources/pots.json";

    public static void main(String[] args) {
        try {
            JsonReader reader = new JsonReader(new FileReader(JSON_PATH));
            PotLoader pot = new Gson().fromJson(reader, PotLoader.class);
            GroupStageDraw groupStageDraw = new GroupStageDraw();
            List<Pot> pots = pot.getPots();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
