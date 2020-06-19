package model;

import java.util.Objects;

public class Battle {
    private boolean victorious;
    private String opponent;

    public Battle(boolean victorious, String opponent) {
        this.victorious = victorious;
        this.opponent = opponent;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battle battle = (Battle) o;
        return victorious == battle.victorious &&
                Objects.equals(opponent, battle.opponent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(victorious, opponent);
    }
}
