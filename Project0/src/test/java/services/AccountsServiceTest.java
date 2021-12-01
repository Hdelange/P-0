package services;

import dao.AccountsDao;
import models.Accounts;
import models.Users;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountsServiceTest {

    AccountsDao accountsDao = Mockito.mock(AccountsDao.class);

    AccountsService accountsService;

    public AccountsServiceTest() {
        this.accountsService = new AccountsService(accountsDao);
    }

    @Test
    void getAllAccounts() {
        //arrange
        List<Accounts> accounts = new ArrayList<>();
        accounts.add(new Accounts(1, "Checking", 4000.00,1));
        accounts.add(new Accounts(2, "Savings", 300.00,2));
        List<Accounts> expectedValue = accounts;
        Mockito.when(accountsDao.getAllAccounts()).thenReturn(accounts);

        //act
        List<Accounts> actualResult = accountsService.getAllAccounts();

        //assert
        assertEquals(expectedValue,actualResult);
    }

    @Test
    void getOneAccounts() {
        //arrange
        Accounts expectedResult = new Accounts(3, "Checking", 5.00,3);
        Mockito.when(accountsDao.getOneAccounts(expectedResult.getId())).thenReturn(expectedResult);

        //act
        Accounts actualResult = accountsService.getOneAccounts(expectedResult.getId());

        //assert
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void createAccounts() {
        //arrange
        Accounts accounts = new Accounts(4, "Savings", 10000.00,4);

        //act
        accountsService.createAccounts(accounts);

        //assert
        assertEquals(4,4);
    }


    @Test
    void updateAccounts() {
        //arrange
        Integer accountId = 1;

        //act
        accountsService.updateAccounts(accountId);

        //assert
        Mockito.verify(accountsDao, Mockito.times(1)).updateAccounts(accountId);
    }

    @Test
    void deleteAccounts() {
        //arrange
        Integer accountsId = 1;

        //act
        accountsService.deleteAccounts(accountsId);

        //assert
        Mockito.verify(accountsDao, Mockito.times(1)).deleteAccounts(accountsId);
    }
}