package com.emenemssnk.championsleaguedraw;

import com.emenemssnk.championsleaguedraw.draw.mechanism.GroupStageDraw;
import com.emenemssnk.championsleaguedraw.draw.utils.DrawResult;
import com.emenemssnk.championsleaguedraw.draw.utils.GroupStageDrawResult;
import com.emenemssnk.championsleaguedraw.pot.Pot;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
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
            GroupStageDrawResult groupStageDrawResult = new GroupStageDrawResult();
            GroupStageDraw groupStageDraw = new GroupStageDraw(pots, groupStageDrawResult);
            groupStageDraw.draw();
            groupStageDrawResult.print();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
