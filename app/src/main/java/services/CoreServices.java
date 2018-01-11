package services;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import beans.GridItem;
import beans.GridItemIdentifier;

/**
 * Created by Shiv on 2017-10-11.
 */

public class CoreServices {

    public void populateSurroundingGridItemWithValues(GridItem[][] items){

        for(int i = 0; i < 9; i++) {
            for (int j=0; j<9; j++){
                if(items[i][j].getType() == 2){
                    if(i-1>=0){
                        if(j-1>=0){
                            int XIndex = i-1;
                            int YIndex = j-1;
                            if(items[XIndex][YIndex].getType() != 2){
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue()+1);
                            }
                        }
                        if(j+1<9){
                            int XIndex = i-1;
                            int YIndex = j+1;

                            if(items[XIndex][YIndex].getType() != 2) {
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                            }
                        }
                        int XIndex = i-1;
                        int YIndex = j;

                        if(items[XIndex][YIndex].getType() != 2){
                            items[XIndex][YIndex].setType(1);
                            items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue()+1);
                        }
                    }
                    if(i+1<9){
                        if(j-1>=0){
                            int XIndex = i+1;
                            int YIndex = j-1;
                            if(items[XIndex][YIndex].getType() != 2) {
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                            }
                        }
                        if(j+1<9){
                            int XIndex = i+1;
                            int YIndex = j+1;
                            if(items[XIndex][YIndex].getType() != 2) {
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                            }
                        }
                        int XIndex = i+1;
                        int YIndex = j;
                        if(items[XIndex][YIndex].getType() != 2) {
                            items[XIndex][YIndex].setType(1);
                            items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                        }
                    }

                    if(j>=1){
                        int XIndex = i;
                        int YIndex = j-1;
                        if(items[XIndex][YIndex].getType() != 2) {
                            items[XIndex][YIndex].setType(1);
                            items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                        }
                    }

                    if(j<8){
                        int XIndex = i;
                        int YIndex = j+1;
                        if(items[XIndex][YIndex].getType() != 2) {
                            items[XIndex][YIndex].setType(1);
                            items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                        }
                    }
                }
            }
        }

    }

    /*
    *   gid is checked that it is empty item
    *   Step 1 - show gid by iteration
    *   step 2 - iterate over gidList
    *   step 2 - get ajacent nodes new list if space and opened
    *   step 4 - remove item from old list and append new list to old list
    *   step 3 - recursion
    */public void showAdjacentGridItems(GridItem[][] items, List<GridItemIdentifier> gidList){

        for(GridItemIdentifier gid : gidList){
            Log.d("App Logs", String.valueOf(gid.getxIndex()) + "  " + String.valueOf(gid.getyIndex()));
            GridItem gi = items[gid.getxIndex()][gid.getyIndex()];
            gi.setState(true);
            if(gi.getState() == true && gi.getType() == 0){
                List<GridItemIdentifier> adjGidList = this.getListOfAdjacentNodes(items, gid);
                // filter required if already opened
                adjGidList = this.removeAlreadyOpenedFromList(items, adjGidList);
                this.showAdjacentGridItems(items, adjGidList);
            }
        }

    }

    public List<GridItemIdentifier> removeAlreadyOpenedFromList(GridItem[][] items, List<GridItemIdentifier> gidList){
        List<GridItemIdentifier> tempGid = new ArrayList<GridItemIdentifier>();
        for(GridItemIdentifier gid : gidList){
            GridItem gi = items[gid.getxIndex()][gid.getyIndex()];
            if(gi.getState() == false){
                tempGid.add(gid);
            }
        }

        return tempGid;
    }

    public List<GridItemIdentifier> getListOfAdjacentNodes(GridItem[][] items, GridItemIdentifier gid){

        List<GridItemIdentifier> gidList = new ArrayList<GridItemIdentifier>();

        int i = gid.getxIndex();
        int j = gid.getyIndex();

        if(i-1>=0){
            if(j-1>=0){
                int XIndex = i-1;
                int YIndex = j-1;
                if(items[XIndex][YIndex].getType() != 2){
                    GridItemIdentifier tempGid = new GridItemIdentifier();
                    gidList.add(tempGid);
                    tempGid.setxIndex(XIndex);
                    tempGid.setyIndex(YIndex);
                }
            }
            if(j+1<9){
                int XIndex = i-1;
                int YIndex = j+1;

                if(items[XIndex][YIndex].getType() != 2) {
                    GridItemIdentifier tempGid = new GridItemIdentifier();
                    gidList.add(tempGid);
                    tempGid.setxIndex(XIndex);
                    tempGid.setyIndex(YIndex);
                }
            }
            int XIndex = i-1;
            int YIndex = j;

            if(items[XIndex][YIndex].getType() != 2){
                GridItemIdentifier tempGid = new GridItemIdentifier();
                gidList.add(tempGid);
                tempGid.setxIndex(XIndex);
                tempGid.setyIndex(YIndex);
            }
        }
        if(i+1<9){
            if(j-1>=0){
                int XIndex = i+1;
                int YIndex = j-1;
                if(items[XIndex][YIndex].getType() != 2) {
                    GridItemIdentifier tempGid = new GridItemIdentifier();
                    gidList.add(tempGid);
                    tempGid.setxIndex(XIndex);
                    tempGid.setyIndex(YIndex);
                }
            }
            if(j+1<9){
                int XIndex = i+1;
                int YIndex = j+1;
                if(items[XIndex][YIndex].getType() != 2) {
                    GridItemIdentifier tempGid = new GridItemIdentifier();
                    gidList.add(tempGid);
                    tempGid.setxIndex(XIndex);
                    tempGid.setyIndex(YIndex);
                }
            }
            int XIndex = i+1;
            int YIndex = j;
            if(items[XIndex][YIndex].getType() != 2) {
                GridItemIdentifier tempGid = new GridItemIdentifier();
                gidList.add(tempGid);
                tempGid.setxIndex(XIndex);
                tempGid.setyIndex(YIndex);
            }
        }

        if(j>=1){
            int XIndex = i;
            int YIndex = j-1;
            if(items[XIndex][YIndex].getType() != 2) {
                GridItemIdentifier tempGid = new GridItemIdentifier();
                gidList.add(tempGid);
                tempGid.setxIndex(XIndex);
                tempGid.setyIndex(YIndex);
            }
        }

        if(j<8){
            int XIndex = i;
            int YIndex = j+1;
            if(items[XIndex][YIndex].getType() != 2) {
                GridItemIdentifier tempGid = new GridItemIdentifier();
                gidList.add(tempGid);
                tempGid.setxIndex(XIndex);
                tempGid.setyIndex(YIndex);
            }
        }

        return gidList;
    }



    public void showGrid(GridItem[][] items, GridItemIdentifier gid){
        GridItem gi = items[gid.getxIndex()][gid.getyIndex()];
        gi.setState(true);
        return;
    }
}
