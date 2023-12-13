

		LECTURE 172 :-
		
Log4j2 is a logging framework design for java so that we can track
the successful and unsuccessful messages.It can be used in Selenium,
Appium, REST API  framework. Suppose,
	
	->	In every test case I want something like that if the test is
		passed then it will show successful message or if it fails,
		it will show a failure message.
	->	Suppose for package "A" , if all the test cases pass when we 
		will trigger the test, it will deliver a message, otherwise
		it may convey a failure information.
		
	->	I want the time stamp while a test got either the pass mess-
		age or the failure.
		
		LECTURE 173 :- 
		
Now, we are going to follow and download the procedures to use log4j2

		1) Go, to their official web site
		
		"https://www.apache.org/dyn/closer.lua/logging/log4j
		/2.17.2/apache-log4j-2.17.2-bin.tar.gz" 
		
		download the tar.gz file 
		
		2) Now create a project in eclipse 
		
		then click the project-> properties-> java build path -> libraries 
			 -> classpath - add external jars -
			 
			 -> Now add 2 jars from the download file 
			 "log4j2-api-2.17.2" and "log4j2-core-2.17.2"
			 
			 -> version can vary according to the date.
			 
		3) Now, create a class and outside the main method of that class
		
			declare 
			----------------------
			Logger log = LogManager.getLogger(className.class.getName());
			---------------------
			
			* 
			Don't forget to import the classes when we will declare 
			the above to code
			 *
			 
			 ------------------
			 import org.apache.logging.log4j.LogManager;
			 import org.apache.logging.log4j.Logger;
			 ---------------
			 
			 
			 WARNING :-
			 
			 The above code will only print the error or fatal logs, neither
			 info nor the debug messages.
			 
			 -> to get the debug and info logs we need to define an xml
			 log4j2 file which is the heart of log4j2.
			 follow below
			 
			 
			 LECTURE 175 :-
			 
			 
			 GO to the below link, you will get the log4j2 official documents
			 
			 ->https://logging.apache.org/log4j/2.x/manual/configuration.html
			 
			 ---------------------------------
		<?xml version="1.0" encoding="UTF-8"?>
			<Configuration status="WARN">
			
  				<Appenders>
  				
    		<Console name="Console" target="SYSTEM_OUT">
    		
     			 <PatternLayout pattern="%d{HH:mm:ss.SSS} 
     			 [%t] %-5level %logger{36} - %msg%n"/>
    		</Console>
    		
  				</Appenders>
  
  			<Loggers>
  			
   				 <Root level="error">
   				 
      		<AppenderRef ref="Console"/>
      		
    			</Root>
    			
  			</Loggers>
  			
		</Configuration>
		----------------------------------
			
			 WHERE TO LOG?
			 
			 1) We can log in console or in a file.
			 2) Where to log we can found in "Appenders" tag. check above
			 3) [ name ="console" ] we want our log to be printed in console
			 
			 HOW TO LOG?
			 
			 1) In "PatternLayout" tag we define how we want our log to be
			 	displayed. in time specially which seconds, minutes , hours 
			 	the log is logged.
			 	
			 	
			 WHAT TO LOG?
			 
			 1)  what to log defined in the "Loggers" tag. In this "Loggers"
			 	 tag there is "Logger" and "Root" tag subsections.
			 2) In "Root" , Its applicable for entire project.
			 3) In Root tag, there is level which can be "error, "fatal",
			 	"trace". If we put "error" , it will only show the error
			 	logs. And if we put "trace" it will print all types of 
			 	logs like fatal, error, debug, info.
			 
			 
			 LECTURE 176 :- 
			 
			 Now , we need to Create a new package call "resources" and inside
			 this package we will declare an xml file name "log4j2.xml"
			 
			 
			 1) define the "resources" folder in project level.
			 2) create a xml file with the name with "log4j2.xml" inside 
			 	the resources package and save it.
			 2) Now, we have to build the path.
			 	Click on project -> build path -> configure build path
			 	source folder - add folder- click on resource folder. save
			 	it.
			 3) we need to build path to run the the xml file along with 
			 	the project , otherwise it will not run.
			  
			
			->  In "Root" tag it has "level" attribute which can be trace(to
			print all the logs), error(to print error) messages and many more.
			
			
			-> Suppose, I want the error messages of package "A" and all 
			other logs of other packages. How Can I do that ? 
			to do so I need to use "Logger" tag inside my xml file. The
			following code.
			
			----------------------
			<Logger name="packageA.className" 
			level="error" additivity="false">
     		 <AppenderRef ref="Out"/>
    			</Logger>
			
			-----------------------
			 
			 
			 
			-> make sure the additivity="false" otherwise the package
			or test will be run more than one time depending on the xml
			 
			 So the whole code will be ,
			 ------------------------------------
			 
			 <?xml version="1.0" encoding="UTF-8"?>
			<Configuration status="WARN">
			
 			 <Appenders>
    			<Console name="Console" target="SYSTEM_OUT">
      			<PatternLayout pattern="%d{HH:mm:ss.SSS} 
      			[%t] %-5level %logger{36} - %msg%n"/>
    			</Console>
  			</Appenders>
  
  			<Loggers>
    			<Logger name="packageName.className" level="error">
      			<AppenderRef ref="Console"/>
    		</Logger>
    		
    		<Root level="trace">
      			<AppenderRef ref="Console"/>
    		</Root>
  			</Loggers>
		</Configuration>
		----------------------------
			 
			 
			 Let's describe how to write the logs
			 
			 ->Suppose, I want to click a button, So in this case.
			 
			 I have clicked the button(action)	== can be put in debug.
			 clicking colour changed the button(repose)	== can be info.
			 button is not clicked (error)				== can be error.
			 button is missing(missing)					== can be fatal.
			 
			 
			 LECTURE 177 :-
			 
			 "How to write logs in File"
			 
			 -> So , we can write the logs in console, in "Appenders" tag 
			  we used the console tag.
			  
			  ------------
			  
			  
			  <Appenders>
    			<Console name="Console" target="SYSTEM_OUT">
      			<PatternLayout pattern="%d{HH:mm:ss.SSS} 
      			[%t] %-5level %logger{36} - %msg%n"/>
    			</Console>
  			</Appenders>
  			
  			-------------------------
  			
  			
  			-> and to log in file we can put 
  			
  			---------------
			 <?xml version="1.0" encoding="UTF-8"?>
			<Configuration status="WARN">
			
       		<Properties>
				<Property name="basePath">./logs</Property>
			</Properties>
 
  			<Appenders>
  			
      			<RollingFile name="File" 
      				fileName="${basePath}/prints.log" 
      				filePattern="${basePath}/prints-%d{yyyy-MM-dd}.log">
      		
     			<PatternLayout pattern="%d{HH:mm:ss.SSS} 
     			[%t] %-5level %logger{36} - %msg%n"/>
     			
      			<SizeBasedTriggeringPolicy size="500" />
      		
          		</RollingFile>
    		<Console name="Console" target="SYSTEM_OUT">
      
      			<PatternLayout pattern="%d{HH:mm:ss.SSS} 
      			[%t] %-5level %logger{36} - %msg%n"/>
    		</Console>
    		
 			 </Appenders>
  		<Loggers>
   			 <Root level="trace">
      		 <AppenderRef ref="File"/>
    		 </Root>
  		</Loggers>
		</Configuration>
			 
			 -------------
			 
		Here, in above code,
		
			1)	In "Properties" tag there is "Property" where we have
				given "basepath" which will directed to the project
				all the files with "logs" extension
				
				--<Property name="basePath">./logs</Property>---
				
			2)filename will be 
				--fileName="${basePath}/prints.log" ---
				
			 same like from project to directly search for "prints.log"
			 file to store the logs.
			 
			3) If the file size is more than declaration then where the 
			rest of logs will be store ?
			
			To do so,
			-----filePattern="${basePath}/prints-%d{yyyy-MM-dd}.log">--
			
			this file pattern will be followed. from project it will give
			the name with year,month and date then "log" extension
			
			4)
			 --<SizeBasedTriggeringPolicy size="500" />--
			 
			 file size would be 500 kb and if more then it will create a new
			 file with number (3) rules and will store in that file until 
			 500 kb and again will create a new file like a loop until all 
			 the logs are stored in file.
			 
			 5) In "Loggers" tag we can have "Logger" or "Root" tag
			  where there is a tag "<AppenderRef ref="File"/>". if we want 
			   logs in console , write "Console" or if we want in file then
			  write "File".
			  
			  
			  
			  -> Now, Create a new package "logs" in project level
			   and create a text file ( create the package in src then 
			   copy and paste in project level).
			  	with "log" extension.
			  	
			  	-> In Loggers tag there can be a tag "additivity =false"
			  		which means, suppose in a Loggers where I have define
			  		classes to run and level type like any of these such as
			  		debug. And Root level I also define to log fatals
			  		So, When I will run the test it will not run the same test
			  		for Loggers and Root. From defined Logger it will only
			  		log the debugs. If we don't put additivity = false. The 
			  		same test will run for two times.
			  		
			  		LECTURE 178 :-
			  		
			  		Recap of log4j2
			 