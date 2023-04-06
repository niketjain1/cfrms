import java.util.ArrayList;
import java.util.List;

public class Building {
    String name;
    List<Floor> floors;

    public Building(String name){
        this.name = name;
        this.floors = new ArrayList<>();
    }

    public void addFloor(Floor floor){
        floors.add(floor);
    }
    public Floor getFloor(int floorNumber){
        for(Floor floor1 : floors){
            if(floor1.number == floorNumber){
                return floor1;
            }
        }
        return null;
    }

}
