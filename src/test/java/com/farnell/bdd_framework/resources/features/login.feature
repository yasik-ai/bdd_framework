Feature: As a new user, I want to validate login and register functionality on Farnell UI application


Background: User is logged In
		Given User launch browser and navigate to Farnell "https://uk.farnell.com/" site
		When User verify and accepts cookies on the page
		Then User landed on Farnell Home Page

	@regression @functional @positive
	Scenario Outline: As a user I want to register on Farnell Site
		Given User clicks on Register button on home page
		When User enters "<UserName>" and "<Password>" on register page
		And User enters "<FullName>" and "<Email>" on register page
		And User clicks on Register button 
		Then User should register successfully on Farnell application
		
		Examples:
			| UserName 		| Password		 | FullName 		| Email					  |
			| testuser123 | Password123@ | Agile Tester | tester@test.com |		
			

  @functional @positive @regression
  Scenario Outline: As a user I should Login with Valid Credentials
    Given User clicks Login button and navigates to Login page
    And User enters "<UserName>" and "<Password>" on register page
    And User clicks on login button
    Then User should login to the Farnell site and navigate to user accounts summary
    And User should logout from Farnell site
    
    Examples:
			| UserName 		| Password		 | FullName 		| Email					  |
			| testuser123 | Password123@ | Agile Tester | tester@test.com |
			

  @functional @positive @negative @regression
  Scenario Outline: Validate the username auto populates feature when the remember me button is checked
    Given User clicks Login button and navigates to Login page
   	When User enters "<UserName>" and "<Password>" on register page
    And User selects "<RememberMeCheckBoxEnabled>" checkbox and clicks login button
    Then User should login successfully to the Farnell site and navigate to account summary
    When User should logout from Farnell site and retry login
    Then User validates "<RememberMeCheckBoxEnabled>" auto populate username "<UserName>" feature
    
     Examples:
			| UserName 		| Password		 | RememberMeCheckBoxEnabled |
			| testuser123 | Password123@ | Yes											 |
			| testuser123 | Password123@ | No									 	 	   |
			
  
  @negative @regression
  Scenario Outline: User validate login feature with invalid Credentials
    Given User clicks Login button and navigates to Login page
    When User enters "<UserName>" and "<Password>" on register page
   	And User clicks on login button
    Then User should get error message for "<UserName>" and "<Password>" fields
    
    Examples:
			| UserName 		| Password		 | Warning Message 								      		| 
			| test000 		| Password123@ | Please Enter a valid username & password	|
			| 						| 						 | Your username or password is incorrect   |
			




