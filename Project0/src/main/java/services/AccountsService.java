package services;

import dao.AccountsDao;
import models.Accounts;
import java.util.List;

public class AccountsService {
    AccountsDao accountsDao;

    public AccountsService(AccountsDao accountsDao){

        this.accountsDao = accountsDao;
    }

    public List<Accounts> getAllAccounts(){

        return accountsDao.getAllAccounts();
    }
    public Accounts getOneAccounts(Integer id){

        return accountsDao.getOneAccounts(id);
    }

    public void createAccounts(Accounts accounts){
        if (accounts.getBalance() < 0.00)
            System.out.println("insufficient balance");

        accountsDao.createAccounts(accounts);
    }

    public void updateAccounts(Integer accountsId){

        accountsDao.updateAccounts(accountsId);
    }

    public void deleteAccounts(Integer accountsId){

        accountsDao.deleteAccounts(accountsId);
    }





}


