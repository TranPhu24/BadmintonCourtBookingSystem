package model;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    private List<Account> a = new ArrayList<>();
    public List<Court> searchCourt(String location, String time) {
		return null;
    }
    public Boolean registerAccount(Account details) {
        for (Account account : a) {
            if (account.getAccountId().equals(details.getAccountId())) {
                return false; 
            }
        }
        a.add(details);
        return true;
    }
}
