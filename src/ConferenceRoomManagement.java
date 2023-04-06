import java.util.HashMap;
import java.util.Map;

public class ConferenceRoomManagement {
    Map<String, Building> buildings;

    public ConferenceRoomManagement(){
        this.buildings = new HashMap<>();
    }

    public void addBuilding(String buildingName){
        buildings.put(buildingName, new Building(buildingName));
    }
    public void addFloor(String buildingName , int floorNumber){
        for(Building building: buildings.values()){
            if(building.name.equals(buildingName)){
                Building building1 = building;
                if(building1 != null) {
                    building1.addFloor(new Floor(floorNumber));
                }
            }
        }
    }

    public void addConferenceRoom(String buildingName, int floorNumber, String roomName){
        for(Building building: buildings.values()){
            if(building.name.equals(buildingName)){
                Building building1 = building;
                if(building1 != null) {
                    Floor floor = building1.getFloor(floorNumber);
                    if (floor != null) {
                        floor.addConferenceRoom(new ConferenceRoom(roomName));
                    }
                }
            }
        }
    }
}
