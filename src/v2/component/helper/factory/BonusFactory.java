package v2.component.helper.factory;

import v2.component.gameObject.immovable.bonus.Bonus;
import v2.component.gameObject.immovable.star.StarType;

import java.util.ArrayList;
import java.util.List;

public class BonusFactory {

    private final List<Bonus> listBonus = new ArrayList<>();

    public BonusFactory() { }

    public void createBonus(StarType starType) {
        Bonus bonus = new Bonus(starType);
        int duplicateIndex = indexOf(bonus);

        if (duplicateIndex == -1) {
            addBonus(bonus);
        }
        else {
            extendBonus(duplicateIndex);
        }
    }

    public List<Bonus> getBonusList() {
        return listBonus;
    }

    public Bonus getBonus(int i) {
        return listBonus.get(i);
    }

    public void update() {
        for (int i = 0; i < listBonus.size(); ) {
            listBonus.get(i).decreaseTimeLeft();

            if (listBonus.get(i).getTimeLeft() <= 0) {
                listBonus.remove(i);
            }
            else {
                i++;
            }
        }
    }

    private int indexOf(Bonus bonus) {
        if (listBonus.size() == 0) {
            return -1;
        }

        for (int i = 0; i < listBonus.size(); i++) {
            if (listBonus.get(i).getStarType() == bonus.getStarType()) {
                return i;
            }
        }

        return -1;
    }

    private void addBonus(Bonus bonus){
        listBonus.add(bonus);
    }

    private void extendBonus(int bonusIndex){
        listBonus.get(bonusIndex).setTimeLeft(Bonus.EXIST_TIME);
    }
}
