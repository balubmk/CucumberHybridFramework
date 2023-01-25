Feature: Search Functionality

Background:
Given user opens the application

Scenario Outline: Search for a valid product
When user enters valid product into search field <productName>
And user clicks on search button
Then valid product should be displayed in search results
Examples:
|productName|
|HP         |

Scenario Outline: Search for a Invalid product
When user enters Invalid product into search field <InvalidProductName>
And user clicks on search button
Then proper text informing the user about no product matching should be displayed
Examples:
|InvalidProductName|
|honda             |

Scenario: Search Without providing any product
When user dont enters any product into search field
And user clicks on search button
Then proper text informing the user about no product matching should be displayed
