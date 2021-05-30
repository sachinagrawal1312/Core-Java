package com.javainuse.service;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class EmployeePaymentServiceTest_mock {
	
	private int testWrkingDays=25;
	private int testSalaryPerDay=1000;
	private int testSalary=25000;
	private String empId="emp100";
	
	
	@Mock
	private EmployeePaymentService employeePaymentService;
	
	/**
     * Setup before test.
     */
    @BeforeMethod
    public void beforeMethod() {
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetSalary()
    {
    	when(employeePaymentService.getNoOfWorkingDays(anyString())).thenReturn(testWrkingDays);
    	when(employeePaymentService.getSalaryPerDay(anyString())).thenReturn(testSalaryPerDay);
    	when(employeePaymentService.processPay(anyString(), anyInt(), anyInt())).thenReturn(testSalary);
    	
    	int returnedWrkingDays=employeePaymentService.getNoOfWorkingDays(empId);
    	Assert.assertEquals(returnedWrkingDays, testWrkingDays);

    	int returnedSalaryPerDay=employeePaymentService.getSalaryPerDay(empId);
    	Assert.assertEquals(returnedSalaryPerDay, testSalaryPerDay);
    	
    	
    	int returnedSalary=employeePaymentService.processPay(empId,testWrkingDays,testSalaryPerDay);
    	
    	Assert.assertEquals(returnedSalary, testSalary);
    	
    }

}
