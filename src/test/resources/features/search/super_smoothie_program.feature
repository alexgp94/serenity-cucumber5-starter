Feature: Super Smoothie Loyalty Card Program
  The more smoothies you buy, the more points you earn.

  Background:
    Given The following drink categories:
      | Drink              | Category | Points |
      | Apple and Kale     | Regular  | 15     |
      | Triple Berry Blend | Fancy    | 20     |
      | Earl Gray          | Tea      | 10     |

  Scenario Outline: Earning point when purchasing smoothies
    Given Alex is a Morning Freshness Member
    When Alex purchases <Quantity> <Drink> drinks
    Then He should earn <Points> points
    Examples:
      | Drink              | Quantity | Points |
      | Apple and Kale     | 2        | 30     |
      | Triple Berry Blend | 1        | 20     |
      | Earl Gray          | 3        | 30     |


















