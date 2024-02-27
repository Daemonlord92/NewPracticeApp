import myclass.BankSystem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankingSystemTests {
    private static BankSystem bankSystem;

    @BeforeEach
    void setUp() {
        bankSystem = new BankSystem(5000f, 5000f, 5000f);
    }

    @Test
    @DisplayName("BankSystem withdraw method should minus from checking account")
    public void BankSystem_WithdrawFromChecking_ShouldSucceed() throws Exception {
        bankSystem.withdraw(500, "Checking", "Saving");
        Assertions.assertEquals(4500, bankSystem.getCheckingAccount());
    }

    @Test
    @DisplayName("BankSystem withdraw method should reject if checking boolean is locked")
    public void BankSystem_WithdrawFromChecking_ShouldThrowException() throws Exception {
        bankSystem.setCheckingLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.withdraw(500, "Checking", "Saving"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }

    @Test
    @DisplayName("BankSystem withdraw method should minus from saving account")
    public void BankSystem_WithdrawFromSaving_ShouldSucceed() throws Exception {
        bankSystem.withdraw(500, "Saving", "Checking");
        Assertions.assertEquals(4500, bankSystem.getSavingAccount());
    }

    @Test
    @DisplayName("BankSystem withdraw method should reject if saving boolean is locked")
    public void BankSystem_WithdrawFromSaving_ShouldThrowException() throws Exception {
        bankSystem.setSavingLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.withdraw(500, "Saving", "Checking"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }

    @Test
    @DisplayName("BankSystem withdraw method should minus from credit account")
    public void BankSystem_WithdrawFromCredit_ShouldSucceed() throws Exception {
        bankSystem.withdraw(500, "Credit", "Checking");
        Assertions.assertEquals(4500, bankSystem.getCreditAccount());
    }

    @Test
    @DisplayName("BankSystem withdraw method should reject if credit boolean is locked")
    public void BankSystem_WithdrawFromCredit_ShouldThrowException() throws Exception {
        bankSystem.setCreditLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.withdraw(500, "Credit", "Checking"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }

    @Test
    @DisplayName("BankSystem deposit method should increase checking amount!")
    public void BankSystem_DepositToChecking_ShouldSucceed() throws Exception {
        bankSystem.deposit(500, "Checking");
        Assertions.assertEquals(5500, bankSystem.getCheckingAccount());
    }

    @Test
    @DisplayName("BankSystem deposit method should reject deposit if checking boolean is locked!")
    public void BankSystem_DepositToChecking_ShouldThrowException() throws Exception {
        bankSystem.setCheckingLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.deposit(500, "Checking"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }

    @Test
    @DisplayName("BankSystem deposit method should increase saving amount")
    public void BankSystem_DepositToSaving_ShouldSucceed() throws Exception {
        bankSystem.deposit(500, "Saving");
        Assertions.assertEquals(5500, bankSystem.getSavingAccount());
    }

    @Test
    @DisplayName("BankSystem deposit method should reject deposit if saving boolean is locked!")
    public void BankSystem_DepositToSaving_ShouldThrowException() throws Exception {
        bankSystem.setSavingLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.deposit(500, "Saving"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }

    @Test
    @DisplayName("BankSystem deposit method should increase credit amount")
    public void BankSystem_DepositToCredit_ShouldSucceed() throws Exception {
        bankSystem.deposit(500, "Credit");
        Assertions.assertEquals(5500, bankSystem.getCreditAccount());
    }

    @Test
    @DisplayName("BankSystem deposit method should reject deposit if credit boolean is locked!")
    public void BankSystem_DepositToCredit_ShouldThrowException() throws Exception {
        bankSystem.setCreditLocked(true);
        Throwable throwable = assertThrows(Exception.class, () -> bankSystem.deposit(500, "Credit"));
        Assertions.assertEquals("Account Locked!", throwable.getMessage());
    }
}
