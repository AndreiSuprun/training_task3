package com.suprun.basketfilling.service;

import com.suprun.basketfilling.creator.Creator;
import com.suprun.basketfilling.entity.Ball;
import com.suprun.basketfilling.entity.Basket;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketServiceTest {

    BasketService basketService;
    Creator creator;

    @BeforeClass
    public void beforeClass() {
        basketService = new BasketService();
        creator = new Creator();
    }

    @Test
    public void testCalculateBallsWeightEquals() {
        Basket basket = creator.createBasket(30);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateBallsWeight(basket);
        assertEquals(33, actual);
    }

    @Test
    public void testCalculateBallsWeightNotEquals() {
        Basket basket = creator.createBasket(30);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateBallsWeight(basket);
        assertNotEquals(30, actual);
    }

    @Test
    public void testCalculateSpecifiedColorBallsEquals() {
        Basket basket = creator.createBasket(50);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateSpecifiedColorBalls(basket, Ball.Color.BLUE);
        assertEquals(3, actual);
    }

    @Test
    public void testCalculateSpecifiedColorBallsNotEquals() {
        Basket basket = creator.createBasket(50);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateSpecifiedColorBalls(basket, Ball.Color.BLUE);
        assertNotEquals(5, actual);
    }

    @Test
    public void testCalculateSumStreamEquals() {
        Basket basket = creator.createBasket(100);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateSumStream(basket, Ball::getVolume);
        assertEquals(99, actual);
    }

    @Test
    public void testCalculateSumStreamNotEquals() {
        Basket basket = creator.createBasket(100);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateSumStream(basket, Ball::getVolume);
        assertNotEquals(100, actual);
    }

    @Test
    public void testCalculateCounterStreamEquals() {
        Basket basket = creator.createBasket(100);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateCounterStream(basket, ball -> ball.getColor() == Ball.Color.BLUE);
        assertEquals(5, actual);
    }

    @Test
    public void testCalculateCounterStreamNotEquals() {
        Basket basket = creator.createBasket(100);
        int count = creator.fillBasket(basket);
        int actual = basketService.calculateCounterStream(basket, ball -> ball.getColor() == Ball.Color.BLUE);
        assertNotEquals(6, actual);
    }

    @AfterClass
    public void afterClass() {
        creator = null;
        basketService = null;
    }
}