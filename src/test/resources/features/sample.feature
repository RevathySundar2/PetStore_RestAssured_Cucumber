Feature:
@SampleLearning
  Scenario: Learning to parse a json response
    Given Read the sample request
    When Parse the payload
    Then Assert the userdetails with the database
