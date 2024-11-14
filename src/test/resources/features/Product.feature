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
      | TestA        | 5000           | Trang điểm       | 500000         | 2000           | 20                 | false                  | src/test/data/SCPRO01/Capture.JPG |
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
#    And I click button add new of field "Nhóm hàng"
#    And I input into form with information below
#      | Tên nhóm:TXT | Nhóm cha:OPTION |
#      | aaa5         | Mỹ phẩm         |
#    And I click button "Lưu" on the dialog
#    Then I verify message success "Cập nhật dữ liệu thành công" displayed
#
#    And I click button add new of field "Nhóm hàng"
#    And I input into form with information below
#      | Tên nhóm:TXT | Nhóm cha:OPTION |
#      | aaa5         | Mỹ phẩm         |
#    And I click button "Lưu" on the dialog
#    Then I verify message error "Nhóm hàng: aaa5 đã tồn tại" displayed
#    And I click button "Bỏ qua" on the bottom
    And I click button add new of field "Thương hiệu"
    And I input into form with information below
      | Tên thương hiệu:TXT |
      | aaa5                |
    And I click button "Lưu" on the dialog
    Then I verify message success "Cập nhật dữ liệu thành công" displayed

    And I click button add new of field "Thương hiệu"
    And I input into form with information below
      | Tên thương hiệu:TXT |
      | aaa5                |
    And I click button "Lưu" on the dialog
    Then I verify message error "Nhóm hàng: aaa5 đã tồn tại" displayed







