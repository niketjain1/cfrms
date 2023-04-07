import java.util.List;

public class Booking {
    String userName;
    List<Slot> slots;

    public Booking(String userName, List<Slot> slots) {
        this.userName = userName;
        this.slots = slots;
    }
}
