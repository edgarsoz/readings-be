package lv.proto.readingsbe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partner")
public class Partner {

    public Partner(String name, Boolean company, String code, String email, String phone, Collection<Contract> contracts) {
        this.name = name;
        this.company = company;
        this.code = code;
        this.email = email;
        this.phone = phone;
        this.contracts = contracts;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private Boolean company;
    @Column
    private String code;
    @Column
    private String email;
    @Column
    private String phone;
    @OneToMany(mappedBy = "partner", fetch = FetchType.EAGER)
    private Collection<Contract> contracts;
}
