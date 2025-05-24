package com.elevator.elevatorDiscovery;

import com.elevator.Elevator;
import com.elevator.requests.ExternalRequest;

import java.util.List;

public interface ElevatorDiscovery {

    void discoverElevator(List<Elevator> elevators, int totalFloors, ExternalRequest externalRequest);

}
