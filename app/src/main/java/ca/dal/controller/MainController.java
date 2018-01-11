package ca.dal.controller;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import beans.GridItem;
import beans.GridItemIdentifier;
import services.CoreServices;
import services.RandomGeneratorService;
import services.RendererService;

/**
 * Created by Shiv on 2017-10-10.
 */

public class MainController {

    RendererService rs = new RendererService();
    CoreServices coreServices = new CoreServices();
    RandomGeneratorService randomGenService = new RandomGeneratorService();
    GridItem[][] items = new GridItem[9][9];

    public void initialize(AppCompatActivity t, int Mine) {


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                items[i][j] = new GridItem(false, 0, 0);
            }
        }

        for (int i = 0; i < Mine; i++) {
            int generatedNumber = randomGenService.generate(81);
            int XIndex = generatedNumber / 9;
            int YIndex = generatedNumber % 9;
            items[XIndex][YIndex].setType(2);
        }

        coreServices.populateSurroundingGridItemWithValues(items);
        rs.render(items, t);
    }

    public void buttonClicked(AppCompatActivity t, GridItemIdentifier gid) {
        GridItem gi = this.items[gid.getxIndex()][gid.getyIndex()];

        if (gi.getState() == true) {
            Log.d("App Logs", "Clicking already open grid item");
        } else if (gi.getType() == 2) {
            Log.d("App Logs", "Clicked on grid with mine");
            coreServices.showGrid(items, gid);
            Toast.makeText(t.getApplicationContext(), "Game Over",
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(t.getApplicationContext(), "press start to reset the counter",
                    Toast.LENGTH_SHORT).show();


        } else if (gi.getType() == 1) {
            Log.d("App Logs", "Clicked on grid with value");
            coreServices.showGrid(items, gid);
        } else {
            List<GridItemIdentifier> gidList = new ArrayList<GridItemIdentifier>();
            gidList.add(gid);
            coreServices.showAdjacentGridItems(items, gidList);
        }
        rs.render(items, t);
        return;

    }

    public void setflag(AppCompatActivity t, GridItemIdentifier gid) {
        GridItem gi = this.items[gid.getxIndex()][gid.getyIndex()];
        gi.setValue(99);

    }
}
