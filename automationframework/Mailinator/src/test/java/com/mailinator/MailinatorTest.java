/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mailinator;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Adam
 */
public class MailinatorTest {
    
    //The API key for the tests...
    private static final String API_KEY = "";
    
    public MailinatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInboxMessages method, of class Mailinator.
     */
    @Test
    public void testGetInboxMessages() throws Exception {
        System.out.println("getInboxMessages");
        String apikey = "d27a9becbe5d4a73b893d1fc620d7dfa";
        String emailAddress = "Test@mailinator.com";
        List<InboxMessage> result = Mailinator.getInboxMessages(API_KEY, emailAddress);
        
        assertNotNull(result);
    }

    /**
     * Test of getEmail method, of class Mailinator.
     */
    @Test
    public void testGetEmail() throws Exception {
        System.out.println("getEmail");
        String emailId = "Invitation";
        Email expResult = null;
        Email result = Mailinator.getEmail(API_KEY, emailId);
      //  assertEquals(expResult, result);
        
        System.out.println(result);
    }
    
}
