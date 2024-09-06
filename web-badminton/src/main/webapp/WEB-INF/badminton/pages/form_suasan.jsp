<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Thanh Toán | V Badminton</title>
    <link rel="stylesheet" href="resources/css/thanh-toan.css" />
    <script src="resources/js/dat-san.js"></script>
    <script src="resources/js/thanh-toan.js"></script>
  </head>
  <body>
    <div class="container">
      <header>
        <div class="header-container">
          <div class="logo">
            <a href="<c:url value='/index' />"
              ><img src="resources/images/home/logo.png" alt="V Badminton Logo"
            /></a>
          </div>
          <nav>
            <ul class="menu">
              <li>
                <a href="<c:url value='/Manager_IF' />">Thông tin cá nhân</a>
              </li>
	              <li><a href="<c:url value='/dang-ky-san' />">Đăng kí sân</a></li>
	              <li><a href="<c:url value='/dang-ky-slot' />">Đăng kí slot</a></li>
              <li>
                <a href="<c:url value='/quan-ly-chung' />">Quản lí sân</a>
              </li>
              
          <li><a href="<c:url value='/Admin_add' />">Thêm sân mới</a></li>
              <li><a href="<c:url value='/index' />">Trang chủ</a></li>
            </ul>
          </nav>
        </div>
      </header>
      
        <form action="${pageContext.request.contextPath}/formsuacourt" method="post">
            <div class="slider1">
                <div class="slider-1-container">
                    <h1>Sửa sân</h1>
                    <div class="slider-1-content">
                        <div class="form-group">
                            <label for="customer-id">Mã sân</label>
                            <input type="text" id="customer-id" name="court-id" value="${courtId}" readonly />
                        </div>
                        <div class="form-group">
                            <label for="location">Vị trí</label>
                            <input type="text" id="location" name="location" value="${location}"  />
                        </div>
                        <div class="form-group">
                            <label for="time-of-booking">Từ thời gian</label>
                            <input type="text" id="time-of-booking" name="timestart" value="${timestart}"  />
                        </div>
                        <div class="form-group">
                            <label for="time-of-booking">Đến thời gian</label>
                            <input type="text" id="time-of-booking" name="timeend" value="${timeend}"  />
                        </div>
                        
                        <div class="form-group">
                            <label for="price">Giá tiền</label>
                            <input type="text" id="price" name="price" value="${price}"  />
                        </div>             
                        <button type="submit" name="sua" value="sua">Sửa</button>
                    </div>
                </div>
            </div>
        </form>
     
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
    </div>
  </body>
</html>
