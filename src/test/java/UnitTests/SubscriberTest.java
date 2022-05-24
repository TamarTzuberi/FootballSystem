package UnitTests;

import Domain.Subscriber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubscriberTest {

    @Test
    void setUserName() {
        Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
        s.setUserName("alis");
        assertEquals("alis",s.getUserName());
    }

    @Test
    void setUserNameWithNull(){
        try {
            Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
            s.setName(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    void setPassword() {
        Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
        s.setPassword("Alis123!");
        assertEquals("Alis123!",s.getPassword());
    }

    @Test
    void setPasswordWithNull(){
        try {
            Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
            s.setPassword(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    void setEmailWithNull(){
        try {
            Subscriber s = new Subscriber("subscriber0","bob","userBob","Bob123!","bob@gmail.com","Subscriber");
            s.setEmail(null);
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    @Test
    void checkConstructor(){
        try {
            Subscriber s = new Subscriber("subscriber0",null,"userBob","Bob123!","bob@gmail.com","Subscriber");
            fail("Should have thrown exception");
        } catch (Exception e) {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }
}