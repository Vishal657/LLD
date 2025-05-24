package com.elevator.elevatorDiscovery;

import com.elevator.Direction;
import com.elevator.Elevator;
import com.elevator.ElevatorState;
import com.elevator.requests.ExternalRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NearestElevator implements ElevatorDiscovery {

    private List<Elevator> elevators;

    public NearestElevator(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    @Override
    public void findElevator(ExternalRequest externalRequest) {
        Elevator nearestElevator = findNearestElevator(externalRequest.initializerFloor, externalRequest.direction);
        if (nearestElevator != null) {
            nearestElevator.addExternalRequest(externalRequest);
        }
    }
    
    public Elevator findNearestElevator(int requestFloor, Direction direction) {
        Elevator nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.elevatorState == ElevatorState.IDLE || elevator.movingDirection == direction) {
                int distance = Math.abs(elevator.currentFloor - requestFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestElevator = elevator;
                }
            }
        }

        // fallback: assign to any nearest elevator, regardless of direction
        if (nearestElevator == null) {
            for (Elevator elevator : elevators) {
                int distance = Math.abs(elevator.currentFloor - requestFloor);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestElevator = elevator;
                }
            }
        }

        return nearestElevator;
    }
}
