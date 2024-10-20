import java.util.*;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean isBooked;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isBooked = false;
    }
}

class Hotel {
    List<Room> rooms = new ArrayList<>();
    Map<Integer, String> bookings = new HashMap<>();

    Hotel() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Double", 150));
        rooms.add(new Room(103, "Suite", 300));
    }

    void searchRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room " + room.roomNumber + " - " + room.category + " - $" + room.price);
            }
        }
    }

    void bookRoom(int roomNumber, String guestName) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.isBooked) {
                room.isBooked = true;
                bookings.put(roomNumber, guestName);
                System.out.println("Room " + roomNumber + " is booked successfully for " + guestName);
                return;
            }
        }
        System.out.println("Room not available or already booked.");
    }

    void viewBooking(int roomNumber) {
        if (bookings.containsKey(roomNumber)) {
            System.out.println("Room " + roomNumber + " is booked by " + bookings.get(roomNumber));
        } else {
            System.out.println("No booking found for room " + roomNumber);
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.print("Welcome to Hotel Reservation System.");
            System.out.println("\n1. Search Rooms\n2. Book Room\n3. View Booking\n4. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                hotel.searchRooms();
            } else if (choice == 2) {
                System.out.println("Enter room number and guest name to book:");
                int roomNumber = sc.nextInt();
                String guestName = sc.next();
                hotel.bookRoom(roomNumber, guestName);
            } else if (choice == 3) {
                System.out.println("Enter room number to view booking:");
                int roomNumber = sc.nextInt();
                hotel.viewBooking(roomNumber);
            } else if (choice == 4) {
                break;
            }
        }
        sc.close();
    }
}
