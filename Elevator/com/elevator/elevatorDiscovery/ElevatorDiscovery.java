package com.elevator.elevatorDiscovery;

import com.elevator.Direction;
import com.elevator.Elevator;
import com.elevator.requests.ExternalRequest;

import java.util.List;

public interface ElevatorDiscovery {

    void findElevator(ExternalRequest externalRequest);

}
