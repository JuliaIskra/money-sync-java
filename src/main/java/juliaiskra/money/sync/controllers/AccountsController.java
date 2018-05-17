package juliaiskra.money.sync.controllers;

import java.util.List;
import juliaiskra.money.sync.domain.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 * @author Julia Nemtseva
 */
@RestController
public class AccountsController {

    @RequestMapping(path = "/accounts", method = GET)
    public List<Account> getAccounts(@RequestParam(value = "id", defaultValue = "-1") final int id) {
        return List.of(new Account());
    }

    @RequestMapping(path = "/accounts", method = PUT)
    public Account createOrUpdateAccount(
            @RequestParam(value = "id") final int id,
            @RequestParam(value = "name") final String name) {
        return new Account();
    }

    @RequestMapping(path = "/accounts", method = DELETE)
    public List<Account> deleteAccount(@RequestParam(value = "id") final int id) {
        return List.of(new Account());
    }
}
