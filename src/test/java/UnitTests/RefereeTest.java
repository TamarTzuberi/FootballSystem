package UnitTests;

import Domain.Referee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @Test
    void setTraining() {
        Referee r = new Referee("bob","userBob","Bob123!","bob@gmail.com","basic");
        r.setTraining("advanced");
        assertEquals("advanced",r.getTraining());
    }
    @Test
    void setTrainingWithNull() {
        try{
            Referee r = new Referee("bob","userBob","Bob123!","bob@gmail.com","basic");
            r.setTraining(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }
    @Test
    void refereeConstructorNullValue(){
        try {
            Referee r = new Referee(null,"userBob","Bob123!","bob@gmail.com","basic");
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }


}