package ca.dal.controller;

import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import beans.GridItem;
import services.CoreServices;
import services.RandomGeneratorService;
import services.RendererService;

/**
 * Created by Shiv on 2017-10-10.
 */

public class MainController {


    public static void initialize(AppCompatActivity t){

        GridView gv;
        GridItem[][] items = new GridItem[9][9];

        for(int i = 0; i < 9; i++) {
            for (int j=0; j<9; j++){
                items[i][j] = new GridItem(false, 0, 0);
            }
        }

        CoreServices coreServices = new CoreServices();

        RandomGeneratorService randomGenService = new RandomGeneratorService();
        for(int i=0; i<15; i++){
            int generatedNumber = randomGenService.generate(81);
            int XIndex = generatedNumber/9;
            int YIndex = generatedNumber%9;
            items[XIndex][YIndex].setType(2);
        }

        coreServices.populateSurroundingGridItemWithValues(items);
        RendererService rs = new RendererService();
        rs.render(items, t);
    }

}
