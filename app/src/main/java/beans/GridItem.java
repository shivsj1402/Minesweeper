package beans;

/**
 * Created by Shiv on 2017-10-10.
 */

public class GridItem {

    public GridItem(Boolean state, int type, int value){
        this.setState(state);
        this.setType(type);
        this.setValue(value);
    }
    private Boolean state;

    private int type;

    private int value;

    private String toView;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getToView() {
        return toView;
    }

    public void setToView(String toView) {
        this.toView = toView;
    }
}
