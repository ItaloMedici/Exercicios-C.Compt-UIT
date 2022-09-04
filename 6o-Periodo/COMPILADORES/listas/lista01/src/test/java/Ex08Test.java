import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ex08Test {

    @Test
    void doesntIncludes101() {
        assertFalse(Ex08.doesntIncludes101("101"));
        assertFalse(Ex08.doesntIncludes101("1110111"));
        assertFalse(Ex08.doesntIncludes101("0000001101"));

        assertTrue(Ex08.doesntIncludes101("1"));
        assertTrue(Ex08.doesntIncludes101("0"));
        assertTrue(Ex08.doesntIncludes101(""));
        assertTrue(Ex08.doesntIncludes101("11111110"));
    }
}