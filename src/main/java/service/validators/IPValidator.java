package service.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import service.domain.Loan;
import service.repositories.LoanRepository;

import java.time.Instant;
import java.util.List;

@Component("beforeCreateIPValidator")
public class IPValidator implements Validator {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Loan.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String currentIp = ((Loan) o).getIp();
        List<Loan> byIp = loanRepository.findByIp(currentIp);

        if (byIp == null) {
            return;
        }

        long count = byIp.stream()
                .filter(p -> Instant.now().compareTo( p.getCreatedAt().toInstant()) > 0)
                .count();

        if ( count > 2) {
            errors.rejectValue("ip", "error.ip");
        }
    }
}
