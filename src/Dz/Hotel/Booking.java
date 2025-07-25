package Dz.Hotel;

import java.time.LocalDate;

/**LocalDate — это класс из пакета java.time (введён в Java 8), предназначенный для работы с датами без времени.
 */
public class Booking {
    private Room room;
    private Client client;
    private LocalDate start;
    private LocalDate end;
    private BookingStatus status;

    public Booking(Room room, Client client, LocalDate start, LocalDate end) {
        this.room = room;
        this.client = client;
        this.start = start;
        this.end = end;
        this.status = BookingStatus.BOOKED;
    }


    public BookingStatus getStatus() {
        return status;
    }
    public Client getClient() {
        return client;
    }
    public Room getRoom() {
        return room;
    }
    public LocalDate getStart() {
        return start;
    }
    public LocalDate getEnd() {
        return end;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
