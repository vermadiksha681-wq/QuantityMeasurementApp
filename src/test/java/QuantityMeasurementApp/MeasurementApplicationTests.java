package QuantityMeasurementApp;
import  com.quantity.measurement.enums.*;
import com.quantity.measurement.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MeasurementApplicationTests {
	@Test
    void testEquality_FeetToFeet_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    // 2️⃣ Inch to Inch (same value)
    @Test
    void testEquality_InchToInch_SameValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    // 3️⃣ Feet to Inch (equivalent)
    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCH);

        assertEquals(q1, q2);
    }

    // 4️⃣ Inch to Feet (symmetry)
    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);

        assertEquals(q1, q2);
    }

    // 5️⃣ Feet to Feet (different value)
    @Test
    void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);

        assertNotEquals(q1, q2);
    }

    // 6️⃣ Inch to Inch (different value)
    @Test
    void testEquality_InchToInch_DifferentValue() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCH);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.INCH);

        assertNotEquals(q1, q2);
    }

    // 7️⃣ Invalid / Null Unit
    @Test
    void testEquality_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(5.0, null);
        });
    }

    // 8️⃣ Same reference
    @Test
    void testEquality_SameReference() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);

        assertEquals(q1, q1);
    }

    // 9️⃣ Null comparison
    @Test
    void testEquality_NullComparison() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);

        assertNotEquals(q1, null);
    }

    // 🔟 Different type (Non-numeric input)
    @Test
    void testEquality_NonNumericInput() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);

        assertNotEquals(q1, "5.0");
    }
}
