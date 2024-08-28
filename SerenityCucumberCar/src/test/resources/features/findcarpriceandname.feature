#In this no need to define repeated steps only one declaration is enough
#only implement new steps / can do in different class file in same folder
Feature: Finding Car price and brand names
  As a user i want to find new car price and brand names

  Background:
    #get automatic call before every scenario
    #if we want to repeat some steps then we add it in Background
    Given user navigate to website

  Scenario Outline: User finding car price and brand name

    When user choose menu as new cars
    Then user click on find new cars
    #index start from 1
      |price|
      |2000000|
      |5000000|
      |8000000|
    And user search for "<brand>" car
    And user find car name and price
    Examples:
      |brand|
      | Kia     |
      | Toyota  |
      | Hyundai |
      | Honda   |

