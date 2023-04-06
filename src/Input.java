import java.util.Scanner;

public class Input {
    ConferenceRoomManagement system;
    Scanner sc;

    public Input() {
        this.system = new ConferenceRoomManagement();
        this.sc = new Scanner(System.in);
    }

    public void run(){
        while(true){
//            System.out.println("Enter Command: ");
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]){
                case "ADD": {
                    if (parts[1].equals("BUILDING")) {
                        addBuilding(parts[2]);
                    } else if (parts[1].equals("FLOOR")) {
                        addFloor(parts[2], Integer.valueOf(parts[3]));
                    } else if (parts[1].equals("CONFROOM")) {
                        addConferenceRoom(parts[2], Integer.valueOf(parts[3]), parts[4]);
                    }
                    break;
                }
                case "BOOK":
                    String[] hours = parts[1].split(":");
                    int startHour = Integer.valueOf(hours[0]);
                    int endHour = Integer.valueOf(hours[1]);
                    book(startHour, endHour, parts[2], parts[3], Integer.valueOf(parts[4]), parts[5]);
                    break;
//                case "LIST":
//                    break;
//                case "CANCEL":
//                    break;
                default:
                    System.out.println("Invalid Command");
            }

        }
    }

    private void book(int startHour, int endHour, String name, String buildingName, int floorNumber, String roomName) {
        Building building = system.buildings.get(buildingName);
        if(building != null){
            Floor floor = building.getFloor(floorNumber);
            if(floor != null){
                ConferenceRoom room = floor.getConferenceRoom(roomName);
                if(room != null){
                        room.addBooking(startHour, endHour, name);
                        System.out.println("Booked conference room " + roomName + " from " + startHour + " to " + endHour + " hour");
                }else{
                    System.out.println("Invalid conference room");
                }
            }else{
                System.out.println("Invalid floor number");
            }
        }else{
            System.out.println("Invalid building name");
        }
    }

    private void addConferenceRoom(String buildingName, int floorNumber, String roomName) {
        system.addConferenceRoom(buildingName, floorNumber, roomName);
        System.out.println("Added conference room " + roomName +" in the " + floorNumber + " floor of building " + buildingName );
    }

    private void addFloor(String buildingName, int floorNumber) {
        system.addFloor(buildingName, floorNumber);
        System.out.println("Added floor " + floorNumber +" in the building " + buildingName);
    }

    private void addBuilding(String buildingName) {
        system.addBuilding(buildingName);
        System.out.println("Added building " + buildingName +" into the system");
    }
}
