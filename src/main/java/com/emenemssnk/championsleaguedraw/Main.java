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
    private static final String JSON_PATH = "/home/micdzied/Projects/InteliJ/prywatne/championsleaguedraw/src/main/resources/pots4GroupStage.json";
    /*private static final String JSON_PATH_2 = "/home/micdzied/Projects/InteliJ/prywatne/championsleaguedraw/src/main/resources/pots18.json";*/

    public static void main(String[] args) {
        try (JsonReader reader = new JsonReader(new FileReader(JSON_PATH))){
            Type listType = new TypeToken<ArrayList<Pot>>(){}.getType();
            List<Pot> pots = new Gson().fromJson(reader, listType);
            DrawResult groupStageDrawResult = new DrawResult(Group.GROUP_STAGE_SIZE, DrawResult.GROUP_STAGE);
            DrawMechanism drawMechanism = new DrawMechanism(pots, groupStageDrawResult);
            drawMechanism.draw();
            groupStageDrawResult.print();

        /*    System.out.println("--------------------------------");
            JsonReader reader2 = new JsonReader(new FileReader(JSON_PATH_2));
            Type listType2 = new TypeToken<ArrayList<Pot>>(){}.getType();
            List<Pot> pots2 = new Gson().fromJson(reader2, listType2);
            DrawResult drawResult2 = new DrawResult(Group.KNOCKOUT_SIZE, DrawResult.ONE_OF_EIGHT);
            DrawMechanism groupStageDraw2 = new DrawMechanism(pots2, drawResult2, drawResult);
            groupStageDraw2.draw8();
            drawResult2.print();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
