package QuantityMeasurementApp;

import com.quantity.measurement.enums.LengthUnit;
import com.quantity.measurement.model.QuantityLength;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        
            // Static values directly define kar diye
            QuantityLength length1 = new QuantityLength(1.0, LengthUnit.FEET);
            QuantityLength length2 = new QuantityLength(12.0, LengthUnit.INCH);

    }
}