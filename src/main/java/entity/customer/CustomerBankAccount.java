package entity.customer;

import lombok.Data;

@Data
public class CustomerBankAccount {

    private String bankName;
    private String bankAddress;
    private String swift;
    private String usdBankAccount;
    private String eurBankAccount;
    private String bynBankAccount;
}
