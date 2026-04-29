package skyline;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;


/**
* @author Vale Bengolea.
*/

public class SkylineTest {
	
	@Test
	  public void test_0() {
		  //arrange  
		  ArrayList<Building> buildings = new ArrayList<Building>();
		  buildings.add(new Building(1,5,11));
		  buildings.add(new Building(2,7,6));
		
		    
		  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
		  expected.add(new KeyPoint(1,11));
		  expected.add(new KeyPoint(5,6));
		  expected.add(new KeyPoint(7,0));
		 
		  //act
		  List<KeyPoint> skyline = Skyline.skyline(buildings);
		  
		  
		  //assert
	      assertEquals(expected, skyline);
	  }
	
	
  @Test
  public void test_1() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(1,5,11));
	  buildings.add(new Building(2,7,6));
	  buildings.add(new Building(3,9,13));
	  buildings.add(new Building(12,16,7));
	  buildings.add(new Building(14,25,3));
	  buildings.add(new Building(23,29,13));
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(1,11));
	  expected.add(new KeyPoint(3,13));
	  expected.add(new KeyPoint(9,0));
	  expected.add(new KeyPoint(12,7));
	  expected.add(new KeyPoint(16,3));
	  expected.add(new KeyPoint(23,13));
	  expected.add(new KeyPoint(29,0));
	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected, skyline);
  }
  
  

  @Test
  public void test_2() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(0,2,1));
	  buildings.add(new Building(2,4,3));
	  buildings.add(new Building(1,3,2));
	  buildings.add(new Building(3,5,4));
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(0,1));
	  expected.add(new KeyPoint(1,2));
	  expected.add(new KeyPoint(2,3));
	  expected.add(new KeyPoint(3,4));
	  expected.add(new KeyPoint(5,0));
	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(skyline,expected);
  }
  
   
  @Test
  public void test_3() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(0,2,3));
	  buildings.add(new Building(2,5,3));

	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(0,3));
	  expected.add(new KeyPoint(5,0));
	 
	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
  @Test
  public void test_4() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(0,2,1));
	  buildings.add(new Building(2,4,3));
	  buildings.add(new Building(1,3,2));
	  buildings.add(new Building(3,5,4));

	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(0,1));
	  expected.add(new KeyPoint(1,2));
	  expected.add(new KeyPoint(2,3));
	  expected.add(new KeyPoint(3,4));
	  expected.add(new KeyPoint(5,0));


	 
	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
  
  
  @Test
  public void test_5() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(0,2,1));
	  buildings.add(new Building(2,4,3));
	
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(0,1));
	  expected.add(new KeyPoint(2,3));
	  expected.add(new KeyPoint(4,0));


	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
  
  @Test
  public void test_6() {
	  
	  //https://leetcode.com/problems/the-skyline-problem/description/
	  
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(2,9,10));
	  buildings.add(new Building(3,7,15));
	  buildings.add(new Building(5,12,12));
	  buildings.add(new Building(15,20,10));
	  buildings.add(new Building(19,24,8));

	
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(2,10));
	  expected.add(new KeyPoint(3,15));
	  expected.add(new KeyPoint(7,12));
	  expected.add(new KeyPoint(12,0));
	  expected.add(new KeyPoint(15,10));
	  expected.add(new KeyPoint(20,8));
	  expected.add(new KeyPoint(24,0));


	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
   
  
  
  @Test
  public void test_7() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(1,3,1));
	  buildings.add(new Building(2,5,2));
	  buildings.add(new Building(4,7,4));
	  buildings.add(new Building(6,9,1));

	
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(1,1));
	  expected.add(new KeyPoint(2,2));
	  expected.add(new KeyPoint(4,4));
	  expected.add(new KeyPoint(7,1));
	  expected.add(new KeyPoint(9,0));


	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
  
  
  @Test
  public void test_8() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(1,3,2));
	  buildings.add(new Building(2,5,1));
	 
	
	    
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(1,2));
	  expected.add(new KeyPoint(3,1));
	  expected.add(new KeyPoint(5,0));
	
	  	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  //assert
      assertEquals(expected,skyline);
  }
  
  
  @Test
  public void test_example() {
	  //arrange  
	  ArrayList<Building> buildings = new ArrayList<Building>();
	  buildings.add(new Building(0,5,11));
	  buildings.add(new Building(1,8,5));
	  buildings.add(new Building(4,10,13));
	  buildings.add(new Building(12,16,6));
	  buildings.add(new Building(15,25,2));
	  buildings.add(new Building(20,22,19));
	  buildings.add(new Building(23,30,13));
	  buildings.add(new Building(24,29,4));

	  
	  ArrayList<KeyPoint> expected = new ArrayList<KeyPoint>();
	  expected.add(new KeyPoint(0,11));
	  expected.add(new KeyPoint(4,13));
	  expected.add(new KeyPoint(10,0));
	  expected.add(new KeyPoint(12,6));
	  expected.add(new KeyPoint(16,2));
	  expected.add(new KeyPoint(20,19));
	  expected.add(new KeyPoint(22,2));
	  expected.add(new KeyPoint(23,13));
	  expected.add(new KeyPoint(30,0));

	  
	  //act
	  List<KeyPoint> skyline = Skyline.skyline(buildings);
	  
	  
	  //assert
      assertEquals(expected, skyline);
  }
  
  
  
  

}
