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
                        String buildingName = parts[2];
                        int floorNumber = Integer.valueOf(parts[3]);
                        String roomName = parts[4];
                        system.addConferenceRoom(buildingName, floorNumber, roomName);
                    }
                    break;
                }
                case "BOOK":
                    String[] hours = parts[1].split(":");
                    int startHour = Integer.valueOf(hours[0]);
                    int endHour = Integer.valueOf(hours[1]);
                    book(startHour, endHour, parts[2], parts[3], Integer.valueOf(parts[4]), parts[5]);
                    break;
               case "LIST":
                   switch(parts[1]){
                        case "ROOMS":
                            listRooms();
                            break;
                        case "BOOKINGS":

                   }

//                case "CANCEL":
//                    break;
                default:
                    System.out.println("Invalid Command");
            }

        }
    }

    private void book(int startHour, int endHour, String userName, String buildingName, int floorNumber, String roomName) {
        Building building = system.buildings.get(buildingName);
        if(building == null){
            System.out.println("Invalid building name");
            return;
        }
        Floor floor = building.getFloor(floorNumber);
        if (floor == null) {
            System.out.println("Invalid floor number");
            return;
        }
        ConferenceRoom room = floor.getConferenceRoom(roomName);
        if (room == null) {
            System.out.println("Invalid conference room");
            return;
        }
        room.addBooking(startHour, endHour, userName);
        System.out.println("Booked conference room " + roomName + " from " + startHour + " to " + endHour + " hour");
    }

    // private void addConferenceRoom(String buildingName, int floorNumber, String roomName) {
    //     system.addConferenceRoom(buildingName, floorNumber, roomName);
    //     System.out.println("Added conference room " + roomName +" in the " + floorNumber + " floor of building " + buildingName );
    // }

    private void addFloor(String buildingName, int floorNumber) {
        system.addFloor(buildingName, floorNumber);
    }

    private void addBuilding(String buildingName) {
        system.addBuilding(buildingName);
    }

    private void listRooms() {
        // for each building
        // for each floor
        // list all rooms
    }
}
