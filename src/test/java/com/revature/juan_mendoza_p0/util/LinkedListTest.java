package com.revature.juan_mendoza_p0.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {


    private LinkedList<String> sut;  //system.under.testing

    @Before //setting up before the test
    public void setUpTest(){
        sut = new LinkedList<>();
    }

    @After//after each test
    public void tearDownTest(){
        sut = null;
    }

    @Test
    public void test_addWithNonNullValue(){
        //Arrange
        int expected = 1;

        //Act
        sut.add("data");

        //Assert
        int actualSize = sut.size();
        Assert.assertEquals(expected,actualSize);
    }

    @Test(expected = Exception.class)
    public void test_addWithNullValue(){
        //Arrange
        //Act
        sut.add(null);
        //Assert
        //we expect a exception
    }


    @Test
    public void test_pollWithPopulatedList(){
        //Arrange
        sut.add("test 1");
        sut.add("test 2");
        String expectedResult = "test 1";
        int expectedSize = 1;

        //Act
        String actualResult = sut.poll();

        //Assert
        int actualSize = sut.size();
        Assert.assertEquals(expectedResult,actualResult);
        Assert.assertEquals(expectedSize,actualSize);
    }


    @Test
    public void test_pollWithEmptyList(){
        //Arrange
        //Act
        String actualResult = sut.poll();

        //Assert
        Assert.assertNull(actualResult);
    }

    @Test(expected = Exception.class)
    public void test_getWithOutOfBound(){
        //Arrange
        sut.add("data1");
        sut.add("data2");
        //Act
        String actualResult = sut.get(4);

        //Assert

    }

    @Test
    public void test_size(){
        //Arrange
        sut.add("1");
        sut.add("2");
        int expected = 2;
        //Act
        int actualResult = sut.size();

        //Assert
        Assert.assertEquals(actualResult,expected);
    }

    @Test
    public void test_ContainsWithValidData(){
        //Arrange
        sut.add("1");
        sut.add("2");
        sut.add("3");
        //Act
        boolean actual = sut.contains("2");

        //Assert
        Assert.assertTrue(actual);
    }

    @Test
    public void test_constainsWithNonValidData(){
        //Arrange
        sut.add("1");
        sut.add("2");
        sut.add("3");
        //Act
        boolean actual = sut.contains("4");

        //Assert
        Assert.assertFalse(actual);
    }

}
