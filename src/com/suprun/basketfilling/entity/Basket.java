package com.suprun.basketfilling.entity;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

// class for basket
public class Basket implements Iterable<Ball>{

    // capacity refers to maximum sum of ball volumes that can be placed in basket
    private final int basketCapacity;
    private final List<Ball> containedBalls;

    public Basket(int basketCapacity) {
        this.basketCapacity = basketCapacity;
        this.containedBalls = new ArrayList<>();
    }

    public int getBasketCapacity() {
        return this.basketCapacity;
    }

    public List<Ball> getContainedBalls() {
        return Collections.unmodifiableList(containedBalls);
    }

    // method for current volume balls in bin
    public int getCurrentVolume(){
        int volume = 0;
        for (Ball ball: this.containedBalls){
            if (ball != null) {
                volume += ball.getVolume();
            }
        }
        return volume;
    }

    // method for checking free volume in basket for adding ball
    boolean ensureCapacity(Ball addedBall){
        return getCurrentVolume() + addedBall.getVolume() <= basketCapacity;
    }

    // method for adding ball to basket
    public boolean add(Ball ball){
        boolean isAdded = false;
        if (ball != null && ensureCapacity(ball)) {
            isAdded = this.containedBalls.add(ball);
        }
        return isAdded;
    }

    // method for adding collection of balls to basket, returns number of added balls
    public int addAll(Collection<Ball> ballCollection){
        boolean isAdded = true;
        int counter = 0;
        if (ballCollection == null) {
            System.out.println("Null collection of balls was received for adding to basket");
            return 0;
        }
        Iterator<Ball> iterator = ballCollection.iterator();
        while(isAdded && iterator.hasNext()) {
            isAdded = add(iterator.next());
            counter++;
        }
        return counter;
    }

    // method for removing ball from basket
    public boolean remove(Ball ball){
        return this.containedBalls.remove(ball);
    }

    // method for clearing basket
    public void clear(){
        this.containedBalls.clear();
    }

    // method for checking if ball is contained in basket
    public boolean contains(Ball ball){
        return this.containedBalls.contains(ball);
    }

    // method for checking if basket is empty
    public boolean isEmpty(){
        return this.containedBalls.isEmpty();
    }

    // method for receiving stream of balls in basket
    public Stream<Ball> stream(){
        return this.containedBalls.stream();
    }

    // method for receiving iterator for basket
    @Override
    public Iterator<Ball> iterator() {
        return this.containedBalls.iterator();
    }

    // method forEach for basket
    @Override
    public void forEach(Consumer<? super Ball> action) {
        this.containedBalls.forEach(action);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        if (this.basketCapacity != basket.basketCapacity) return false;
        return this.containedBalls.equals(basket.containedBalls);
    }

    @Override
    public int hashCode() {
        int hashCode = this.basketCapacity;
        hashCode = 31 * hashCode + this.containedBalls.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Basket {");
        stringBuilder.append("Basket capacity = ").append(this.basketCapacity);
        stringBuilder.append(", Balls = ").append(this.containedBalls);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}