package models;

public class Accounts {

    private Integer id;
    private String account_type;
    private Double balance;
    private Integer users_id_fk;

    public Accounts() {
    }

    public Accounts(Integer id, String account_type, Double balance, Integer users_id_fk) {
        this.id = id;
        this.account_type = account_type;
        this.balance = balance;
        this.users_id_fk = users_id_fk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getUsers_id_fk() {
        return users_id_fk;
    }

    public void setUsers_id_fk(Integer users_id_fk) {
        this.users_id_fk = users_id_fk;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", account_type='" + account_type + '\'' +
                ", balance=" + balance +
                ", users_id_fk=" + users_id_fk +
                '}';
    }
}
