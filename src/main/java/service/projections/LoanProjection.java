package service.projections;

import org.springframework.data.rest.core.config.Projection;
import service.domain.Extension;
import service.domain.Loan;

import java.math.BigDecimal;
import java.util.List;

@Projection(name = "viewLoan" , types = Loan.class)
public interface LoanProjection {

    BigDecimal getAmount();

    int getTerm();

    double getInterest();

    List<Extension> getExtensions();
}
