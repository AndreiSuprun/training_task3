package com.suprun.basketfilling.validator;

import com.suprun.basketfilling.entity.Ball;

// class is used for ball and basket creation input parameters validation
public class Validator {

    private static final int MIN_BASKET_CAPACITY = 20;
    private static final int DEFAULT_BASKET_CAPACITY = MIN_BASKET_CAPACITY;
    private static final int MAX_BASKET_CAPACITY = 100;
    private static final int MIN_BALL_VOLUME = 2;
    private static final int DEFAULT_BALL_VOLUME = MIN_BALL_VOLUME;
    private static final int MAX_BALL_VOLUME = 10;
    private static final int MIN_BALL_WEIGHT = 2;
    private static final int DEFAULT_BALL_WEIGHT = MIN_BALL_WEIGHT;
    private static final int MAX_BALL_WEIGHT = 10;
    private static final Ball.Color DEFAULT_BALL_COLOR = Ball.Color.WHITE;

    // method for ball volume parameter validation
    public int validateBallVolume(int volume){
        if (volume > Validator.MAX_BALL_VOLUME || volume < Validator.MIN_BALL_VOLUME){
            System.out.printf("Specified value for bin volume is %d%nPermissible values for volume are in range" +
                            " from %s to %s%nBall with default volume value %s will be created%n",
                    volume, Validator.MIN_BALL_VOLUME, Validator.MAX_BALL_VOLUME, Validator.DEFAULT_BALL_VOLUME);
            return DEFAULT_BALL_VOLUME;
        }
        return volume;
    }

    // method for ball weight parameter validation
    public int validateBallWeight(int weight){
        if (weight > Validator.MAX_BALL_WEIGHT || weight < Validator.MIN_BALL_WEIGHT){
            System.out.printf("Specified value for bin weight is %d%nPermissible values for weight are in range" +
                    " from %s to %s%nBall with default weight value %s will be created%n",
                    weight, Validator.MIN_BALL_WEIGHT, Validator.MAX_BALL_WEIGHT, Validator.DEFAULT_BALL_WEIGHT);
            return DEFAULT_BALL_WEIGHT;
        }
        return weight;
    }

    // method for ball color parameter validation
    public Ball.Color validateBallColor(Ball.Color color){
        if (color == null){
            System.out.printf("Don't set value for ball color%nBall with default color %s will be created%n",
                    Validator.DEFAULT_BALL_COLOR);
            return DEFAULT_BALL_COLOR;
        }
        return color;
    }

    // method for basket capacity parameter validation
    public int validateBasketCapacity(int capacity){
        if (capacity > Validator.MAX_BASKET_CAPACITY || capacity < Validator.MIN_BASKET_CAPACITY){
            System.out.printf("Specified value for basket capacity is %d%nPermissible values for basket capacity are in range" +
                            " from %s to %s%nBasket with default capacity %s will be created%n",
                    capacity, Validator.MIN_BASKET_CAPACITY, Validator.MAX_BASKET_CAPACITY, Validator.DEFAULT_BASKET_CAPACITY);
            return DEFAULT_BASKET_CAPACITY;
        }
        return capacity;
    }
}
