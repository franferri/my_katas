package coup;

public abstract class Card {

    private boolean visible;

    public String name = "card";

    protected Card() {
        this.visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    protected Action action;
    protected Action blocks;

    public Action doAction() {
        return action;
    }

    public Action blocksAction() {
        return blocks;
    }

}
