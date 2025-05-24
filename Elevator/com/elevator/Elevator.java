package com.elevator;

import com.elevator.elevatorAlgorithms.ElevatorAlgorithm;
import com.elevator.requests.ExternalRequest;
import com.elevator.requests.InternalRequest;

import java.util.HashSet;
import java.util.Set;

public class Elevator {
    public int currentFloor;
    public int totalFloors;
    public Direction movingDirection;      // set to null if not moving
    public ElevatorState elevatorState;
    public ElevatorAlgorithm elevatorAlgorithm;

//    public Set<InternalRequest> internalRequests;
//    public Set<ExternalRequest> externalRequests;

    public Elevator(int totalFloors, int currentFloor, ElevatorAlgorithm elevatorAlgorithm) {
        this.currentFloor = currentFloor;
        this.totalFloors = totalFloors;
        this.movingDirection = null;
        this.elevatorState = ElevatorState.IDLE;

        this.elevatorAlgorithm = elevatorAlgorithm;
    }

    void addExternalRequest(ExternalRequest externalRequest) {
        handleRequestAdd(externalRequest.initializerFloor);
    }

    void addInternalRequest(InternalRequest internalRequest) {
        handleRequestAdd(internalRequest.destinationFloor);
    }

    void handleRequestAdd(int floor) {
        elevatorAlgorithm.addRequest(floor);
    }

}
