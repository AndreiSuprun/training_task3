package com.suprun.basketfilling.creator;

import com.suprun.basketfilling.entity.Basket;
import com.suprun.basketfilling.entity.Ball;
import com.suprun.basketfilling.validator.Validator;

import java.util.ArrayList;
import java.util.List;

// Class is used for creation balls, baskets and filling baskets with balls
public class Creator {

    private Validator validator = new Validator();

    // method is used for ball creation with input parameters validation
    public Ball createBall(int volume, int weight, Ball.Color color){
        int validatedVolume = validator.validateBallVolume(volume);
        int validatedWeight = validator.validateBallWeight(weight);
        Ball.Color validatedColor = validator.validateBallColor(color);
        return new Ball(validatedVolume, validatedWeight, validatedColor);
    }

    // method is used for basket creation with input parameter validation
    public Basket createBasket(int capacity){
        int validatedCapacity = validator.validateBasketCapacity(capacity);
        return new Basket(validatedCapacity);
    }

    // method is used for filling basket with balls and return number of added balls
    public int fillBasket(Basket basket){
        if (basket == null){
            System.out.println("Null basket was received for filling");
            return 0;
        }
        List<Ball> list = new ArrayList<>();
        list.add(createBall(3, 3, Ball.Color.BLUE));
        list.add(createBall(6, 7, Ball.Color.GRAY));
        list.add(createBall(7, 5, Ball.Color.BLUE));
        list.add(createBall(2, 6, Ball.Color.MAGENTA));
        list.add(createBall(4, 7, Ball.Color.CYAN));
        list.add(createBall(2, 3, Ball.Color.GRAY));
        list.add(createBall(4, 2, Ball.Color.BLUE));
        list.add(createBall(5, 4, Ball.Color.MAGENTA));
        list.add(createBall(8, 6, Ball.Color.WHITE));
        list.add(createBall(9, 9, Ball.Color.GREEN));
        list.add(createBall(9, 7, Ball.Color.GRAY));
        list.add(createBall(7, 5, Ball.Color.BLUE));
        list.add(createBall(3, 4, Ball.Color.BLACK));
        list.add(createBall(7, 6, Ball.Color.YELLOW));
        list.add(createBall(4, 8, Ball.Color.CYAN));
        list.add(createBall(8, 5, Ball.Color.BLUE));
        list.add(createBall(7, 9, Ball.Color.WHITE));
        list.add(createBall(4, 6, Ball.Color.RED));
        list.add(createBall(7, 8, Ball.Color.GREEN));
        list.add(createBall(5, 4, Ball.Color.CYAN));
        int count = basket.addAll(list);
        return count;
    }
}