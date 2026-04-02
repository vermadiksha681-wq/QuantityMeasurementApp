package com.quantity.measurement.model;



import com.quantity.measurement.enums.LengthUnit;



public class QuantityLength {

    private double value;

    private LengthUnit unit;



    public QuantityLength(double value, LengthUnit unit) {

        if (unit == null) {

            throw new IllegalArgumentException("Unit cannot be null");

        }

        this.value = value;

        this.unit = unit;

    }

    

    public double toFeet() {

        return unit.toFeet(value);

    }


 // Instance method
    public double toConvert(LengthUnit targetUnit) {
        return convert(this.value, this.unit, targetUnit);
    }

    // Static method
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {

        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units shouldn't be null!");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value!");
        }

        double valueInFeet = sourceUnit.toFeet(value);
        return targetUnit.fromFeet(valueInFeet);
    }

    @Override

    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;

        double thisInFeet=this.unit.toFeet(this.value);

        double otherInFeet=other.unit.toFeet(other.value);

        return Double.compare(thisInFeet, otherInFeet) == 0 ;
  
    }



    @Override
    public String toString() {

        return value + " " + unit.name();

    }

}

