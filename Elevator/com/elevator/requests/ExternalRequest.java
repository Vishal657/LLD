package com.elevator.requests;

import com.elevator.Direction;

public class ExternalRequest {

    public int initializerFloor;
    public Direction direction;

    public ExternalRequest(int initializerFloor, Direction direction) {
        this.initializerFloor = initializerFloor;
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(initializerFloor);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ExternalRequest that = (ExternalRequest) obj;

        return initializerFloor == that.initializerFloor &&
                direction == that.direction;
    }

}
