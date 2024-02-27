import myclass.PlayerClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerClassTests {
    private PlayerClass playerClass;

    @BeforeEach
    void setUp()
    {
        playerClass = new PlayerClass();
    }

    @Test
    @DisplayName("PlayerClass should set playerClass String!")
    public void PlayerClass_setPlayerClass_Successful() {
        playerClass.setPlayerClass("Cleric");
        Assertions.assertEquals("Cleric", playerClass.getPlayerClass());
    }

    @Test
    @DisplayName("PlayerClass should reject input with number in setPlayerClass!")
    public void PlayerClass_setPlayerClass_ShouldThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> playerClass.setPlayerClass("T3chi3"));
        Assertions.assertEquals("Player class cannot contain numbers", exception.getMessage());
    }
}
