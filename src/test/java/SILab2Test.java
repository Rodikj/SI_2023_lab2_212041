import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void everyBranchTest() {
        LinkedList<User> theLIst = new LinkedList<>();
        theLIst.add(new User("ivica", "gewsdfsfds", "ivica@gmail.com"));

        //1 do 3 do 4 do 5 do 14 do 16 do 17 do 22 i terminira na 23
        assertFalse(SILab2.function(new User(null, " !ivica", "ivica mesto"), theLIst));

        RuntimeException exception = assertThrows(RuntimeException.class,() -> SILab2.function(null, null));
        assertEquals("Mandatory information missing!", exception.getMessage());
        //1 do 2 frla exception na 23

        //1 do 3 do 5 do 6 do 7.1 do 7.2 do 8 do 9 do 11 do 7.3 do 13 do 14 do 15 i terminira na 23
        assertFalse(SILab2.function(new User("ivica", "fdsfasdfsa", "nesto@kmail.com"), theLIst));

        //1 do 3 do 5 do 6 do 7.1 do 8 do 9 do 10 do 11 do 12 do 7.3 do 13 do 14 do 16 do 17 do 18.1 do 18.2 do 19 do 18.3 do 21 do 22 do 23
        assertFalse(SILab2.function(new User("Ivica", "fsdfasaf", "ivica@gmail.com"), theLIst));

        //1 do 3 do 5 do 6 do 7.1 do 7.2 do 8 do 9 do 11 do 7.3 do 13 do 14 do 16 do 17 do 18.1 do 18.2 do 19 do 20 do 23
        assertTrue(SILab2.function(new User("vica", "pass!word", "nesto@gmail.com"), theLIst));

    }

    void multipleCondition() {
        RuntimeException exception;

        //f, t, not important
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User("ivica", null, null), null));
        assertEquals("Mandatory information missing!", exception.getMessage());

        //f, f, f
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User("Iviva", "Lozinkaaa", "ivica@gmail.com"), null));
        assertNotEquals("Mandatory information missing!", exception.getMessage());

        //t, not important, not important
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertEquals("Mandatory information missing!", exception.getMessage());

        //f, f, t
        exception = assertThrows(RuntimeException.class, () -> SILab2.function(new User("ivicaae", "Lozinkaaa!", null), null));
        assertEquals("Mandatory information missing!", exception.getMessage());



    }

}