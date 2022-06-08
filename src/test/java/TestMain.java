import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMain {

    //Main main = new Main();
    @Test
    public void testCaclulateDoors(int wallNumber){

        Assertions.assertEquals(10, Main.calculateDoors(1));
    }

}

