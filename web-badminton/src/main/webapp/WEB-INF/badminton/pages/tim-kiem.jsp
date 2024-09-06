<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Check in | V Badminton</title>
    <link rel="stylesheet" href="resources/css/check-in.css" />
    <script src="resources/js/dat-san.js"></script>
    <script src="resources/js/tim-kiem.js"></script>
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
              <li><a href="<c:url value='/index' />">Trang Chủ</a></li>
              <li><a href="<c:url value='/tim-kiem' />">Tìm kiếm</a></li>
              <li>
                <a href="<c:url value='/ve-chung-toi' />">Về Chúng Tôi</a>
              </li>
              <li>
                <a
                  href="<c:url value='/login' />"
                  style="border: 2px; color: aqua"
                  >Đăng nhập</a
                >
              </li>
            </ul>
          </nav>
        </div>
      </header>
      <!-- slider 1 -->
      
          <form action="${pageContext.request.contextPath}/timkiemGuest" method="post">
      <div class="slider-1">
        <div class="slider-1-container">
          <h1>Khách hàng</h1>
          
          <div class="slider-1-content">
            <div class="form-group">
              <label for="location">Tìm kiếm sân:</label>
              <select id="location" name="location">
              <option value="">Vị trí ------ Giờ hoạt động ------ Giờ có thể vào chơi</option>
                <c:forEach var="court" items="${listCourt}">
		                <c:forEach var="slot" items="${listSlot}">		                    
		                    <option value="${court.courtId}-${slot.slotId}">${court.location}  |  ${court.startTime} - ${court.endTime}  |  ${slot.startTime} - ${slot.endTime}</option>
		                </c:forEach>
		            </c:forEach>
              </select>
            </div>
            <!--  <div class="form-group">
              <label for="operating-hours">Giờ hoạt động:</label>
              <select id="operating-hours" name="operating-hours">
                <option value="">Chọn giờ hoạt động</option>
                <c:forEach var="court" items="${listCourt}">		                    
		                     <option value="${court.courtId}">${court.startTime} - ${court.endTime}</option>
		                </c:forEach>
              </select>
            </div>
            <div class="form-group">
              <label for="play-time">Giờ vào chơi:</label>           
               <select id="play-time" name="play-time">
                <option value="">Chọn giờ vào chơi</option>
                <c:forEach var="slot" items="${listSlot}">		                    
		                     <option value="${slot.slotId}">${slot.startTime} - ${slot.endTime}</option>
		                </c:forEach>
              </select>
            </div>-->
            <button name="btnkiemtra" value="kiemtra">Kiểm tra</button>
            
            <div class="form-group">
              <table>
                <thead>
                  <tr>
                    <th>Vị trí</th>
                    <th>Ngày</th>
                    <th>Thời gian sân</th>
                    <th>Thời gian slot</th>
                  </tr>
                </thead>
                <tbody>
                   <c:forEach var="booking" items="${listSearch}">
		              <tr>
		      			<td>${booking.court.location}</td>
		      			<td>${booking.bookingDate}</td>
		      			<td>${booking.court.startTime}-${booking.court.endTime}</td>
		      			<td>${booking.slot.startTime}-${booking.slot.endTime}</td>
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
          <div id="map" class="map-hidden">
            <iframe
              src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d15679.295529545649!2d106.702399!3d10.748053!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752f755f679599%3A0x43b43ea2c0048054!2zMTkgxJAuIE5ndXnhu4VuIEjhu691IFRo4buNLCBUw6JuIEjGsG5nLCBRdeG6rW4gNywgSOG7kyBDaMOtIE1pbmgsIFZp4buHdCBOYW0!5e0!3m2!1svi!2sus!4v1724607423677!5m2!1svi!2sus"
              width="600"
              height="450"
              style="border: 0"
              allowfullscreen=""
              loading="lazy"
              referrerpolicy="no-referrer-when-downgrade"
            ></iframe>
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
