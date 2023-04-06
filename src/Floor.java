import java.util.ArrayList;
import java.util.List;

public class Floor {
    int number;
    List<ConferenceRoom> conferenceRooms;

    public Floor(int number) {
        this.number = number;
        this.conferenceRooms = new ArrayList<>();
    }

    public void addConferenceRoom(ConferenceRoom room){
        conferenceRooms.add(room);
    }
    public ConferenceRoom getConferenceRoom(String roomName){
        for(ConferenceRoom room : conferenceRooms){
            if(room.name.equals(roomName)){
                return room;
            }
        }
        return null;
    }
}
