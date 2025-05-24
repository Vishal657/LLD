package com.elevator;

import com.elevator.requests.ExternalRequest;
import com.elevator.requests.InternalRequest;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystemDriver {

    public static void main(String[] args) {
        // Initialize elevators
        int totalFloors = 10;
        int totalElevators = 3;
        ElevatorManagementSystem elevatorSystem = new ElevatorManagementSystem(totalElevators, totalFloors);

        // Simulate external requests
        List<ExternalRequest> requests = new ArrayList<>();
        requests.add(new ExternalRequest(3, Direction.UP));
        requests.add(new ExternalRequest(7, Direction.DOWN));
        requests.add(new ExternalRequest(2, Direction.UP));
        requests.add(new ExternalRequest(9, Direction.DOWN));

        for (ExternalRequest request : requests) {
            elevatorSystem.requestElevator(request);
        }

        // OPTIONAL: Wait a bit to simulate passengers getting in
        try {
            Thread.sleep(1000); // simulate boarding time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Add some internal requests to elevators
        // For demonstration, we assume we can get elevators from the system
        List<Elevator> elevators = elevatorSystem.getAllElevators();    // not needed in reallity just adding this to simulate internal request

        // Let's assume passengers in each elevator press a few floor buttons
        elevators.get(1).addInternalRequest(new InternalRequest(1)); // Passenger in elevator 1 pressed floor 1
        elevators.get(2).addInternalRequest(new InternalRequest(8)); // Passenger in elevator 2 pressed floor 8

    }
}
