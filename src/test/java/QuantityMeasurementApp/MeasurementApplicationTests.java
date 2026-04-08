package QuantityMeasurementApp;
import  com.quantity.measurement.enums.*;
import com.quantity.measurement.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MeasurementApplicationTests {
	
private static final double EPSILON = 1e-6;
    
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
                .equals(new QuantityLength(0.3937008, LengthUnit.INCH)));
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
    // 1
    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);
    }

    // 2
    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                QuantityLength.convert(24.0, LengthUnit.INCH, LengthUnit.FEET),
                0.0001);
    }

    // 3
    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                QuantityLength.convert(1.0, LengthUnit.YARD, LengthUnit.INCH),
                0.0001);
    }

    // 4
    @Test
    void testConversion_InchesToYards() {
        assertEquals(2.0,
                QuantityLength.convert(72.0, LengthUnit.INCH, LengthUnit.YARD),
                0.0001);
    }

    // 5
    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                QuantityLength.convert(2.54, LengthUnit.CM, LengthUnit.INCH),
                0.0001);
    }

    // 6
    @Test
    void testConversion_FeetToYard() {
        assertEquals(2.0,
                QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARD),
                0.0001);
    }

    // 7
    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);
    }

    // 8
    @Test
    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCH),
                0.0001);
    }

    // 9
    @Test
    void testConversion_RoundTrip() {
        double value = 5.0;

        double converted = QuantityLength.convert(value, LengthUnit.FEET, LengthUnit.INCH);
        double back = QuantityLength.convert(converted, LengthUnit.INCH, LengthUnit.FEET);

        assertEquals(value, back, 0.0001);
    }

    // 10
    @Test
    void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(1.0, null, LengthUnit.FEET);
        });
    }

    // 11
    @Test
    void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCH);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCH);
        });
    }

    // 12
    @Test
    void testConversion_PrecisionTolerance() {
        double result = QuantityLength.convert(1.0, LengthUnit.CM, LengthUnit.INCH);
        assertEquals(0.393701, result, 0.0001);
    }
    
    
  

    
    @Test

    void testAddition_SameUnit_FeetPlusFeet() {

        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)

                .add(new QuantityLength(2.0, LengthUnit.FEET));



        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);

    }



    @Test

    void testAddition_SameUnit_InchPlusInch() {

        QuantityLength result = new QuantityLength(5.0, LengthUnit.INCH)

                .add(new QuantityLength(7.0, LengthUnit.INCH));



        assertEquals(new QuantityLength(12.0, LengthUnit.INCH), result);

    }



    @Test

    void testAddition_CrossUnit_FeetPlusInches() {

        QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)

                .add(new QuantityLength(12.0, LengthUnit.INCH));



        assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);

    }



    @Test

    void testAddition_CrossUnit_InchPlusFeet() {

        QuantityLength result = new QuantityLength(12.0, LengthUnit.INCH)

                .add(new QuantityLength(1.0, LengthUnit.FEET));



        assertEquals(new QuantityLength(24.0, LengthUnit.INCH), result);

    }



    @Test

    void testAddition_CrossUnit_YardPlusFeet() {

        QuantityLength result = new QuantityLength(1.0, LengthUnit.YARD)

                .add(new QuantityLength(3.0, LengthUnit.FEET));



        assertEquals(new QuantityLength(2.0, LengthUnit.YARD), result);

    }



    

    @Test
    void testAddition_CrossUnit_CentimeterPlusInch() {

        QuantityLength result = new QuantityLength(2.54, LengthUnit.CM)
                .add(new QuantityLength(1.0, LengthUnit.INCH));

        assertEquals(5.08, result.toConvert(LengthUnit.CM), 0.01);
    }


    @Test

    void testAddition_Commutativity() {

        QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);

        QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);



        double result1 = a.add(b).toFeet();

        double result2 = b.add(a).toFeet();



        assertEquals(result1, result2, EPSILON);

    }



    @Test

    void testAddition_WithZero() {

        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)

                .add(new QuantityLength(0.0, LengthUnit.INCH));



        assertEquals(new QuantityLength(5.0, LengthUnit.FEET), result);

    }



    @Test

    void testAddition_NegativeValues() {

        QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)

                .add(new QuantityLength(-2.0, LengthUnit.FEET));



        assertEquals(new QuantityLength(3.0, LengthUnit.FEET), result);

    }



    @Test

    void testAddition_NullSecondOperand() {

        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);



        assertThrows(IllegalArgumentException.class, () -> {

            q.add(null);

        });

    }



    @Test

    void testAddition_LargeValues() {

        QuantityLength result = new QuantityLength(1e6, LengthUnit.FEET)

                .add(new QuantityLength(1e6, LengthUnit.FEET));



        assertEquals(new QuantityLength(2e6, LengthUnit.FEET), result);

    }



    @Test

    void testAddition_SmallValues() {

        QuantityLength result = new QuantityLength(0.001, LengthUnit.FEET)

                .add(new QuantityLength(0.002, LengthUnit.FEET));



        assertEquals(new QuantityLength(0.003, LengthUnit.FEET), result);

    }
    
    
 // UC7 - Addition with explicit target unit
    @Test
	void testAddition_ExplicitTargetUnit_Feet() {
	    QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)
	            .add(new QuantityLength(12.0, LengthUnit.INCH), LengthUnit.FEET);

	    assertEquals(new QuantityLength(2.0, LengthUnit.FEET), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_Inches() {
	    QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)
	            .add(new QuantityLength(12.0, LengthUnit.INCH), LengthUnit.INCH);

	    assertEquals(new QuantityLength(24.0, LengthUnit.INCH), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_Yards() {
	    QuantityLength result = new QuantityLength(1.0, LengthUnit.FEET)
	            .add(new QuantityLength(12.0, LengthUnit.INCH), LengthUnit.YARD);

	    assertEquals(new QuantityLength(2.0 / 3.0, LengthUnit.YARD), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_Centimeters() {
	    QuantityLength result = new QuantityLength(2.54, LengthUnit.CM)
	            .add(new QuantityLength(1.0, LengthUnit.INCH), LengthUnit.CM);

	    assertEquals(new QuantityLength(5.08, LengthUnit.CM), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
	    QuantityLength result = new QuantityLength(1.0, LengthUnit.YARD)
	            .add(new QuantityLength(2.0, LengthUnit.YARD), LengthUnit.YARD);

	    assertEquals(new QuantityLength(3.0, LengthUnit.YARD), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
	    QuantityLength result = new QuantityLength(3.0, LengthUnit.FEET)
	            .add(new QuantityLength(6.0, LengthUnit.FEET), LengthUnit.FEET);

	    assertEquals(new QuantityLength(9.0, LengthUnit.FEET), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_Commutativity() {
	    QuantityLength a = new QuantityLength(1.0, LengthUnit.FEET);
	    QuantityLength b = new QuantityLength(12.0, LengthUnit.INCH);

	    double r1 = a.add(b, LengthUnit.FEET).toFeet();
	    double r2 = b.add(a, LengthUnit.FEET).toFeet();

	    assertEquals(r1, r2, EPSILON);
	}

	@Test
	void testAddition_ExplicitTargetUnit_WithZero() {
	    QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)
	            .add(new QuantityLength(0.0, LengthUnit.INCH), LengthUnit.YARD);

	    assertEquals(new QuantityLength(5.0 / 3.0, LengthUnit.YARD), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_NegativeValues() {
	    QuantityLength result = new QuantityLength(5.0, LengthUnit.FEET)
	            .add(new QuantityLength(-2.0, LengthUnit.FEET), LengthUnit.INCH);

	    assertEquals(new QuantityLength(36.0, LengthUnit.INCH), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_NullTargetUnit() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new QuantityLength(1.0, LengthUnit.FEET)
	                .add(new QuantityLength(1.0, LengthUnit.FEET), null);
	    });
	}

	@Test
	void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
	    QuantityLength result = new QuantityLength(1000.0, LengthUnit.FEET)
	            .add(new QuantityLength(500.0, LengthUnit.FEET), LengthUnit.INCH);

	    assertEquals(new QuantityLength(18000.0, LengthUnit.INCH), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
	    QuantityLength result = new QuantityLength(12.0, LengthUnit.INCH)
	            .add(new QuantityLength(12.0, LengthUnit.INCH), LengthUnit.YARD);

	    assertEquals(new QuantityLength(2.0 / 3.0, LengthUnit.YARD), result);
	}

	@Test
	void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
	    QuantityLength result = new QuantityLength(1.0, LengthUnit.CM)
	            .add(new QuantityLength(1.0, LengthUnit.CM), LengthUnit.INCH);

	    assertEquals(new QuantityLength(0.7874, LengthUnit.INCH), result);
	}
	
	@Test
	void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
	    LengthUnit[] units = LengthUnit.values();
	    for (LengthUnit u1 : units) {
	        for (LengthUnit u2 : units) {
	            for (LengthUnit target : units) {
	                QuantityLength q1 = new QuantityLength(1.0, u1);
	                QuantityLength q2 = new QuantityLength(1.0, u2);

	                QuantityLength result = q1.add(q2, target);
	                double expected = QuantityLength.convert(1.0, u1, target) +
	                                  QuantityLength.convert(1.0, u2, target);
	                assertEquals(expected, result.toConvert(target), 1e-6,
	                        "Failed for units: " + u1 + ", " + u2 + " -> " + target);
	            }
	        }
	    }
	}
	
}



 