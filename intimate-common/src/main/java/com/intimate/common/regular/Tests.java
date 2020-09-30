package com.intimate.common.regular;

import org.junit.Test;

public class Tests {


    @Test
    public void tests (){
        boolean phone = RegUtils.checkPhone("17364831501");
        System.out.println(phone);
    }
}
