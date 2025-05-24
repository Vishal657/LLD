package com.elevator;

import com.elevator.elevatorAlgorithms.ElevatorAlgorithm;
import com.elevator.requests.ExternalRequest;
import com.elevator.requests.InternalRequest;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator implements Runnable {
    public int currentFloor;
    public int totalFloors;
    public Direction movingDirection;      // set to null if not moving
    public ElevatorState elevatorState;
    public ElevatorAlgorithm elevatorAlgorithm;
    public int id;

    private final Queue<ExternalRequest> externalRequests;
    private final Queue<Integer> internalRequests;
    private final Object lock = new Object();

    public Elevator(int totalFloors, int currentFloor, ElevatorAlgorithm elevatorAlgorithm, int id) {
        this.currentFloor = currentFloor;
        this.totalFloors = totalFloors;
        this.movingDirection = null;
        this.elevatorState = ElevatorState.IDLE;
        this.externalRequests = new LinkedList<>();
        this.internalRequests = new LinkedList<>();

        this.elevatorAlgorithm = elevatorAlgorithm;
        this.elevatorAlgorithm.setElevator(this);
        this.id = id;
    }

    public void addExternalRequest(ExternalRequest externalRequest) {
        synchronized (lock) {
            externalRequests.add(externalRequest);
            lock.notify(); // wake up thread if waiting
        }
    }

    public void addInternalRequest(InternalRequest internalRequest) {
        synchronized (lock) {
            internalRequests.add(internalRequest.destinationFloor);
            lock.notify(); // wake up thread if waiting
        }
    }

    private void handleRequestAdd(int floor) {
        elevatorAlgorithm.addRequest(floor);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                // Wait until any request is available
                while (externalRequests.isEmpty() && internalRequests.isEmpty()) {
                    try {
                        lock.wait(); // releases lock and waits for notify
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return; // exit if interrupted
                    }
                }

                // Handle external requests
                while (!externalRequests.isEmpty()) {
                    ExternalRequest req = externalRequests.poll();
                    System.out.println("Handling external request from floor: " + req.initializerFloor);
                    handleRequestAdd(req.initializerFloor);
                }

                // Handle internal requests
                while (!internalRequests.isEmpty()) {
                    Integer req = internalRequests.poll();
                    System.out.println("Handling internal request to floor: " + req);
                    handleRequestAdd(req);
                }
            }
        }
    }
}
