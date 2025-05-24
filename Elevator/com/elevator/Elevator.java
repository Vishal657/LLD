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
    public int id;

    public Elevator(int totalFloors, int currentFloor, ElevatorAlgorithm elevatorAlgorithm, int id) {
        this.currentFloor = currentFloor;
        this.totalFloors = totalFloors;
        this.movingDirection = null;
        this.elevatorState = ElevatorState.IDLE;

        this.elevatorAlgorithm = elevatorAlgorithm;
        elevatorAlgorithm.setElevator(this);
        this.id = id;
    }

    public void addExternalRequest(ExternalRequest externalRequest) {
        handleRequestAdd(externalRequest.initializerFloor);
    }

    public void addInternalRequest(InternalRequest internalRequest) {
        handleRequestAdd(internalRequest.destinationFloor);
    }

    void handleRequestAdd(int floor) {
        elevatorAlgorithm.addRequest(floor);
    }

}
