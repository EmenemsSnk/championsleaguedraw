package com.emenemssnk.championsleaguedraw;

import com.emenemssnk.championsleaguedraw.controller.DrawMechanism;
import com.emenemssnk.championsleaguedraw.controller.PotLoader;
import com.emenemssnk.championsleaguedraw.model.Pot;
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
            DrawMechanism drawMechanism = new DrawMechanism();
            List<Pot> pots = pot.getPots();
            pots.forEach(drawMechanism::draw);
            drawMechanism.getDrawResult().print();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}