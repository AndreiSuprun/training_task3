package com.suprun.basketfilling.creator;

import com.suprun.basketfilling.entity.Ball;
import com.suprun.basketfilling.entity.Ball.Color;
import com.suprun.basketfilling.entity.Basket;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreatorTest {

    Creator creator;

    @BeforeClass
    public void beforeClass() {
        creator = new Creator();
    }

    @DataProvider
    public static Object[][] createBallsEquals() {
        return new Object[][]{{3, 5, Color.BLUE, new Ball(3, 5, Color.BLUE)},
                {0, 5, Color.RED, new Ball(2, 5, Color.RED)},
                {10, 0, Color.YELLOW, new Ball(10, 2, Color.YELLOW)},
                {5, 7, null, new Ball(5, 7, Color.WHITE)},
                {30, 10, Color.BLACK, new Ball(2, 10, Color.BLACK)},
                {8, 25, Color.CYAN, new Ball(8, 2, Color.CYAN)}};
    }

    @Test(dataProvider = "createBallsEquals")
    public void testCreateBallEquals(int volume, int weight, Ball.Color color, Ball expectedResult) {
        Ball actual = creator.createBall(volume, weight, color);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] createBallsNotEquals() {
        return new Object[][]{{3, 5, Color.BLUE, new Ball(1, 5, Color.BLUE)},
                {0, 5, Color.RED, new Ball(0, 5, Color.RED)},
                {10, 0, Color.YELLOW, new Ball(10, 0, Color.YELLOW)},
                {5, 7, null, new Ball(5, 7, null)},
                {30, 10, Color.BLACK, new Ball(30, 10, Color.BLACK)},
                {20, 40, Color.CYAN, new Ball(20, 40, Color.CYAN)}};
    }

    @Test(dataProvider = "createBallsNotEquals")
    public void testCreateBallNotEquals(int volume, int weight, Ball.Color color, Ball expectedResult) {
        Ball actual = creator.createBall(volume, weight, color);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] createBasketEquals() {
        return new Object[][]{{10, new Basket(20)}, {30, new Basket(30)},
                {150, new Basket(100)}, {-20, new Basket(20)}};
    }

    @Test(dataProvider = "createBasketEquals")
    public void testCreateBasketEquals(int basketCapacity, Basket expectedResult) {
        Basket actual = creator.createBasket(basketCapacity);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] createBasketNotEquals() {
        return new Object[][]{{10, new Basket(10)}, {30, new Basket(20)},
                {150, new Basket(150)}, {-20, new Basket(-20)}};
    }

    @Test(dataProvider = "createBasketNotEquals")
    public void testCreateBasketNotEquals(int basketCapacity, Basket expectedResult) {
        Basket actual = creator.createBasket(basketCapacity);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] fillBasketEquals() {
        return new Object[][]{{new Basket(20), 5}, {new Basket(30), 8}, {new Basket(100), 19}};
    }

    @Test(dataProvider = "fillBasketEquals")
    public void testFillBasketEquals(Basket basket, int expectedResult) {
        int actual = creator.fillBasket(basket);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] fillBasketNotEquals() {
        return new Object[][]{{new Basket(20), 6}, {new Basket(30), 4}, {new Basket(100), 14}};
    }

    @Test(dataProvider = "fillBasketNotEquals")
    public void testFillBasketNotEquals(Basket basket, int expectedResult) {
        int actual = creator.fillBasket(basket);
        assertNotEquals(expectedResult, actual);
    }

    @AfterClass
    public void afterClass() {
        creator = null;
    }
}