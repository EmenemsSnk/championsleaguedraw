package com.emenemssnk.championsleaguedraw;

import com.emenemssnk.championsleaguedraw.draw.DrawMechanism;
import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.group.Group;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String JSON_PATH = "/home/micdzied/Projects/InteliJ/prywatne/championsleaguedraw/src/main/resources/pots.json";

    public static void main(String[] args) {
        try (JsonReader reader = new JsonReader(new FileReader(JSON_PATH))){
            Type listType = new TypeToken<ArrayList<Pot>>(){}.getType();
            List<Pot> pots = new Gson().fromJson(reader, listType);
            DrawResult drawResult = new DrawResult(Group.GROUP_STAGE_SIZE, DrawResult.GROUP_STAGE);
            DrawMechanism groupStageDraw = new DrawMechanism(pots, drawResult);
            groupStageDraw.draw();
            drawResult.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
