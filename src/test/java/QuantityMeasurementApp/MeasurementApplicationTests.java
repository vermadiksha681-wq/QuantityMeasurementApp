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
    
    @Test
    void testEquality_YardToYard_SameValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));
    }

    // 2
    @Test
    void testEquality_YardToYard_DifferentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(2.0, LengthUnit.YARD)));
    }

    // 3
    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(3.0, LengthUnit.FEET)));
    }

    // 4
    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        assertTrue(new QuantityLength(3.0, LengthUnit.FEET)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));
    }

    // 5
    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(36.0, LengthUnit.INCH)));
    }

    // 6
    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        assertTrue(new QuantityLength(36.0, LengthUnit.INCH)
                .equals(new QuantityLength(1.0, LengthUnit.YARD)));
    }

    // 7
    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD)
                .equals(new QuantityLength(2.0, LengthUnit.FEET)));
    }

    // 8
    @Test
    void testEquality_centimetersToInches_EquivalentValue() {
        assertTrue(new QuantityLength(1.0, LengthUnit.CM)
                .equals(new QuantityLength(0.393701, LengthUnit.INCH)));
    }

    // 9
    @Test
    void testEquality_centimetersToFeet_NonEquivalentValue() {
        assertFalse(new QuantityLength(1.0, LengthUnit.CM)
                .equals(new QuantityLength(1.0, LengthUnit.FEET)));
    }

    // 10
    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength yard = new QuantityLength(1.0, LengthUnit.YARD);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inch = new QuantityLength(36.0, LengthUnit.INCH);

        assertTrue(yard.equals(feet) && feet.equals(inch) && yard.equals(inch));
    }

    // 11
    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(Exception.class, () -> {
            new QuantityLength(1.0, null);
        });
    }

    // 12
    @Test
    void testEquality_YardSameReference() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.YARD);
        assertTrue(q.equals(q));
    }

    // 13
    @Test
    void testEquality_YardNullComparison() {
        assertFalse(new QuantityLength(1.0, LengthUnit.YARD).equals(null));
    }

    // 14
    @Test
    void testEquality_CentimetersWithNullUnit() {
        assertThrows(Exception.class, () -> {
            new QuantityLength(1.0, null);
        });
    }

    // 15
    @Test
    void testEquality_CentimetersSameReference() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.CM);
        assertTrue(q.equals(q));
    }

    // 16
    @Test
    void testEquality_CentimetersNullComparison() {
        assertFalse(new QuantityLength(1.0, LengthUnit.CM).equals(null));
    }

    // 17
    @Test
    void testEquality_AllUnits_ComplexScenario() {
        assertTrue(new QuantityLength(2.0, LengthUnit.YARD)
                .equals(new QuantityLength(6.0, LengthUnit.FEET)));

        assertTrue(new QuantityLength(6.0, LengthUnit.FEET)
                .equals(new QuantityLength(72.0, LengthUnit.INCH)));
    }
}
