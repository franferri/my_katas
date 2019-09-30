package coup;

public abstract class Card {
    
    private Action action;
    private Action blocks;

    public Action doAction() {
        return getAction();
    }

    public Action blocksAction() {
        return getBlocks();
    }

    public Action getAction() {
        return action;
    }

    public void setAction(final Action action) {
        this.action = action;
    }

    public Action getBlocks() {
        return blocks;
    }

    public void setBlocks(final Action blocks) {
        this.blocks = blocks;
    }
}
