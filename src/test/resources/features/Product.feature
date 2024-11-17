@Procedure
Feature: Pocedure page

  Background:
    Given  I login susses

  @SC01
  Scenario: Show all procedures
    When I select menu "Hàng hóa -> Danh mục"
    Then I verify page "Hàng hóa" displayed
    And I verify textbox search displayed
    And I verify buttons "Thêm mới->Import->Xuất  file" displayed
    And I verify type filters "Loại hàng -> Nhóm hàng -> Tồn kho -> Bán trực tiếp -> Ngày dự kiến hết hàng -> Nhà cung cấp -> Bảo hành, bảo trì -> Vị trí -> Liên kết kênh bán -> Lựa chọn hiển thị" displayed
    And I verify table with title column "Mã hàng -> Tên hàng -> Giá bán -> Giá vốn ->Tồn kho -> Khách đặt -> Dự kiến hết hàng"
    And I verify list procedure is displayed

    When I input "Kem" into textbox search
    Then I verify procedure have name contains "Kem" is displayed on the list

    When I select menu "Hàng hóa -> Thiết lập giá"
    Then I verify page "Bảng giá chung" displayed
    And I verify buttons "Xuất  file" displayed
    And I verify type filters "Bảng giá -> Nhóm hàng -> Tồn kho ->Giá bán" displayed
    And I verify table with title column "Mã hàng -> Tên hàng -> Giá vốn	 -> Giá nhập cuối	->Giá chung"

    When I select menu "Hàng hóa -> Phiếu bảo hành"
    Then I verify page "Phiếu bảo hành bảo trì" displayed
    And I verify buttons "Xuất  file" displayed
    And I verify type filters "Thời gian mua hàng-> Trạng thái bảo hành-> Hết hạn bảo hành ->Lịch bảo trì" displayed
    And I verify table with title column "Mã hàng -> Tên hàng -> Serial/IMEI/Biển số	 -> Hóa đơn mua	->Khách hàng->Bảo hành tối đa->Bảo trì định kỳ"

    When I select menu "Hàng hóa -> Kiểm kho"
    Then I verify page "Phiếu kiểm kho" displayed
#    And I verify textbox search displayed
    And I verify buttons "Kiểm kho->Xuất  file" displayed
    And I verify type filters "Thời gian-> Trạng thái-> Người tạo" displayed
    And I verify table with title column "Mã kiểm kho->Thời gian-> Ngày cân bằng->SL thực tế->Tổng thực tế->Tổng chênh lệch->SL lệch tăng->SL lệch giảm->Ghi chú"


  @SC02
  Scenario: Add new procedure
    When I select menu "Hàng hóa -> Danh mục"
    And I select button "Thêm mới-> Thêm hàng hóa"
    And I input into form with information below
      | Tên hàng:TXT | Giá vốn:NUMBER | Nhóm hàng:OPTION | Giá bán:NUMBER | Tồn kho:NUMBER | Trọng lượng:NUMBER | Bán trực tiếp:CHECKBOX | Upload:IMAGE                      |
      | TestA        | 5000           |  Phụ kiện Nam       | 500000         | 2000           | 20                 | false                  | src/test/data/SCPRO01/Capture.JPG |
    And I click button "Lưu" on the bottom
    Then I verify procedure "TestA" is added susses

  @SC03
  Scenario: Delete Procedure
    When I select menu "Hàng hóa -> Danh mục"
    And I input "TestA" into textbox search
    And I expand first procedure
    And I click button "Xóa" on the table
    And I click button "Đồng ý" on the bottom
    Then I verify procedure deleted

  @SC04
  Scenario: Add new Categor procedure
    When I select menu "Hàng hóa -> Danh mục"
    And I select button "Thêm mới-> Thêm hàng hóa"
    And I input into form with information below
      | Mã hàng:TXT |Tên hàng:TXT |
    |   NU016          |        |
    Then I verify message error "Mã hàng: NU016 đã tồn tại" displayed
    When  I input into form with information below
      | Mã hàng:TXT |Tên hàng:TXT |
      |   NU016A          |        |
    And I click button "Lưu" on the bottom
    Then I verify message error "Vui lòng nhập Tên hàng trước khi lưu" displayed
    When  I input into form with information below
      | Mã hàng:TXT |Tên hàng:TXT |
      |   NU016          | TestA       |
    And I click button "Lưu" on the bottom
    Then I verify message error "Vui lòng chọn Nhóm hàng hóa." displayed

    When I input into form with information below
    |Giá vốn:NUMBER|
    |  Test            |
    Then I verify field "Giá vốn" has value ""
    When I input into form with information below
      |Giá vốn:NUMBER|
      |  80000            |
    Then I verify field "Giá vốn" has value "80,000"
    When I input into form with information below
      |Giá bán:NUMBER|
      |  Test            |
    Then I verify field "Giá bán" has value ""
    When I input into form with information below
      |Giá bán:NUMBER|
      |  80000            |
    Then I verify field "Giá bán" has value "80,000"
    When I input into form with information below
      |Tồn kho:NUMBER|
      |  Test            |
    Then I verify field "Tồn kho" has value ""
    When I input into form with information below
      |Tồn kho:NUMBER|
      |  80000            |
    Then I verify field "Tồn kho" has value "80,000"
    When I input into form with information below
      |Trọng lượng:NUMBER|
      |  Test            |
    Then I verify field "Trọng lượng" has value ""
    When I input into form with information below
      |Trọng lượng:NUMBER|
      |  80000            |
    Then I verify field "Trọng lượng" has value "80,000"
    When I click button add new of field "Nhóm hàng"
    And I click button "Lưu" on the dialog
    Then I verify message error "Vui lòng nhập tên nhóm hàng trước khi lưu" displayed
    And I input into form with information below
    |Tên nhóm:TXT|
    |Phụ kiện Nam            |
    And I click button "Lưu" on the dialog
    Then I verify message error "Nhóm hàng: Phụ kiện Nam đã tồn tại" displayed









