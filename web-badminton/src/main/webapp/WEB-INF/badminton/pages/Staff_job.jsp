<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dynamic Calendar</title>
    <link rel="stylesheet" href="resources/css/Staff.css">
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
              <li><a href="<c:url value='/Staff_IF' />">Thông tin cá nhân</a></li>
              <li><a href="<c:url value='/check-in' />">Check in</a></li>
              <li><a href="<c:url value='/index' />">Trang chủ</a></li>
            </ul>
          </nav>
        </div>
        
      </header>
      <main>
        <div class="calendar-container">
          <!-- Calendar Controls -->
          <div class="calendar-controls">
            <label for="month-select">Chọn tháng:</label>
            <select id="month-select"></select>
            
            <label for="year-select">Chọn năm:</label>
            <select id="year-select"></select>
          </div>
          
          <!-- Calendar Table -->
          <table id="calendar" class="calendar-table">
            <thead>
              <tr>
                <th>Thứ 2</th>
                <th>Thứ 3</th>
                <th>Thứ 4</th>
                <th>Thứ 5</th>
                <th>Thứ 6</th>
                <th>Thứ 7</th>
                <th>Chủ nhật</th>
              </tr>
            </thead>
            <tbody id="calendar-body">
            </tbody>
          </table>
        </div>
      
        <div class="container">
          <div class="staff-admin-list">
            <h2>Danh sách Staff và Admin</h2>
            <table>
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Vị trí</th>
                  <th>Ngày-tháng-năm</th>
                  <th>Giờ đầu</th>
                  <th>Giờ cuối</th>
                  <th>Trạng thái</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Admin</td>
                  <td>01-01-2024</td>
                  <td>08:00</td>
                  <td>17:00</td>
                  <td>Hoạt động</td>
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

    <script src="resources/js/Staff.js"></script>
</body>
</html>
