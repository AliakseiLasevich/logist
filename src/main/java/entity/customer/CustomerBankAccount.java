package entity.customer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer_bank_account")
public class CustomerBankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer_bank_account")
    private int id;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_address")
    private String bankAddress;

    @Column(name = "swift")
    private String swift;

    @Column(name = "usd_bank_account")
    private String usdBankAccount;

    @Column(name = "eur_bank_account")
    private String eurBankAccount;

    @Column(name = "byn_bank_account")
    private String bynBankAccount;
}
