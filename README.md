
# 📚 Hệ Thống Quản Lý Nhà Sách (SMB)

![Java](https://img.shields.io/badge/Language-Java-orange)
![Version](https://img.shields.io/badge/Version-1.0-blue)
![License](https://img.shields.io/badge/License-Internal-red)

---

## 📝 Giới Thiệu
**SMB (System for Managing Bookstore)** là một phần mềm quản lý nội bộ dành cho các nhà sách, giúp quản lý xuất nhập hàng, bán hàng, và nhân sự một cách hiệu quả. 

Phần mềm được thiết kế đặc biệt để:
- Quản lý nhân sự với phân quyền theo cấp bậc.
- Quản lý lịch sử duyệt yêu cầu và các thao tác của nhân viên.
- Đơn giản hóa các quy trình nội bộ với giao diện dòng lệnh dễ sử dụng.

---

## 🎯 Tính Năng Chính
1. **Phân Quyền Người Dùng**:
   - **Admin**: Toàn quyền hệ thống, phê duyệt yêu cầu.
   - **Manager**: Quản lý nhân viên, gửi yêu cầu thêm nhân sự, quản lý sách.
   - **Employee**: Thực hiện các thao tác cơ bản như thêm, sửa, xóa sách.

2. **Quản Lý Nhân Sự**:
   - Lưu trữ danh sách nhân sự trong file `List-NV.txt`.
   - Gửi và duyệt yêu cầu thêm nhân viên.
   - Theo dõi lịch sử phê duyệt.

3. **Quản Lý Sách**:
   - Thêm, sửa, xóa sách theo danh mục.
   - Xem danh sách sách theo từng loại.

4. **Lưu Trữ Lịch Sử Hoạt Động**:
   - Ghi nhận và xem lại các yêu cầu, phê duyệt từ quản lý và admin.

---

## ⚙️ Cài Đặt và Sử Dụng

### 1. Yêu Cầu Hệ Thống
- **Ngôn ngữ**: Java (>= 8)
- **IDE**: NetBeans hoặc IntelliJ IDEA
- **File Lưu Trữ**: `List-NV.txt`, `approval_history.txt`

### 2. Cài Đặt
1. Clone repository:
   ```bash
   git clone https://github.com/your-repo/smb-system.git
   cd smb-system
   ```
2. Mở project bằng IDE hỗ trợ Java.
3. Biên dịch và chạy file `SystemManager.java` để khởi chạy hệ thống.

### 3. Hướng Dẫn Sử Dụng
- Đăng nhập bằng thông tin nhân viên từ file `List-NV.txt`.
- Chọn menu phù hợp với quyền hạn của bạn:
  - Nhân viên: Thao tác cơ bản với sách.
  - Quản lý: Thao tác với nhân viên và quản lý sách.
  - Admin: Phê duyệt yêu cầu và quản lý toàn hệ thống.

---

## 🛠️ Kiến Trúc Hệ Thống

### 1. Cấu Trúc Thư Mục
```
src/
├── Book_Management/
│   ├── Grade1TextBooks.java
│   └── ScienceBook.java
├── Decentralization/
│   ├── Admin.java
│   ├── Employee.java
│   ├── Manager.java
│   ├── SystemManager.java
│   ├── User.java
│   └── User_Management.java
├── Function/
│   ├── Book.java
│   └── Product.java
├── Temp_Class/
│   ├── Account.java
│   ├── ActivityLog.java
│   ├── BookStore.java
│   └── ...
└── oop_java_project/
    └── OOP_Java_Project.java
```

### 2. Phân Quyền
- **Admin**:
  - Toàn quyền, phê duyệt yêu cầu.
  - Xem và quản lý lịch sử hoạt động.
- **Manager**:
  - Quản lý nhân viên: gửi yêu cầu thêm, sửa, xóa nhân sự.
  - Quản lý sách.
- **Employee**:
  - Thao tác cơ bản với sách: thêm, sửa, xóa.

### 3. Lưu Trữ Dữ Liệu
- Danh sách nhân sự: `List-NV.txt`.
- Lịch sử phê duyệt: `approval_history.txt`.

---

## 🎥 Demo
Hình ảnh hoặc video demo sẽ giúp minh họa rõ hơn cách hoạt động của phần mềm.

---

## 👨‍💻 Đóng Góp
Nếu bạn muốn đóng góp, hãy:
1. Fork repository này.
2. Tạo branch mới với tính năng của bạn:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit và push thay đổi:
   ```bash
   git commit -m "Add your feature"
   git push origin feature/your-feature-name
   ```
4. Mở Pull Request để gửi yêu cầu merge vào nhánh chính.

---

## 👥 Đội Ngũ Phát Triển
Chúng tôi là một nhóm đam mê công nghệ, cùng nhau phát triển dự án này:
- **Thu-master** (Leader, đóng góp nhiều nhất)
- **Hà Hiệp Thanh**
- **Trần Nguyễn Minh Quân**

---

## 📞 Liên Hệ
- **Tác giả**: Thu-master
- **Email**: [thuvoong@gmail.com](mailto:thuvoong@gmail.com)

---

## 🛡️ Giấy Phép
Phần mềm này được sử dụng nội bộ và không dành cho mục đích thương mại.
