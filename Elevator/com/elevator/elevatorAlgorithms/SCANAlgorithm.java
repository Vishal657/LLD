package com.elevator.elevatorAlgorithms;

import com.elevator.Direction;
import com.elevator.Elevator;
import com.elevator.ElevatorState;

import java.util.PriorityQueue;
import java.util.Stack;

public class SCANAlgorithm implements ElevatorAlgorithm{

    PriorityQueue<Integer> minQueue;        // handle when elevator is moving up
    PriorityQueue<Integer> maxQueue;        // handle when elevator is moving down
    Stack<Integer> pendingRequests;
    Elevator elevator;
    final Object lock = new Object();

    public SCANAlgorithm() {
        this.minQueue = new PriorityQueue<>();
        this.maxQueue = new PriorityQueue<>((a, b) -> b - a);
        this.pendingRequests = new Stack<>();
    };

    @Override
    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public void addRequest(int floor) {
        synchronized (lock) {
            if (elevator.currentFloor > floor && elevator.movingDirection == Direction.UP
                    || elevator.currentFloor < floor && elevator.movingDirection == Direction.DOWN) {
                pendingRequests.add(floor);
            } else if (floor >= elevator.currentFloor && (elevator.elevatorState == ElevatorState.IDLE || elevator.movingDirection == Direction.UP)) {
                minQueue.add(floor);
            } else if (floor <= elevator.currentFloor && (elevator.elevatorState == ElevatorState.IDLE || elevator.movingDirection == Direction.DOWN)) {
                maxQueue.add(floor);
            }
            fullFillRequests();
        }
    }

    private void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {}
    }

    public void fullFillRequests() {
        synchronized (lock) {
            while (!minQueue.isEmpty() || !maxQueue.isEmpty() || !pendingRequests.isEmpty()) {
                if(elevator.elevatorState == ElevatorState.IDLE) {
                    elevator.elevatorState = ElevatorState.MOVING;
                }
                while (!minQueue.isEmpty()) {
                    elevator.movingDirection = Direction.UP;
                    elevator.elevatorState = ElevatorState.IDLE;
                    sleep(500);
                    System.out.println("Full filling request of floor: " + minQueue.poll() + " by elevator Id: " + elevator.id + " Direction: UP");
                    elevator.elevatorState = ElevatorState.MOVING;
                }
                if (!pendingRequests.isEmpty()) {
                    maxQueue.addAll(pendingRequests);
                }
                while (!maxQueue.isEmpty()) {
                    elevator.elevatorState = ElevatorState.IDLE;
                    sleep(500);
                    System.out.println("Full filling request of floor: " + maxQueue.poll() + " by elevator Id: " + elevator.id + " Direction: DOWN");
                    elevator.elevatorState = ElevatorState.MOVING;
                }
                if (!pendingRequests.isEmpty()) {
                    minQueue.addAll(pendingRequests);
                }
            }
            elevator.movingDirection = null;
            elevator.elevatorState = ElevatorState.IDLE;
        }
    }

}
