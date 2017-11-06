package service.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;
import service.Application;
import service.domain.Extension;
import service.domain.Loan;

import javax.servlet.http.HttpServletRequest;

@Component
@RepositoryEventHandler(Extension.class)
public class ExtensionHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(Extension extension) {
        extension.setInterest(Application.INTEREST_FACTOR_PER_WEEK);
    }
}
