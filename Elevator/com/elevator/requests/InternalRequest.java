package com.elevator.requests;

public class InternalRequest {

    public int destinationFloor;

    public InternalRequest(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(destinationFloor);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        InternalRequest that = (InternalRequest) obj;

        return destinationFloor == that.destinationFloor;
    }


}
