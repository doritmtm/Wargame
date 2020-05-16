package model;

public class Battle {
    private boolean victorious;
    private String opponent;
    public Battle(boolean vict,String opp)
    {
        victorious=vict;
        opponent=opp;
    }

    public boolean isVictorious() {
        return victorious;
    }

    public void setVictorious(boolean victorious) {
        this.victorious = victorious;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }
}
