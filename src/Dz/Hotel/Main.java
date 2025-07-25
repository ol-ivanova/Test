package Dz.Hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();


        Room room1 = new Room(101, RoomType.SINGLE, 2000);
        Room room2 = new Room(102, RoomType.DOUBLE, 3000);
        Room room3 = new Room(103, RoomType.SINGLE, 2000);

        hotel.addRoom(room1);
        hotel.addRoom(room2);
        hotel.addRoom(room3);

        Client alice = new Client("Алиса");
        Client boris = new Client("Борис");


        LocalDate d1 = LocalDate.of(2025, 7, 20);
        LocalDate d2 = LocalDate.of(2025, 7, 25);
        LocalDate d3 = LocalDate.of(2025, 7, 23);
        LocalDate d4 = LocalDate.of(2025, 7, 28);


        hotel.bookRoom(room1, alice, d1, d2);
        hotel.bookRoom(room2, boris, d3, d4);

        System.out.println("Проверка доступности номера:");
        hotel.checkAvailability(room1, LocalDate.of(2025, 7, 21), LocalDate.of(2025, 7, 23));


        double a = hotel.calculateRevenue(LocalDate.of(2025, 7, 20), LocalDate.of(2025, 7, 30));
        System.out.println("Доход: " + a);


        RoomType roomType = hotel.popularRoomType();
        System.out.println("Тип: " + roomType);
    }
}
