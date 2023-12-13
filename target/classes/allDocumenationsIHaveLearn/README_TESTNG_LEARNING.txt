

	"Lecture 130"

TestNG is one of the most useful tool to have the control 
of executions of test cases. Its also called Testing Framework.

-> Suppose , I want to run test case 10 but before running 10, I have to 
run test case 4,7,9. By TestNG I can set the priority I mean which will
run first and which test cases should before running a certain test case.

-> Suppose, my client want to run 30 test cases out of 500 test cases which 
is  as smoke test. So, with in a single click, I can run 30 test cases with 
the help of TestNG.

-> I want to run some specific test cases , So I can set my test cases with
 the help of TestNG testing Framework.
 
 
 	  "Lecture 131"
 	  
	 INSTALL TESTNG: -
	 
 	 On Eclipse.
 	 -> click -help-> Eclipse Market Place -> Search for "TestNG"-> install
 	  click on next, next , then finish
 	 
 	 -> to check weather testNG is installed or not, on eclipse 
 	   click on "preferences" , then you might see the folder TESTNG
 	   
 	 
 	 -> Now , create a new  java project  and then a  class without main method
 	  cause TestNG it self is a java compiler , So we don't need to create 
 	  a main method to run any test cases in console, we can do it by 
 	  testNG 
 	  
 	  
 	   "Lecture 131"
 	   
 	  TEST EXECUTION: -
 	  
 	  -> TestNG always executes its tests in methods 
 	  
 	  So, to declare a method we should use a void type method which will
 	  return nothing like below example
 	  	 		
 	  	 		
 	  	 		"@Test
 	  	 		public void testCaseName(){
 	  	 		 // write test commands
 	  	 		}"
 	  	 		
 	  	 		 -> here "@Test" is a annotation which says that 
 	  	 		 the below method is a test 
 	  	 		
	-> To run the above test in a class we need to bring the "TestNG" library
	 and TestNg packages. when we will write "@Test" , automatically 
	 it will show to import TestNG Library and then to import testNG 
	 annotation.
	 
	 
	 "Lecture 132"
	 
	 CRETATING XML FILE : -
	 -> When we want to create xml file for testNG we have to do 
	  -> click on exact class or project then, " click TESTNG 
	  -> then click " convert to TestNG" 
	  
	   Hirachy of xml file is 
	    suite = suppose , I am working with a bank , So bank has 
	    		credit card, debit card, loan department( this
	    		are different module). So , I created a
	    		suite which will have only the the tests about loan.
	    test  = suppose, loan has multiple section like, personal loan, home
	    		loan, business loan, mortgage loan. So , I created a test
	    		which will have test cases for personal loan.
	    		
	    classes = In Classes tag we define the class classes
	    
	    class   = Here, we define individual java class and each class
	    			consists of tests
	    			
	    methods = inside class we put methods tag where we define our
	    		  method individually.
	    method  = which method should run and which not we can define it.
	    		  in 
	    		  <method> exclude = "methodName"</method>
	    		-> this method will not run.
	    		
	    		And
	    		<method> include = "methodName"</method>
	    		 -> only this method will run and you will not run the other 
	    		 test method of that class where we have defined them.
	    		
	   TIPS_01 =
	   
	   " when you are creating test cases use the module name for each
	   such as , for mobile module , define modile_testCase01, 
	   modile_testCase_02 and for suppose web define , wed_loginTest01, 
	   web_navigation_bar_Test_02". We should always give a relative name
	   to for each tests so that we can segregate and if we can then  run
	   and if we don't then don't run.
	   
	   
	   Lecture 135: 
	   
	   REGEX FOR TESTS: -  
	    
	    -> Suppose there are 100 test cases with the name of modile01, modile02
	    
	    mobile03.......
	     so I don't want to run the test cases that are related to mobile
	     So, I will do like this below 
	     
	     <exclude name ="mobile.*"/>
	     
	     -> This will run all the test cases except which name start with
	     	"mobile"
	     	
	    TIPS_02 =
	    
	    "xml" should be always in project level, I mean we should declare
	    in Project level, not in package or class level or in other folders"
	    
	    
	    HOW TO RUN A WHOLE PACKAGE? 
	    
	    -> to run a whole or multiple package we can do this like below way,
	    
	    inside that "test" tag
	  -------------------------  
	    <test name = "test 01">
	    
	    <packages>
	    <package name ="packageName01">
	    <package name ="packageName02">
	    </packages>
	    </test>
	   -------------------------
	   
	   This will run the whole package.
	   
	   -> when we want to run regression testing , we can put all the 
	    test cases and their belonging classes in a single package 
	    and can run by above way.
	    
	    
	    LECTURE 136
	    
	    ANNOTATIONS: -
	    
	    @BeforeTest: -
	    
	    -> In xml file we have "test" tag. there can be multiple things
	    like , packages, classes. if we declare BeforeTest tag 
	    it will run before all the test cases of that specific test tag block
	    then the test cases will run one by one. remember there are multiple
	    tests in an xml file 
	    
	    @AfterTest:-
	    
	    This is reverse I mean at the end it will run. Before Test will be 
	    only for the test folder ( only one test tag in which class the
	    before test is defined)but in xml file there can be multiple tests 
	    so it belongs to only defined certain test
	    
	    LECTURE 137
	    
	    ANNOTATIONS: -
	    
	    @BeforeSuite
	    
	    -> execute before all the test cases of an specific xml file. scope is
	    entire xml file
	    
	    @AfterSuite
	    
	    -> Execute after an xml file no matter in after which class of that
	    specific test you declare
	    
	    
	    @BeforeMethod:-
	    
	    -> This is will execute before every method of that specific class
	    where it is mentioned 
	    
	    @AfterMethod
	    
	    -> -> This is will execute after every method of that specific class
	    where it is mentioned 
	    
	    @BeforeClass:-
	    
	    -> This is will execute before class of that specific class
	    where it is mentioned 
	    
	    @AfterClass
	    
	    -> -> This is will execute after class of that specific class
	    where it is mentioned
	    
	    
	    TIPS_03:-
	    In TestNG orders of your test methods depends on the alphabetic 
	    order. Make Sure your test methods for each class are alphabetically
	    order.
	    
	    
	    groups: -
	    
	    -> suppose when we want to run some specific test cases from different
	    classes those time we will use groups tag and how to use it ? 
	    see below 
	    
	     FIRST, 
	     In every test which I want to run after the @Test Annotation
	      show full tag 
	     ----------------------------- 
	      @Test(groups ={"groupName"}
	     -----------------------------
	     
	     SECOND,
	     
	     Declare all the class in my specific xml file and inside in a "test"
	     tag 
	     
	     ----------------
	     
	     <test>
	     <classes>
	     <class name ="packageNAme.className"/>
	     <class name ="packageNAme.className"/>
	     <class name ="packageNAme.className"/>
	     </classes>
	     </test>
	     -----------------
	     
	     Third, now We have to declare the "groups" like below way 
	     
	     -------------------
	     
	     ----------------
	     
	     <test>
	     
	     <groups>
	     	<run>
	     		<include = "groupName"/>
	     	</run>
	     </groups>
	     <classes>
	     <class name ="packageNAme.className"/>
	     <class name ="packageNAme.className"/>
	     <class name ="packageNAme.className"/>
	     </classes>
	     </test>
	     -----------------
	      
	     Lecture 139 :- 
	     
	    @Test(dependsOnMethod ={"method01", "method02"})
	     
	     In below code , where method_03 is depending on method 01 and
	     method_02 which means to execute method_03 first method_01 &
	     method_02 need to execute first.
	     -----------------
	    @Test(dependsOnMethods = {"method01", "method_02" })
	    public void metho_03(){
				    
				    System.out.println("Something"
				    }
	    ------------------
	    
	    
	    @Test(enable =true/false)
	    
	    ----------------
	    @Test(enable = false)
	    public void testName01(){
	    
	    // tests 
	    }
	    ------------
	    
	    -> here , this above test will be disabled when we will invoke
	    the class or xml file for test.
	    
	    -> we can also make it (enable="true") which is vsversa means
	    it will run the test.
	    
	    
	    timeOut = miliseconds
	    
	    -> when I want wait few seconds to load or to execute my test
	    those time , I can use timeOut attribute in @Test annotation
	    
	    
	    Lecture 140 :-
	    
	    ---------------
	    @Parameters({"URL"})
	    @Test
	    public void testName01(String url){
	     System.out.println(url) // this will print the Parameter URl
	    // tests 
	    }
	    --------------
	    Suppose we have some global variable which we will use in every 
	    test case so that's why we use parameters or data provider to 
	    invoke the variable. For parameter, to declare and call the global 
	    variables first we need to put parameter in xml file a the tag where 
	    we want to use the variable. If the parameter is specific to a 
	    particular folder, then the parameter is applied within that tag
	    (suppose test tag, or in class tag or method tag also we can use).
	    If the parameter is specific to a particular folder, 
	    then the parameter is applied within a tag.
	    So, <parameter name ="URL" value="google.com"/> this line we need 
	    to put this line xml file  and the above @Parameters is used in 
	    the test.
	    
	    <parameter name ="URL" value="google.com"/>
	    
	    Lecture 141 & 142 :-
	    
	    @DataProvider
	    
	    --------------
	    @DataProvider
	    public Object[] getData(){
	    	Object[][] data = new Object[3][2];// 3 row , 2 column
	    	
	    	data[0][0] = "nazmul";
	    	data[0][1] = "12345";
	    	
	    	data[1][0] = "mahe";
	    	data[1][1] = "23456";
	    	
	    	data[2][0] = "alam";
	    	data[2][1] = "32244";
	    	
	    	return data;
	    	
	    		    }
	    ------------------
	    -> define this method into the class where we want to use this
	     data.
	     
	     Now, call this data provider into the method where we want to use
	     
	     ---------------------------
	     
	     @Test(dataProvider="getData")
	     public void TestCaseForDataPRoivder(String user, String pass){
	     	System.out.println(user);
	     	System.out.println(pass);
	     // here the "user" is coming from "getData" method 
	     as well as the "pass".
	     }
	     ---------------------------
	     
	     -> TestCaseForDataPRoivder test case will run for 3 times 
	     with new different types of data that we have defined in 
	     "getData" method. just check it.
	     
	     
	   TIPS_04: - 
	   If I run the test from class level it may show error if there are
	   some dependencies in xml file. Such as, if parameter values comes from
	   the xml file.
	   
	   
	   Lecture 143 :- 
	   
	   TestNG Listeners: -
	   
	   "ITestListener" is an interface which has some methods and we need 
	   to override it and these methods are such as "OnTestStart", 
	   "OnTestSuccess", "OnTestFailure", "OnTestSkipped". 
	   what message should the test show if it is successfully executed,
	   should it take any screen short when it fails, what message 
	   should show if the test case is skipped and so on. we can define
	   these methods in our own needs of way. 
	   
	   -> So, after implementing the class, we need to run the new implemented
	   Listeners class right. So How will we tell it to the console?
	   The answer is, we have to define this listeners class in our xml 
	   file. So the code is for that
	   
	   -----------------
	   <listeners>
	   	<listener class-name="packageName.className" />
	   </listeners>
	   -------------------
	   
	   Lecture 144: -
	   
	   "onTestFailure" in a method which has come from ITestListener interface
	   and has a  ITestResult argument "result" which help to find out for
	   which test it is showing failure. use "result.getName()" to find
	   the failure method.
	   
	   
	   -> In test's xml file, one by one test is run but if I want to run
	    multiple tests or all together I can use , (parallel ="tests") , 
	    (thread-count ="2") in suite level of the xml file.
	    
	    	-> Here, thread-count is how many tests I want to run together
	    	
	    
	    Lecture 146 :- 
	    
	    "Global Declaration"
	    
	    -> Suppose I have a file from where I will call my global variables
	    	in my test cases.
	    	
	    	-> To do so, I have to create a file in the project , specially 
	    	in the package where I have declared my classes.
	    	
	    	"Properties" class
	    		-> This properties class we use to access in file. But first,
	    		we have created a file which extension will be like
	    		"fileName.properties" where we will declare the keys and 
	    		values ("key = value" like "browser = chrome")
	    		
	    	Now, declare 
	    	
	    	---------------------
	    	
	    	Properties prop = new Properties();
	    	FileInputStream file = new FileInputStream("location of the file");
	    	prop.load(file);
	    	prop.getProperty("browser");
	    	
	    	prop.setProperty("browser", "firefox");

			System.out.println(prop.getProperty("browser"));
			
			/* 
			In output the file browser name will be firefox but it 
			will not store or modify the file" 
			To Do so, check the below code
			*/
	    	
	    	---------------------
	   
	   		-> "FileInputStream" is a class in java by which we can read 
	   			a file.
	   			
	   		-> Now If we want to write in a file then we need to use a 
	   		different class which is called "FileOutputStream"
	   		
	   		------------------------
	   		
	   		FileOutputStream fos =
	   		new FileOutputStream("source path");

			prop.store(fos, null);
	   		-----------------------
	   	-> Now, If I modify any thing in the file , it will be stored
	   	 through the "prop" object but make sure we store the new 
	   	 FileOutputStream object(fos);
	   
	   
	    