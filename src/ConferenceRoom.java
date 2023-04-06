import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConferenceRoom {
    String name;
    Map<Integer, Booking> bookings;

    public ConferenceRoom(String name){
        this.name = name;
        bookings = new HashMap<>();
    }

    public void addBooking(int startHour, int endHour, String name){
        for(int i = startHour; i <= endHour; i++){
            bookings.put(i, new Booking(name));
        }
    }
    public void cancelBooking(int startHour, int endHour, String roomName){

    }
    public List<Booking> getBookingSlots(){
        List<Booking> result = new ArrayList<>();
        for(Booking booking : bookings.values()){
            result.add(booking);
        }
        return result;
    }
}
