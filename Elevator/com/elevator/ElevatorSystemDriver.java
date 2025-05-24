package com.elevator;

import com.elevator.elevatorAlgorithms.SCANAlgorithm;
import com.elevator.elevatorDiscovery.NearestElevator;
import com.elevator.requests.ExternalRequest;

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

        // Process each request
        for (ExternalRequest request : requests) {
            elevatorSystem.requestElevator(request);
        }

        // Simulate elevators fulfilling their requests
//        for (Elevator elevator : elevators) {
//            elevator.processRequests();
//        }
    }


}
