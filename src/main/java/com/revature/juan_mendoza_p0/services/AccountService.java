package com.revature.juan_mendoza_p0.services;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class AccountService {

    public String formatDoubleToCurrency(double balance){
        DecimalFormat df = new DecimalFormat("#,###,###,###.00");
        return df.format(balance);

    }
}
