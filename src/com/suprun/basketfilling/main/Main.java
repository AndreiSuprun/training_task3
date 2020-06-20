package com.suprun.basketfilling.main;

import com.suprun.basketfilling.entity.Basket;
import com.suprun.basketfilling.creator.Creator;
import com.suprun.basketfilling.entity.Ball;
import com.suprun.basketfilling.service.BasketService;

public class Main {

    public static void main(String[] args) {
        BasketService basketService = new BasketService();
        Creator creator = new Creator();
        Basket basket = creator.createBasket(100);
        int count = creator.fillBasket(basket);
        System.out.printf("Balls weight in basket is %d, balls volume is %d and blue balls number is %d from %d " +
                        "balls in basket%n",
                basketService.calculateBallsWeight(basket),
                basketService.calculateSumStream(basket, Ball::getVolume),
                basketService.calculateSpecifiedColorBalls(basket, Ball.Color.BLUE),
                count);
    }
}
