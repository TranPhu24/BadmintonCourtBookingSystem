<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home | V Badminton</title>
    <link rel="stylesheet" href="resources/css/style.css"/>
    <link rel="stylesheet" href="resources/css/thongtin.css">
  </head>
  <body>
    <form action="${pageContext.request.contextPath}/formLoginStaff" method="post">
    <div class="container">
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
    <div class="container">
        <img class="profile-pic" src="manager.jpg" alt="Hình ảnh quản lý">
        <div class="info"><strong>UID:</strong> ${id}</div>
        <div class="info"><strong>Số CCCD:</strong> ${cccd}</div>
        <div class="info"><strong>Tên:</strong> ${name}</div>
        <div class="position">Chức vụ: ${role}</div>
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
  </form>
</body>
</html>
