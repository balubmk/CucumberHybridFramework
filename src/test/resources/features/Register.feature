Feature: Registration Functionality

Background:
Given User navigates to Register Account page

Scenario: User Registration with mandatory fields
When User enters the details into below fields
|firstName|Arun           |
|lastName |motoori         |
|telephone|1234567890     |
|password |12345           |
And User selects privacy policy Filed
And User clicks on Continue button
Then User Account should get Successfully created

Scenario: User Registration with All fields
When User enters the details into below fields 
|firstName|Arun               |
|lastName |motoori            |
|telephone|1234567890         |
|password |12345              |
And Selects Yes for Newsletter
And User selects privacy policy Filed
And User clicks on Continue button
Then User Account should get Successfully created

Scenario: User Registration without Providing any fields
When User dont enter details any fields
And User clicks on Continue button
Then Warning message Should be displayed for all fields

Scenario: User Registration with duplicate email address
When User enters the details into below fields duplicate Field
|firstName|Arun           |
|lastName |motoori        |
|email    |balucbj@gmail.com  |
|telephone|1234567890     |
|password |12345          |
And Selects Yes for Newsletter
And User selects privacy policy Filed
And User clicks on Continue button
Then Warning message informating the user about duplicate email should be dislpayed
