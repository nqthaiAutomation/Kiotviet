@Loginpage
Feature: Login Page
  Background:
    Given User is on Home page

  @ValidCredentialsIntoManagePage
  Scenario: Login with valid credentials into manage page
    And I click button "Đăng nhập" on the header page
    And I input "dienthoaithongminh02" into address access
    And I click button " Vào cửa hàng " on the popup
    Then I verify form login displayed
    And I input into form login with information below

      | username   | password |
      | 0379099441 | Thai1984   |
    And I click button "Quản lý" on the form login
    Then I verify dashboards is displayed
      | Title                              |
      | Kết quả bán hàng hôm nay           |
      | Doanh thu thuần Tháng này          |
      | Top 10 hàng hóa bán chạy Tháng này |

  @ValidCredentialsIntoSellPage
  Scenario: Login with valid credentials into sell page
#    And I click button "Đăng nhập" on the header page
#    And I input "dienthoaithongminh02" into address access
#    And I click button " Vào cửa hàng " on the popup
#    Then I verify form login displayed
    And I input into form login with information below

      | username   | password |
      | 0379088445 | Thai1984@   |
    And I click button "Bán hàng" on the form login
    Then I verify icons displayed
      | Icon            |
      | Xử lý đặt hàng  |
      | Trả hàng        |
      | Đồng bộ dữ liệu |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    And I click button "Đăng nhập" on the header page
    And I input "<Address>" into address access
    And I click button " Vào cửa hàng " on the popup
    Then I verify form login displayed
    And I input into form login with information below

      | username   | password   |
      | <userName> | <passWord> |
    And I click button "Bán hàng" on the form login
    Then I verify error "<error>" displayed
    Examples:
      | Address    | userName   | passWord | error                            |
      | aa         | 0790994448 | 949469   | Sai tên đăng nhập hoặc mật khẩu. |
      | 0790994448 | 0790994448 | 949461   | Sai tên đăng nhập hoặc mật khẩu. |
      | 0790994448 | 0790994443 | 949469   | Sai tên đăng nhập hoặc mật khẩu. |






