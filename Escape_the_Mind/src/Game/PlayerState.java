package Game;

public class PlayerState {
    private boolean hasKey = false;
    private boolean hasWishbone = false;
    private boolean isCursed = false;
    private boolean handsAreGold = false;
    private boolean sawTapestryMove = false;
    private boolean hasBread = false;

    public boolean hasKey() {
        return hasKey;
    }

    public void giveKey() {
        hasKey = true;
    }

    public boolean hasWishbone() {
        return hasWishbone;
    }

    public void giveWishbone() {
        hasWishbone = true;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public void curse() {
        isCursed = true;
    }

    public void liftCurse() {
        isCursed = false;
    }

    public boolean handsAreGold() {
        return handsAreGold;
    }

    public void turnHandsToGold() {
        this.handsAreGold = true;
    }

    public boolean sawTapestryMove() {
        return sawTapestryMove;
    }

    public void seeTapestryMove() {
        this.sawTapestryMove = true;
    }

    public boolean hasBread() {
        return hasBread;
    }

    public void takeBread() {
        hasBread = true;
    }

}
