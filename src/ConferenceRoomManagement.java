import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConferenceRoomManagement {
    Map<String, Building> buildings;

    public ConferenceRoomManagement(){
        this.buildings = new HashMap<>();
    }

    public void addBuilding(String buildingName){
        Building b = buildings.get(buildingName);
        if(b != null){
            System.out.println("Building already exists");
            return;
        }
        buildings.put(buildingName, new Building(buildingName));
        System.out.println("Added building " + buildingName +" into the system");
    }

    public void addFloor(String buildingName , int floorNumber){
        Building b = buildings.get(buildingName);
        if(b != null){
            b.addFloor(new Floor(floorNumber));
            System.out.println("Added floor " + floorNumber +" in the building " + buildingName);
        } else {
            System.out.println("Building not found");
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
                        System.out.println("Added conference room " + roomName +" in the " + floorNumber + " floor of building " + buildingName );
                    }
                }
            }
        }
    }

    public List<Building> getBuidings(){
        return buildings;
    }
}
