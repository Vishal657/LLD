We are removing some unwanted objects like Floor, External/Internal buttons, Building etc...
    Just inform the interviewer that are they required because we want to focus more on elevator system design
    Also those button can use COMMAND pattern as we have learned


Adding weight sensor is quite simple
    Just add a interface for the sensor and as soon as elevator stops before restart just check the weight
    if elevator is over weight then throw the error cant move