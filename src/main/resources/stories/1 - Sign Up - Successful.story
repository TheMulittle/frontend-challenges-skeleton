Meta:
@signUp
@happyPath

Narrative:
As a user
I want to easily Sign Up
So that I can leverage the system usefulness

Scenario: User is able to access the sign up page
Given I navigate to the Home page
And I'm logged out
When I click in the Sign Up link
Then I should see the Sign Up page

Scenario: User is able to register successfuly
When fill the Sign Up page with following information:
|userName  |password  |name         |email         |day  |month   |year  |
|GO        |321645987 |George Orwell|go@oceania.com|21   |December|1984  |
And I try to Sign Up
Then I should see the New Profile page
And I should see the following profile message: Welcome to your new profile page, George Orwell!
And I should see in the Status Bar that I'm logged in as George Orwell (go@oceania.com)
And I should see in the Status Bar that the logout button is available

Scenario: User is not able to register twice
Given I'm logged out
When I click in the Sign Up link
And fill the Sign Up page with following information:
|userName  |password  |name         |email         |day  |month   |year  |
|GO        |321645987 |George Orwell|go@oceania.com|21   |December|1984  |
And I try to Sign Up
Then I should see that I am still in the Sign Up page

Scenario: Just registered user is able to login
Given I'm logged out
When I click in the Login link
And fill the Login page with following information:
|userName|password  |
|GO      |321645987 |
Then I should see the Profile page