package com.quantity.measurement.enums;

public enum LengthUnit {

    FEET(1.0),

    INCH(1.0 / 12),      // 1 inch = 1/12 feet

    YARD(3.0),           // 1 yard = 3 feet

    CM(0.0328084);       // 1 cm = 0.0328084 feet (because 1 cm = 0.393701 inch)

    private final double toFeetFactor;

    LengthUnit(double toFeetFactor) {
        this.toFeetFactor = toFeetFactor;
    }

    public double toFeet(double value) {
        return value * toFeetFactor;
    }
}