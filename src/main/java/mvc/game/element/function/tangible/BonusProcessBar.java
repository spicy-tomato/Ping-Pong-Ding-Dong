package main.java.mvc.game.element.function.tangible;

import main.java.mvc.game.element.function.intangible.bonus.Bonus;
import main.java.mvc.game.element.function.intangible.bonus.BonusType;

import java.awt.*;
import java.util.AbstractMap;
import java.util.Map;

public class BonusProcessBar {

    private final Bonus bonus;

    private static final Map<BonusType, Color> COLOR_MAP = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(BonusType.bigBall, Color.blue),
            new AbstractMap.SimpleEntry<>(BonusType.multiBall, Color.green),
            new AbstractMap.SimpleEntry<>(BonusType.speedingBall, Color.pink),
            new AbstractMap.SimpleEntry<>(BonusType.slowlyPaddle, Color.yellow),
            new AbstractMap.SimpleEntry<>(BonusType.increaseOwnPaddleSize, Color.red),
            new AbstractMap.SimpleEntry<>(BonusType.decreaseOpponentPaddleSize, Color.magenta)
    );

    public BonusProcessBar(Bonus bonus) {
        this.bonus = bonus;
    }

    public Color getColor() {
        return COLOR_MAP.get(bonus.getType());
    }

    public int getWidth() {
        return bonus.getTimeLeft()/11;
    }
}
