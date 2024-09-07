<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Thanh Toán | V Badminton</title>
    <link rel="stylesheet" href="resources/css/dat-san.css" />
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
            
              <li><a href="<c:url value='/Customer_IF' />">Thông tin</a></li>
              <li><a href="<c:url value='/list-san-customer' />">Danh sách sân</a></li>
              <li><a href="<c:url value='/dat-san' />">Đặt Sân</a></li>

              <li><a href="<c:url value='/thanh-toan' />">Thanh toán</a></li>
              <li><a href="<c:url value='/index' />">Trang Chủ</a></li>
            </ul>
          </nav>
        </div>
      </header>
      <form action="${pageContext.request.contextPath}/datsanCustomer" method="post">
      <div class="slider-3">
        <div class="slider-3-container">
          <h1>Danh sách cần thanh toán</h1>
          <div class="slider-3-content">     
            <div class="form-group">
              <table>
                <thead>
                  <tr>
                    <th>Mã đặt</th>
                    <th>Vị trí</th>
                    <th>Thời gian sân đã được đặt</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                   <c:forEach var="booking" items="${listBooking}">
		              <tr>
		      			<td>${booking.bookingId}</td>
		      			<td>${booking.court.location}</td>
		      			<td>${booking.slot.startTime}-${booking.slot.endTime}</td>
		      			<td><a href="${pageContext.request.contextPath}/form_thanhtoan?id=${booking.bookingId}">Thanh toán</a></td>
		             </tr>      
		           </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      </form>
       <!-- slider 2 -->
      <section class="slider-2">
        <div class="slider-2-container">
          <div class="slider-2-content">
            <p>
              Nội dung từ Google Maps không thể hiển thị do cài đặt cookie hiện
              tại của bạn. Để hiển thị nội dung này, vui lòng nhấp vào "Đồng ý &
              Hiển thị" để xác nhận rằng dữ liệu cần thiết sẽ được chuyển đến
              Google Maps để kích hoạt dịch vụ này. Bạn có thể tìm thêm thông
              tin trong
              <a href="/pages/privacy-policy.html">Chính sách bảo mật</a> của
              chúng tôi. Bạn đã thay đổi quyết định? Bạn có thể thu hồi sự đồng
              ý của mình bất kỳ lúc nào thông qua
              <a href="#">cài đặt cookie</a> của bạn.
            </p>
            <button id="consentButton">Đồng ý & hiển thị</button>
          </div>
        </div>
      </section>
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
