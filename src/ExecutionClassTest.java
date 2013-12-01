/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 01.12.13
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class ExecutionClassTest {
    Country Ukraine = new Country.Builder()
            .fullName("Ukraine")
            .capital("Kiev")
            .shortCode("UA")
            .build();
    Country France = new Country.Builder()
            .fullName("France")
            .capital("Paris")
            .shortCode("FR")
            .build();
    Country Poland = new Country.Builder()
            .fullName("Poland")
            .capital("Warsaw")
            .shortCode("PL")
            .build();
    Country CzechRepublic = new Country.Builder()
            .fullName("Czech Republic")
            .capital("Prague")
            .shortCode("CZ")
            .build();
    Country Italy = new Country.Builder()
            .fullName("Italy")
            .capital("Rome")
            .shortCode("IT")
            .build();
    Country Spain = new Country.Builder()
            .fullName("Spain")
            .capital("Madrid")
            .shortCode("SP")
            .build();
    Country Portugal = new Country.Builder()
            .fullName("Portugal")
            .capital("Lisbon")
            .shortCode("PT")
            .build();
    Country Russia = new Country.Builder()
            .fullName("Russia")
            .capital("Moskow")
            .shortCode("RU")
            .build();
    @Test
    public void testInnerJoinWithoutCommonElements() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Poland, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{};
        assertArrayEquals(expectedResult, exClass.InnerJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testInnerJoinPositive() throws Exception{
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Russia};
        assertArrayEquals(expectedResult, exClass.InnerJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testInnerJoinAllArraysAreEmpty() throws Exception{
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{};
        Country [] secondCountryArray = new Country[]{};
        Country [] expectedResult = new Country[]{};
        assertArrayEquals(expectedResult, exClass.InnerJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testInnerJoinNegative() throws Exception{
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Ukraine};
        assertNotSame(expectedResult, exClass.InnerJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testOuterJoinPositive() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Ukraine, Portugal, CzechRepublic, Spain};
        assertArrayEquals(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testOuterJoinNegative() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Ukraine, CzechRepublic, Spain};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testOuterJoinWithNullExpectedResult() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] expectedResult = new Country[]{};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testOuterJoinNegativeWithNullActual() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] expectedResult = new Country[]{Portugal};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testOuterJoinAllArraysAreEmpty() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{};
        Country [] secondCountryArray = new Country[]{};
        Country [] expectedResult = new Country[]{};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testLeftJoin() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{Russia, CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Ukraine, Russia, Portugal, Russia};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testLeftJoinNegative() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{Ukraine, Russia, Portugal};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testRightJoin() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{CzechRepublic, Spain};
        Country [] expectedResult = new Country[]{CzechRepublic, Spain};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testRightJoinNegative() throws Exception {
        ExecutionClass exClass = new ExecutionClass();
        Country [] firstCountryArray = new Country[]{Ukraine, Russia, Portugal};
        Country [] secondCountryArray = new Country[]{};
        Country [] expectedResult = new Country[]{};
        assertNotSame(expectedResult, exClass.OuterJoin(firstCountryArray, secondCountryArray));
    }

    @Test
    public void testRemoveNullElements() throws Exception {

    }
}
