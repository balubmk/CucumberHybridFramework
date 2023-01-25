Feature: User Login
Registered user should be able to login to access account details

Background:
Given User Navigate to Login Page


Scenario Outline: Login With Valid Credentials
When User enters valid Email Addess <email>
And Enters valid Password <password>
And clicks on Login button
Then User should successfully Login
Examples: 
|email                 |password|
|amotooricap9@gmail.com|12345   |
|amotooricap3@gmail.com|12345   |
|amotooricap1@gmail.com|12345   |
 
Scenario: Login With Invalid Credentials
When User enters Invalid Email Addess 
And Enters Invalid Password "4155"
And clicks on Login button
Then User get a warning message
 
Scenario: Login With valid Email Invalid password
When User enters valid Email Addess "balucm.krish@gmail.com"
And Enters Invalid Password "4155"
And clicks on Login button
Then User get a warning message
 
Scenario: Login With Invalid Email valid password
When User enters Invalid Email Addess
And Enters valid Password "1234"
And clicks on Login button
Then User get a warning message
 
Scenario: Login Without filling any details
When user dont provide any details
And clicks on Login button
Then User get a warning message
 