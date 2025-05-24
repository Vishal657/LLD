package com.elevator;

import com.elevator.elevatorAlgorithms.SCANAlgorithm;
import com.elevator.elevatorDiscovery.ElevatorDiscovery;
import com.elevator.elevatorDiscovery.NearestElevator;
import com.elevator.requests.ExternalRequest;

import java.util.ArrayList;
import java.util.List;

public class ElevatorManagementSystem {
    private List<Elevator> elevators;
    int totalFloors;
    ElevatorDiscovery elevatorDiscovery;

    public ElevatorManagementSystem(int numberOfElevators, int totalFloors) {
        elevators = new ArrayList<>();
        this.totalFloors = totalFloors;

        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator(totalFloors, i + 1, new SCANAlgorithm(), i));
        }

        this.elevatorDiscovery = new NearestElevator(elevators);
    }

    public void requestElevator(ExternalRequest externalRequest) {
        elevatorDiscovery.assignRequestToElevator(externalRequest);
    }

}
