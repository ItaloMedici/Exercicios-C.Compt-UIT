import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex07Test {

    @Test
    public void testEvenBautomaton() {
        assertFalse(Ex07.evenBautomaton("aab"));
        assertFalse(Ex07.evenBautomaton("bbb"));
        assertFalse(Ex07.evenBautomaton("abbab"));

        assertTrue(Ex07.evenBautomaton("bb"));
        assertTrue(Ex07.evenBautomaton("aa"));
        assertTrue(Ex07.evenBautomaton("bbbb"));
        assertTrue(Ex07.evenBautomaton("ababa"));
    }
}