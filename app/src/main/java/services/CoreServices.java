package services;

import beans.GridItem;

/**
 * Created by Shiv on 2017-10-11.
 */

public class CoreServices {

    public void populateSurroundingGridItemWithValues(GridItem[][] items){

        for(int i = 0; i < 9; i++) {
            for (int j=0; j<9; j++){
                if(items[i][j].getType() == 2){
                    if(i-1>=1){
                        if(j-1>=1){
                            int XIndex = i-1;
                            int YIndex = j-1;
                            if(items[XIndex][YIndex].getType() != 2){
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue()+1);
                            }
                        }
                        if(j+1<8){
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
                    if(i+1<8){
                        if(j-1>=1){
                            int XIndex = i+1;
                            int YIndex = j-1;
                            if(items[XIndex][YIndex].getType() != 2) {
                                items[XIndex][YIndex].setType(1);
                                items[XIndex][YIndex].setValue(items[XIndex][YIndex].getValue() + 1);
                            }
                        }
                        if(j+1<8){
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

}
