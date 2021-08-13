# codeChallenge003MohammadSalloumRepository
TITLE: CODE CHALLENGE 003
DATE: 12-08-2021 
AUTHOR: MOHAMMAD SALLOUM
COMPANY: AREEBA 
UNDER REQUEST OF: AHMAD EZZ
************************************************************************************
DESCRIPTION

*This backend project contains:
- 1 mobileNumber validation API
- Customer model + CRUD operation
- Small testing scenario
*The project is linked to a postgress database (codeChallenge003Database) which is updated according to JPA and hibernate.
*Database setup in applications.property file, and any added dependency is placed in build.gradle file.
************************************************************************************
API EXPLANATION

*Mobile validation API:
using a webClient, we call a 3rd party API and we pass to it the mobileNumber as a parameter in the url. This API returns a JSON object
in its response body, so in order to extract it, we used BodyToMono method and passed a model (Response.class) of similar fields to extract
JSON object into a Response Instance and then we can return the fields' values that we want in the ResponseEntity.

*Customer CRUD API:
The create API first checks if the mobileNumber is valid, then it save it in database.
The update API is similar to that of create but in the customer object we specify the id so that it changes in database.
The delete API deletes based on customer Id which is passed on in the url.
GetAll API which fetches back all customers.
************************************************************************************
TESTING

For simplicity only the customer model is tested using AssertEquals method.
APIs can be tested using REST Assured later...
************************************************************************************
