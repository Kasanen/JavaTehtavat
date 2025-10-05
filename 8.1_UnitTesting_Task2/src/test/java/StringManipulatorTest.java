
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class StringManipulatorTest {

    @Test
    void canConcatenate() {
        StringManipulator s = new StringManipulator();
        String str1 = "Hello ";
        String str2 = "World";
        assertEquals("Hello World", s.concatenate(str1, str2));
    }

    @Test
    void canFindLength() {
        StringManipulator s = new StringManipulator();
        String str1 = "HelloWorld";
        assertEquals(10, s.findLength(str1));
    }

    @Test
    void canConvertToUpperCase() {
        StringManipulator s = new StringManipulator();
        String str = "HelloWorld";
        assertEquals("HELLOWORLD", s.convertToUpperCase(str));
    }

    @Test
    void canConvertToLowerCase() {
        StringManipulator s = new StringManipulator();
        String str = "HelloWorld";
        assertEquals("helloworld", s.convertToLowerCase(str));
    }

    @Test
    void canContainsSubstring() {
        StringManipulator s = new StringManipulator();
        String str = "HelloWorld";
        String subStr = "World";
        assertEquals(true, s.containsSubstring(str, subStr));
    }
}
