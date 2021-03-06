package service.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import service.Application;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "{validation.ssn.empty}")
    @JsonIgnore
    private String ssn;

    @NotNull(message = "{validation.amount.empty}")
    @Max(Application.MAX_POSSIBLE_AMOUNT)
    private BigDecimal amount;

    @NotNull(message = "{validation.interest.empty}")
    private Double interest;

    @NotNull(message = "{validation.term.empty}")
    @Min(1)
    private Integer term;

    @NotEmpty(message = "{validation.ip.empty}")
    @JsonIgnore
    private String ip;

    @NotNull(message = "{validation.createdAt}")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "loan")
    private List<Extension> extensions;

    public Loan() {
        this.createdAt = Timestamp.valueOf(LocalDateTime.now());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public List<Extension> getExtensions() {
        return extensions;
    }

    public void setExtensions(List<Extension> extensions) {
        this.extensions = extensions;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }
}
