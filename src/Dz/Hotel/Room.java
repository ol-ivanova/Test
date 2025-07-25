package Dz.Hotel;

public class Room {
    private int number;
    private RoomType type;
    private double price;

    public Room(int number, RoomType type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }
    public RoomType getType() {
        return type;
    }
    public double getPrice() {
        return price;
    }
}
