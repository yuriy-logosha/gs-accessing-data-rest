package service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import service.Application;
import service.domain.Loan;

import javax.servlet.http.HttpServletRequest;

@Component
@RepositoryEventHandler(Loan.class)
public class LoanHandler {

    @Autowired
    private HttpServletRequest request;

    @HandleBeforeCreate
    public void handleBeforeCreate(Loan loan) {
        loan.setIp(request.getRemoteAddr());
        loan.setInterest(Application.INTEREST);
    }
}
