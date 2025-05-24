package com.elevator.elevatorAlgorithms;

import com.elevator.Elevator;

public interface ElevatorAlgorithm {

    void addRequest(int floor);

    void fullFillRequests();

    void setElevator(Elevator elevator);
}
