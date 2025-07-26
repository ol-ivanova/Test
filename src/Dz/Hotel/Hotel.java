package Dz.Hotel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
    //1. ПРОВЕРКА ДОСТУПНОСТИ
    /** Информация к методу */

    // Метод .noneMatch(...):
    /** Метод .noneMatch(...) — это часть Stream API в Java, и он используется для проверки, что ни один элемент потока не соответствует условию.
     *    Синтаксис: stream.noneMatch(predicate)
     *    Возвращает true, если ни один элемент не удовлетворяет этому условиюю
     */
    public boolean checkAvailability(Room room, LocalDate from, LocalDate to) {
        boolean available = bookings.stream()
                .filter(b -> b.getRoom().equals(room))
                .noneMatch(b -> !(to.isBefore(b.getStart()) || from.isAfter(b.getEnd())));

        if (available) {
            System.out.println("Номер доступен");
        } else {
            System.out.println("Номер занят");
        }

        return available;
    }
    //бронирование
    /** Информация к методу calculateRevenue: */

    // Метод .equalsIgnoreCase:
    /** Метод .equalsIgnoreCase(String anotherString) используется в Java для сравнения двух строк без учёта регистра.
     */
    public void bookRoom(Room room, Client client, LocalDate from, LocalDate to) {
        if (checkAvailability(room, from, to)) {
            System.out.println("Подтверждаете заявку на бронь? (да/нет)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("да")) {
                bookings.add(new Booking(room, client, from, to));
                System.out.println("Номер забронирован");
            } else {
                System.out.println("Номер не забронирован");
            }
        }
    }

    //2. ВСЕ БРОНИРОВАНИЯ КЛИЕНТА
    public List<Booking> getBookingsByClient(Client client) {
        return bookings.stream()
                .filter(b -> b.getClient().equals(client))
                .collect(Collectors.toList());
    }

    //3. ОБЩИЙ ДОХОД
    /** Информация к методу calculateRevenue: */

     // Метод .filter(...) в Java Stream API:
     /** 1. принимает условие (булевое выражение) для каждого элемента;
     *  2. оставляет элемент в потоке, если условие возвращает true;
     *  3. исключает, если false.
     */
     //  Метод mapToDouble(...)
     /** mapToDouble(...) - метод в Java Stream API, который преобразует каждый элемент потока в double, и возвращает специальный числовой поток — DoubleStream
     *   Зачем нужен:
     *   1. выполнить числовые операции (например: .sum(), .average(), .min() и т.д.).
     *   2. перейти от объектов к числам.
     *   Когда использовать: Когда нужен числовой результат по объектам
     */
     // Тернарный оператор
     /** Тернарный оператор — это короткая форма if...else, которая возвращает одно из двух значений в зависимости от условия.
     *    "?" - если, ":" - иначе
     *    Синтаксис: условие ? значение_если_true : значение_если_false;
     *    Что означает: Если условие истинно (true), то использовать значение_если_true, иначе — значение_если_false.
     */
     //Метод isAfter(...)
    /** В Java метод isAfter(...) — это метод класса LocalDate (и также LocalDateTime, LocalTime), который используется для сравнения дат.
     *   Синтаксис: date1.isAfter(date2)
     *   Что означает: Возвращает true, если date1 происходит позже date2.
     */
    //Метод isBefore(...)
     /** В Java метод isBefore(...) — это метод класса LocalDate, который используется для сравнения дат.
     *   !Синтаксис:  date1.isBefore(date2) !
     *   Что означает: Возвращает true, если date1 раньше date2.
     */
     //ChronoUnit
     /** ChronoUnit — это enum (перечисление), который определяет единицы измерения времени: дни, часы, минуты, месяцы и т.д.
     *    Назначение: Позволяет измерять разницу между двумя моментами времени (датами, временем) в нужной единице.
     * ChronoUnit.DAYS
     *    Это специальный элемент enum-а ChronoUnit, который представляет единицу измерения времени — в данном случае, дни.
     * Метод .between(...)
     *    Возвращает количество целых единиц времени (в нашем случае — дней) между двумя датами/временами.
     */
     //Метод .sum()
     /** Метод .sum() - Это терминальный метод числового стрима (IntStream, LongStream, DoubleStream), который:
     *    суммирует все элементы потока, и возвращает общее значение.
     *    В нашем слчучае:
     *    > mapToDouble(...) создаёт DoubleStream.
     *    > sum() пробегает по всем значениям этого потока и возвращает сумму.
     */
    public double calculateRevenue(LocalDate from, LocalDate to) {
        System.out.println("");
        System.out.println("feat3");
        return bookings.stream()
                .filter(b -> b.getStatus() == BookingStatus.BOOKED)
                .filter(b -> !(b.getEnd().isBefore(from) || b.getStart().isAfter(to)))
                .mapToDouble(b -> {
                    LocalDate start1 = b.getStart().isAfter(from) ? b.getStart() : from;
                    LocalDate end1 = b.getEnd().isBefore(to) ? b.getEnd() : to;
                    long days = ChronoUnit.DAYS.between(start1, end1);
                    return days > 0 ? b.getRoom().getPrice() * days : 0.0;
                })
                .sum();
    }

    // 5. САМЫЙ ПОПУЛЯРНЫЙ ТИП НОМЕРА (ПО КОЛИЧЕСТВУ БРОНИРОВАНИЙ)
    /** Информация к методу getMostPopularRoomType: */

    // Метод .collect(Collectors.groupingBy(...))
    /** Группирует элементы потока по какому-либо признаку (ключу) и собирает их в Map<ключ, список/счётчик/другое>
     *   Структура: .stream()
     *                .collect(Collectors.groupingBy(
     *                    ключГруппировки,     // Function<T, K>
     *                    downstreamCollector  // Что делать с элементами группы
     *   ));
     *   ключГруппировки — по какому признаку группировать.
     *   downstreamCollector (необязательный) — как обрабатывать элементы внутри группы.
     * Collectors.counting() - это встроенный счётчик в Java Stream API.
     *    Он используется внутри groupingBy(...), чтобы посчитать количество элементов в каждой группе.
     */
    // Метод .entrySet().stream()
    /** Оно обычно используется после группировки или работы с Map, чтобы перейти от Map к потоку его записей (Map.Entry), и работать с ними как со стримом.
     *   Метод entrySet() вызывается у объекта Map<K, V>.
     *   Возвращает набор пар ключ-значение — Set<Map.Entry<K, V>>.
     */
    // Метод .max(Map.Entry.comparingByValue())
    /** Это выражение находит элемент с максимальным значением из Map
     *   Используется в потоке Stream<Map.Entry<K, V>> — т.е. когда мы перебираем пары "ключ–значение" (например, RoomType → количество бронирований), и хотим найти ту, у которой значение самое большое.
     *   Map.Entry.comparingByKey() - сравнивает по ключу
     *   Map.Entry.comparingByValue() - сравнивает по значению
     */
    // Метод .map(Map.Entry::getKey)
    /** Это метод-ссылка (method reference), который:
     *    Преобразует каждый элемент потока типа Map.Entry<K, V> → в его ключ (K). В нашем случае ключ - тип номера
     *    В Java метод-ссылка — это короткая запись для вызова метода, аналогичная лямбда-выражению.
     *      Общая форма:
     *        1. ClassName::methodName - Вызов метода у объекта
     *        2. object::methodName - Вызов метода у конкретного экземпляра
     *        3. ClassName::new - Вызов конструктора
     *
     */
    // Метод .orElse(...)
    /** Это метод из класса Optional<T> — ключевого инструмента в Java для безопасной работы с "пустыми" значениями.
     *    Что делает: Возвращает значение, если оно присутствует, иначе — возвращает значение по умолчанию, переданное в orElse(...).
     *    .orElse(null) - явное указание, что если Optional пустой — верни null, иначе — верни то, что внутри.
     */

    public RoomType popularRoomType() {
        return bookings.stream()
                .filter(b -> b.getStatus() == BookingStatus.BOOKED)
                .collect(Collectors.groupingBy(b -> b.getRoom().getType(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
