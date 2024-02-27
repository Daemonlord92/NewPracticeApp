import myclass.MyClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class MyClassTests {
    private MyClass myClass;

    @BeforeEach
    void setUp() {
        myClass = new MyClass();
    }

    @Test
    @DisplayName("MyClass should be able to set the name variable!")
    public void MyClass_ShouldSetName_Successful() {
        myClass.setName("Bob");
        Assertions.assertEquals("Bob", myClass.getName());
    }

    @Test
    @DisplayName("MyClass should not take numbers in the setName method!")
    public void MyClass_SetName_ShouldRejectNumbers() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> myClass.setName("TechN9n3"));
        Assertions.assertEquals("There cannot be numbers in the Name", exception.getMessage());
    }

}
