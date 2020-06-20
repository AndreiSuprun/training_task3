package com.suprun.basketfilling.validator;

import com.suprun.basketfilling.entity.Ball.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidatorTest {

    Validator validator;

    @BeforeClass
    public void beforeClass() {
        validator = new Validator();
    }

    @DataProvider
    public static Object[][] ballVolumeEquals() {
        return new Object[][]{{5, 5}, {1, 2}, {-5, 2}, {30, 2}};
    }

    @Test(dataProvider = "ballVolumeEquals")
    public void testValidateBallVolumeEquals(int volume, int expectedResult) {
        int actual = validator.validateBallVolume(volume);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] ballVolumeNotEquals() {
        return new Object[][]{{5, 10}, {1, 1}, {30, 30}};
    }

    @Test(dataProvider = "ballVolumeNotEquals")
    public void testValidateBallVolumeNotEquals(int volume, int expectedResult) {
        int actual = validator.validateBallVolume(volume);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] ballWeightEquals() {
        return new Object[][]{{6, 6}, {0, 2}, {-4, 2}, {50, 2}};
    }

    @Test(dataProvider = "ballWeightEquals")
    public void testValidateBallWeightEquals(int weight, int expectedResult) {
        int actual = validator.validateBallWeight(weight);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] ballWeightNotEquals() {
        return new Object[][]{{7, 10}, {0, 0}, {20, 20}};
    }

    @Test(dataProvider = "ballWeightNotEquals")
    public void testValidateBallWeightNotEquals(int weight, int expectedResult) {
        int actual = validator.validateBallWeight(weight);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] ballColorEquals() {
        return new Object[][]{{null, Color.WHITE}, {Color.CYAN, Color.CYAN}, {Color.BLUE, Color.BLUE}};
    }

    @Test(dataProvider = "ballColorEquals")
    public void testValidateBallColorEquals(Color color, Color expectedResult) {
        Color actual = validator.validateBallColor(color);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] ballColorNotEquals() {
        return new Object[][]{{null, null}, {Color.CYAN, Color.WHITE}, {Color.BLUE, null}};
    }

    @Test(dataProvider = "ballColorNotEquals")
    public void testValidateBallColorNotEquals(Color color, Color expectedResult) {
        Color actual = validator.validateBallColor(color);
        assertNotEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] basketCapacityEquals() {
        return new Object[][]{{10, 20}, {50, 50}, {150, 20}, {-50, 20}};
    }

    @Test(dataProvider = "basketCapacityEquals")
    public void testValidateBasketCapacityEquals(int basketCapacity, int expectedResult) {
        int actual = validator.validateBasketCapacity(basketCapacity);
        assertEquals(expectedResult, actual);
    }

    @DataProvider
    public static Object[][] basketCapacityNotEquals() {
        return new Object[][]{{10, 10}, {50, 60}, {150, 150}, {-50, -50}};
    }

    @Test(dataProvider = "basketCapacityNotEquals")
    public void testValidateBasketCapacityNotEquals(int basketCapacity, int expectedResult) {
        int actual = validator.validateBasketCapacity(basketCapacity);
        assertNotEquals(expectedResult, actual);
    }

    @AfterClass
    public void afterClass() {
        validator = null;
    }
}