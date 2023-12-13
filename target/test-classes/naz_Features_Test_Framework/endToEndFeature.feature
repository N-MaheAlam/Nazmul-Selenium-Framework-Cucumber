Feature: Log into Application

	Scenario Outline: Test Validating
		Given Initiate the browser with chrome
		And Navigate to "http://www.qaclickacademy.com/" web site
		And Click to the log in page to log in
		When Enter <username> and <password>
		Then Verify the log in successfulness
		And close browser
		
		Examples:
		|	username								|	passwrod	|
		|	shehanhasan72@gmail.com	|	12345512	|
		|	nazmul2811@diu.edu.bd		|	12345512	|