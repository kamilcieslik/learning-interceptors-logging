Feature: Spring api controller bdd

  Background:
    Given baseUri is http://localhost:8080

  Scenario: Should test header
    When I GET /app/rest/services/users/1
    Then response code should be 200
    And response code should not be 401
    And response body should contain {"userId":1,"login":"kamsu","firstName":"M123$","lastName":"Sikora","email":"kamil.sikora@o2.pl","addressId":13,"street":"Wieczysta 80","city":"Wrocław","postalCode":"50-135","country":"Polska"}