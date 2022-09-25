Meta:
@authentication

Narrative:
As an user
I want to be able to login via Spotify
So I can use the application

Scenario: User is able to log in using Spotify
Given I am not authenticated
And I am in the Home page
When I click in the Login button
And I login with user 'democratic.test.user@gmail.com' and its password
Then I land in the Playlist page

Scenario: User is able to go to Login page if they are already logged in
Given I am authenticated
And I am in the Home page
When I click in the Login button
Then I land in the Playlist page

Scenario: User is not able to access pages without authentication
Given I am not authenticated
When I navigate to Playlist page
Then I land in the Home page

