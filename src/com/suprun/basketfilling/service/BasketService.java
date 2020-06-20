package com.suprun.basketfilling.service;

import com.suprun.basketfilling.entity.Basket;
import com.suprun.basketfilling.entity.Ball;

import java.util.function.Predicate;
import java.util.function.ToIntFunction;

// Class is used for calculation basket characteristics
public class BasketService {

    // predicate for non null checking
    private static final Predicate<Ball> NON_NULL = ball -> ball!=null;

    // method for calculation balls weight in basket
    public int calculateBallsWeight(Basket basket){
        int weight = 0;
        if (basket == null){
            System.out.println("Null basket was received for calculating balls weight");
            return weight;
        }
        for (Ball ball : basket){
            if (ball != null) {
                weight += ball.getWeight();
            }
        }
        return weight;
    }

    // method for counting balls of specified color in basket
    public int calculateSpecifiedColorBalls(Basket basket, Ball.Color color) {
        int counter = 0;
        if (basket == null){
            System.out.println("Null basket was received for calculating specified color balls number");
            return counter;
        }
        for (Ball ball : basket) {
            if (ball != null && ball.getColor() == color) {
                counter++;
            }
        }
        return counter;
    }

    // method for calculation sum of specified parameter of basket (volume, weight)
    public int calculateSumStream(Basket basket, ToIntFunction<? super Ball> function){
        if (basket == null){
            System.out.println("Null basket was received for calculating sum of specified parameter");
            return 0;
        }
        return basket.stream().filter(NON_NULL).mapToInt(function).sum();
    }

    // method for calculation number of balls for specified condition
    public int calculateCounterStream(Basket basket, Predicate<Ball> predicate){
        if (basket == null){
            System.out.println("Null basket was received for calculating number of balls for specified condition");
            return 0;
        }
        return (int) basket.stream().filter(NON_NULL.and(predicate)).count();
    }
}