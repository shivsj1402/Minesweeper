package services;

import com.example.shiv.minesweeper.CustomGridAdapter;
import com.example.shiv.minesweeper.MainActivity;
import com.example.shiv.minesweeper.R;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import beans.GridItem;

/**
 * Created by Shiv on 2017-10-10.
 */

public class RendererService {

    public void render(GridItem[][] items, AppCompatActivity t){
        String[][] view = new String[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j=0; j<9; j++){
//                if(items[i][j].getState() == false){
                if(false){
                    view[i][j] = " ";
                }else{
                    if(items[i][j].getType() == 0){
                        view[i][j] = "_";
                    }else if(items[i][j].getType() == 1){
                        view[i][j] = String.valueOf(items[i][j].getValue());
                    }else{
                        view[i][j] = "*";
                    }
                }
            }
        }

        GridView gv = (GridView) t.findViewById(R.id.mygrid);
        final CustomGridAdapter gridAdapter = new CustomGridAdapter(t, view);
        gv.setAdapter(gridAdapter);

    }

}
