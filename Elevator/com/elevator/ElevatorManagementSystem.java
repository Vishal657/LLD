package com.elevator;

import com.elevator.elevatorAlgorithms.SCANAlgorithm;
import com.elevator.elevatorDiscovery.ElevatorDiscovery;
import com.elevator.elevatorDiscovery.NearestElevator;
import com.elevator.requests.ExternalRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorManagementSystem {
    private List<Elevator> elevators;
    private int totalFloors;
    private ElevatorDiscovery elevatorDiscovery;
    private ExecutorService executor;

    public ElevatorManagementSystem(int numberOfElevators, int totalFloors) {
        elevators = new ArrayList<>();
        this.totalFloors = totalFloors;
        this.executor = Executors.newFixedThreadPool(numberOfElevators);

        for (int i = 0; i < numberOfElevators; i++) {
            Elevator elevator = new Elevator(totalFloors, i + 1, new SCANAlgorithm(), i);
            elevators.add(elevator);
            executor.execute(elevator); // Start elevator thread
        }

        this.elevatorDiscovery = new NearestElevator(elevators);
    }

    public void requestElevator(ExternalRequest externalRequest) {
        elevatorDiscovery.assignRequestToElevator(externalRequest);
    }

    public void shutdown() {
        executor.shutdownNow(); // Graceful shutdown
    }

    public List<Elevator> getAllElevators() {
        return elevators;
    }
}
