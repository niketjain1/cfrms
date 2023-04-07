import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConferenceRoom {
    String name;
    // slots go from 0 to 23
    List<Slot> slots;
    List<Booking> bookings;
    // Map<Integer, Booking> bookings;

    public ConferenceRoom(String name){
        this.name = name;
        bookings = new ArrayList<>();
    }

    public void addBooking(int startHour, int endHour, String userName){
        List<Slot> bookingSlots = new ArrayList<>();
        for(int i = startHour; i <= endHour; i++){
            Slot slot = slots.get(i);
            if(slot.isAvailable == false){
                System.out.println("Slot not available");
                return;
            }
            bookingSlots.add(slot);
        }
        bookings.add(new Booking(userName, bookingSlots));
    }
    public void cancelBooking(int startHour, int endHour, String roomName){

    }
    public List<Booking> getBookings(){
        return bookings;
    }

    public List<Slot> getAvailableSlots(){
        List<Slot> availableSlots = new ArrayList<>();
        for(Slot slot: slots){
            if(slot.isAvailable){
                availableSlots.add(slot);
            }
        }
        return availableSlots;
    }
}

// 1-5 booking c1 -> CANCEL c1 1