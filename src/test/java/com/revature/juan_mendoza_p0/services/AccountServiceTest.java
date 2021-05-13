package com.revature.juan_mendoza_p0.services;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountServiceTest {


    private AccountService sut;

    @Before
    public void setUp(){
        sut = new AccountService();
    }

    @After
    public void tearDown(){
        sut = null;
    }

    @Test(expected = Exception.class)
    public void test_belowZeroWithNegative(){
        //Arrange
        //Act
        boolean actual = sut.verifyInputGreaterZero(-20.0);
        //Assert

    }

    @Test
    public void test_belowZeroWithPositive(){
        //Arrange
        //Act
        boolean actual = sut.verifyInputGreaterZero(0.01);
        //Assert
        Assert.assertTrue(actual);
    }

    @Test(expected = Exception.class)
    public void test_overdraftWithOverdrafting(){
        //Arrange
        //Act
        boolean actual = sut.isoverDraftingOccuring("",200);
        Assert.assertTrue(actual);
    }

}
