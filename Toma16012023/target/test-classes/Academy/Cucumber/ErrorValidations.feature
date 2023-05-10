Feature: Publish an article from the website

Background:
	Given A user has landed on the Conduit landing page

@ErrorHandling
Scenario Outline: Wrong credentials used for the login - wrongEmail and validPassword
	Given A user has tried to login with a wrong Email <wrongEmail> and/or a wrong password <validPassword>
	Then Verify that the user has not logged in successfully and the message "email or password is invalid" is displayed
	And A browser is closed
	
Examples:
	| validEmail						| validPassword				| wrongEmail				| wrongPassword				| 
	| jovan.kovacevic@hotmail.com		| glupavipassword			| wrong@hotmail.com			| wrongPassword01			|
	| testuser@iptiq.com				| test1234					| wrong@iptiq.com			| wrongPassword02			| 
	
	
	
	

@ErrorHandling
Scenario Outline: Wrong credentials used for the login - validEmail and wrongPassword
	Given A user has tried to login with a wrong Email <validEmail> and/or a wrong password <wrongPassword>
	Then Verify that the user has not logged in successfully and the message "email or password is invalid" is displayed
	And A browser is closed
	
Examples:
	| validEmail						| validPassword				| wrongEmail				| wrongPassword				| 
	| jovan.kovacevic@hotmail.com		| glupavipassword			| wrong@hotmail.com			| wrongPassword01			|
	| testuser@iptiq.com				| test1234					| wrong@iptiq.com			| wrongPassword02			| 