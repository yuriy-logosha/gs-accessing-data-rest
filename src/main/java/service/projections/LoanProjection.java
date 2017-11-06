package service.projections;

import org.springframework.data.rest.core.config.Projection;
import service.domain.Loan;

import java.math.BigDecimal;

@Projection(name = "show" , types = Loan.class)
public interface LoanProjection {

    BigDecimal getAmount();

    int getTerm();


}
