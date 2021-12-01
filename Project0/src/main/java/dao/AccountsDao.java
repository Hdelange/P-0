package dao;

import models.Accounts;
import models.Users;

import java.util.List;

public interface AccountsDao {

    List<Accounts> getAllAccounts();
    Accounts getOneAccounts(Integer accountsId);
    void createAccounts(Accounts accounts);
    void updateAccounts(Integer accountsId);
    void deleteAccounts(Integer accountsId);


}
