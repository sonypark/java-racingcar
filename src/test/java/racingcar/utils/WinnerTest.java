package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.MoveNumber;
import racingcar.domain.Winner;

class WinnerTest {

    private List<Car> carList;
    private Car carPobi;
    private Car carCrong;
    private MoveNumber moveNumber;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carPobi = new Car(new CarName("pobi"));
        carCrong = new Car(new CarName("crong"));
        moveNumber = new MoveNumber(4);
    }

    @Test
    void getWinners() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(moveNumber);
        carCrong.move(moveNumber);
        carCrong.move(moveNumber);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong");
    }

    @Test
    void getWinners_When_MoreThan_2() {
        carList.add(carPobi);
        carList.add(carCrong);
        carPobi.move(moveNumber);
        carCrong.move(moveNumber);

        Assertions.assertThat(Winner.getWinners(carList)).contains("crong", "pobi");
    }
}
