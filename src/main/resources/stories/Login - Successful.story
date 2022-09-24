Meta:
@login
@happyPath

Narrative:
As an admin
I want to be sure that no one is able to login in the system without valid credentials
So that I can be sure it is secure

Scenario: User is able to see profile page after logging in
Given I navigate to the Home page
And I'm logged out
When I click in the Login link
And fill the Login page with following information:
|userName|password  |
|<user>  |<password>|
And I try to Log In
Then I should see the Profile page
And I should see the following profile message: <message>
And I should see in the Status Bar that I'm logged in as <loggedAs>
And I should see in the Status Bar that the logout button is available

Examples:
|<user>|<password>|message                             |loggedAs                               |
|admin |hero      |How are you doing, Amazing Admin?   |Amazing Admin (a.admin@wearewaes.com)  |
|dev   |wizard    |How are you doing, Zuper Dooper Dev?|Zuper Dooper Dev (zd.dev@wearewaes.com)|


