package com.adam.util; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;

import java.util.Date;

/** 
* DateTimeUtil Tester. 
* @author: Fanyong Kong
* @since : 11/15/2021
* @version 1.0 
*/ 
public class DateTimeUtilTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: format(Date date, String format) 
* 
*/ 
@Test
public void testFormat() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getYear(Date date) 
* 
*/ 
@Test
public void testGetYear() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getYear(date));
} 

/** 
* 
* Method: getMonth(Date date) 
* 
*/ 
@Test
public void testGetMonth() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getMonth(date));
} 

/** 
* 
* Method: getDay(Date date) 
* 
*/ 
@Test
public void testGetDay() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getDay(date));
} 

/** 
* 
* Method: getHour(Date date) 
* 
*/ 
@Test
public void testGetHour() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getHour(date));
} 

/** 
* 
* Method: getMinute(Date date) 
* 
*/ 
@Test
public void testGetMinute() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getMinute(date));
} 

/** 
* 
* Method: getSecond(Date date) 
* 
*/ 
@Test
public void testGetSecond() throws Exception {
    Date date = new Date();
    System.out.println(DateTimeUtil.getSecond(date));
} 


} 
