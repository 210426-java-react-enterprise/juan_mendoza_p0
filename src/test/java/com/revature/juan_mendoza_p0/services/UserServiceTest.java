package com.revature.juan_mendoza_p0.services;

import com.revature.juan_mendoza_p0.doas.UserDAO;
import com.revature.juan_mendoza_p0.exceptions.ResourcePersistenceException;
import com.revature.juan_mendoza_p0.models.AppUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserService mockUserService;
    private UserDAO mockDAO = mock(UserDAO.class);
    private UserService sut;


    @Before
    public void setUp(){
        mockDAO = mock(UserDAO.class);
        sut = new UserService(mockDAO);

    }

    @After
    public void tearDown(){
        mockUserService = null;
        mockDAO = null;
        sut = null;
    }

    @Test
    public void test_registerWithValidUserAndAvailableUsernameAndPassword(){
        //Arrange

        when(mockDAO.isUserNameAvailable(anyString())).thenReturn(true);
        when(mockDAO.isEmailAvailalbe(anyString())).thenReturn(true);


        //Act
        sut.register(new AppUser(1,"jj","pass","fn","ln","email",33,1));

        //Assert
        verify(mockDAO,times(1)).isUserNameAvailable(anyString());
        verify(mockDAO,times(1)).isEmailAvailalbe(anyString());
        verify(mockDAO,times(1)).save(any());
    }

    @Test
    public void test_registerWithValidUserAndTakenUsername(){
        //Arrange
        when(mockDAO.isUserNameAvailable(anyString())).thenReturn(false);

        //Act
        try{
            sut.register(new AppUser(1,"jj","password","fn","ln","email",33,1));
        }catch (Exception e){
            assertTrue(e instanceof ResourcePersistenceException);
        }finally {
            verify(mockDAO,times(0)).isEmailAvailalbe(anyString());
            verify(mockDAO,times(0)).save(any());//WRONG SHOULD NOT WORK!!! SHOULD BE 0!
        }
    }


    @Test
    public void test_registerWithValidUsernameAndTakenEmail(){
        //Arrange
        when(mockDAO.isEmailAvailalbe(anyString())).thenReturn(false);

        //Act
        try{
            sut.register(new AppUser(1,"jj","password","fn","ln","email",33,1));
        }catch (Exception e){
            assertTrue(e instanceof ResourcePersistenceException);
        }finally{
            verify(mockDAO,times(0)).isEmailAvailalbe(anyString());
            verify(mockDAO,times(0)).save(any());
        }
    }



}
