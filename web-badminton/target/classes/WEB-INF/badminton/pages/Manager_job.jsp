<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý giao dịch</title>
    <link rel="stylesheet" href="resources/css/Manager.css"> 
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
  <header>
    <div class="header-container">
      <div class="logo">
        <a href="<c:url value='/index' />"><img src="resources/images/home/logo.png" alt="V Badminton Logo" /></a>
      </div>
      <nav>
        <ul class="menu">
          <li><a href="<c:url value='/Manager_IF' />">Thông tin cá nhân</a></li>
          <li><a href="<c:url value='/Manager_job' />">Thông tin thanh toán khác hàng</a></li>
          <li><a href="<c:url value='/index' />">Trang chủ</a></li>
        </ul>
      </nav>
    </div>
    
  </header>
      <main></main>
    <div class="container">
        <div class="transaction-history">
            <h2>Lịch sử giao dịch</h2>
            <table id="historyTable">
                <thead>
                    <tr>
                        <th>Mã giao dịch</th>
                        <th>Thời gian giao dịch</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody id="historyBody">
                    
                </tbody>
            </table>
        </div>
        <div class="transaction-form">
            <h2>Nhập thông tin giao dịch</h2>
            <form id="transactionForm">
                <label for="name">Tên:</label>
                <input type="text" id="name" name="name" required>

                <label for="phone">SĐT:</label>
                <input type="tel" id="phone" name="phone" required>

                <label for="id">Mã ID:</label>
                <input type="text" id="id" name="id" required>

                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>

                <label for="note">Ghi chú:</label>
                <textarea id="note" name="note"></textarea>

                <label for="status">Trạng thái:</label>
                <select id="status" name="status">
                    <option value="chua-giao-dich">Chưa giao dịch</option>
                    <option value="da-giao-dich">Đã giao dịch</option>
                </select>

                <button type="button" id="saveButton">Lưu giao dịch</button>
            </form>
        </div>
    </div>
    <div class="container">
      <div class="court-list">
        <h2>Danh sách tất cả các sân cầu lông</h2>
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Vị trí</th>
              <th>Giờ hoạt động</th>
              <th>Giá</th>
            </tr>
          </thead>
          <tbody>
            
            <tr>
              <td>1</td>
              <td>Quận 1, TP.HCM</td>
              <td>06:00 - 22:00</td>
              <td>100,000 VND/giờ</td>
            </tr>
            <!-- Add more rows as needed -->
          </tbody>
        </table>
      </div>
    </div>
</main>
<footer>
  <div class="contact">
    <img src="resources/images/home/logo.png" alt="V Badminton Logo" />
    <div class="contact-fanpage">
      <a href="#"
        ><img src="resources/images/home/facebook.svg" alt="facebook"
      /></a>
      <a href="#"
        ><img src="resources/images/home/instagram.svg" alt="instagram"
      /></a>
      <a href="#"
        ><img src="resources/images/home/tiktok.svg" alt="tiktok"
      /></a>
    </div>
    <div class="contact-letter">
      <a href="<c:url value='/imprint' />">Dấu ấn</a>
      <a href="<c:url value='/privacy-policy' />">Chính sách bảo mật</a>
      <a href="#">Cài đặt</a>
    </div>
  </div>
</footer>  
    <script src="resources/js/Manager.js"></script> 
</body>
</html>
