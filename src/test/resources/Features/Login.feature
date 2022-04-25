Feature:Login Functionality



Background:
Given user should navigate url "http://localhost:100"

Scenario: Valid login
Given user should navigate url "http://localhost:100"
Then login page should be appear
When User enters valid userid and valid password
And click on login button
Then user should be navigated to home page
And can see logout link appear on top right corner

@only
Scenario Outline: InValid login
#Given user should navigate url "http://localhost:100"
Then login page should be appear
When User enters Invalid userid "<userid>" and Invalid password "<password>"
And click on login button
#Then user should be navigated to home page
#And can see logout link appear on top right corner
Examples:
|userid | password |
|ad123   | pwd1     |
|ad124   | pwd2     |
|ad125   | pwd3     |

@Invalid
Scenario: InValid login
#Given user should navigate url "http://localhost:100"
Then login page should be appear
When User enters Invalid userid "<userid>" and Invalid password "<password>" and click login
|userid  | password |
|ad123   | pwd1     |
|ad124   | pwd2     |
|ad125   | pwd3     |


#And click on login button
#Then user should be navigated to home page
#And can see logout link appear on top right corner






