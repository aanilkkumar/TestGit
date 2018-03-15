GlobalLogic
===========

Requirement
-----------
A credit card company has to provide a tool to its customers to predict the next month bill amount based on simple average of the previous bills. The input to this tool will be a json received from its CRM system, which contains basic customer information and the previous bills. The json data is available from following URL: 

https://demo2020174.mockable.io/getBills

The tool will parse the json and calculate the next month's bill amount, bill date and due date after last available month in the json data. For example if json response has latest bill of Mar-2018, next bill should be Apr-2018.

The input will be a single date. Bills with bill date after this date only should be considered for prediction. 
In addition, bills for which the bill amount is greater than zero in CRM system data, only should be considered for prediction.

The output should be in following format:
Next Bill Amount: <amount>
Next Bill Date: <date>
Due Date: <date>

The code written should be of good quality and will be strictly evaluated on following aspects:
•         Code should compile and should be complete.
•         Should use Abstraction.
•         Should handle all exceptions and cases.
•         Identify the junit test cases and mention them in comments over the main method of your application.
If any of the above evaluation criteria is not fulfilled, no further evaluation will be done.


Technical Design
================

Prequisites:
1.  Java 8
2.  IDE

Architechture
=============

API is designed to predict the bill based on the date given. Spring boot microservice is written
for production ready code and can be scaled easily whenever required. All
the exceptions and boundary conditions are taken care. RestTemplate is used to get the data 
from the given API.

Documentation
=============

Swagger is used for API documentation and output samples can be viewed under "sample output" folder.

Testing
=======
Unit Test: Junit tests are written to cover the methods including exceptional cases.

Functional Test: Swagger is used to test the functionality