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
              <li><a href="<c:url value='/dat-san' />">Đặt Sân</a></li>
              <li><a href="<c:url value='/thanh-toan' />">Thanh toán</a></li>
              <li><a href="<c:url value='/index' />">Trang Chủ</a></li>
            </ul>
          </nav>
        </div>
      </header>
      <!-- form thanh toán -->
        <form action="${pageContext.request.contextPath}/formthanhtoanTimePlay" method="post">
            <div class="slider1">
                <div class="slider-1-container">
                    <h1>Thông Tin Thanh Toán</h1>
                    <div class="slider-1-content">
                        <div class="form-group">
                            <label for="customer-id">Mã khách hàng</label>
                            <input type="text" id="customer-id" name="customer-id" value="${customer.customerId}" readonly />
                        </div>
                        <div class="form-group">
                            <label for="location">Tên khách hàng</label>
                            <input type="text" id="name" name="name" value="${customer.customerName}" readonly />
                        </div>
                        <div class="form-group">
                            <label for="location">Loại hình thanh toán</label>
                            <input type="text" id="location" value="Chuyển khoản ngân hàng" readonly />
                        </div>
                        <div class="form-group">
                            <label for="location">TimePlay cần mua</label>
                            <input type="text" id="location" name="timeplay" value="${timeplay}" readonly />
                        </div>
                        <div class="form-group">
                            <label for="price">Giá tiền 100k/h</label>
                            <input type="text" id="price" name="price" value="${price}đ" readonly />
                        </div>             
                        <button type="submit" name="thanhtoan" value="thanhtoan">Xác Nhận Thanh Toán</button>
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
