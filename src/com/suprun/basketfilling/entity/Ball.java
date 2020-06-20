package com.suprun.basketfilling.entity;

// entity class for ball
public class Ball {

    private int volume;
    private int weight;
    private Color color;

    public Ball(int volume, int weight, Color color) {
        this.volume = volume;
        this.weight = weight;
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public enum Color {
        YELLOW("yellow"), RED("red"), GREEN("green"), BLUE("blue"), GRAY("green"), CYAN("cyan"), BLACK("black"),
        MAGENTA("magenta"), WHITE("white");

        private final String name;

        Color(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        if (this.volume != ball.volume) return false;
        if (this.weight != ball.weight) return false;
        return this.color == ball.color;
    }

    @Override
    public int hashCode() {
        int hashCode = volume;
        hashCode = 31 * hashCode + weight;
        hashCode = 31 * hashCode + (color != null ? color.hashCode() : 0);
        return hashCode;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("Ball {");
        stringBuilder.append("volume = ").append(volume);
        stringBuilder.append(", weight = ").append(weight);
        stringBuilder.append(", color = ").append(color);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
