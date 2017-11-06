package service.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.rest.core.config.Projection;
import service.Application;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Projection(name = "excerpt", types = Loan.class)
public interface LoanExcerpt {
    List<Extension> getExtensions();

    int getTerm();

    BigDecimal getAmount();

}
