Feature: Publish an article from the website

Background:
	Given A user has landed on the Conduit landing page

@Regression
Scenario Outline: Positive path of Publishing an article
	Given A user has logged in with a username <Email> and a password <password>
	And Verify that the <userName> is correct for the logged-in user
	When A user populates all the fields <Title>, <About>, <Text> and <Tag> and publishes the article
	And Verify that the article is published for this user <userName>
	Then Log out from the application
	And A browser is closed
	
Examples:
	| Email								| password					| userName				| Title				| About			| Text			| Tag			|
	| jovan.kovacevic@hotmail.com		| glupavipassword			| JovanK				| Title01			| About01		| Text01		| Tag01			|
	| testuser@iptiq.com				| test1234					| testuser@iptiq.com	| Title02			| About02		| Text02		| Tag02			|