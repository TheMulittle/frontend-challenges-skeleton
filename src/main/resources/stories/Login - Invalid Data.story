Meta:

Narrative:
As an admin
I want to be sure that no one is able to login in the system without valid credentials
So that I can be sure it is secure

Scenario: User is able to access the login page
Given I navigate to the Home page
When I click in the Login link
Then I should see the Login page

Scenario: User cannot login with missing data or invalid data
When fill the Login page with following information:
|userName|password  |
|<user>  |<password>|
And I try to Log In
Then I should see that I am still in the Login page

Examples:
|<user>|<password>|
|      |          |
|admin |          |
|      |hero      |
|not   |existing  |
