<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Check in | V Badminton</title>
    <link rel="stylesheet" href="resources/css/check-in.css" />
    <script src="resources/js/dat-san.js"></script>
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
                <a href="<c:url value='/Staff_IF' />">Thông tin cá nhân</a>
              </li>
              <li><a href="<c:url value='/check-in' />">Check in</a></li>
              <li>
                <a href="<c:url value='/index' />">Trang chủ</a>
              </li>
            </ul>
          </nav>
        </div>
      </header>
      <!-- slider 1 -->
      <form action="${pageContext.request.contextPath}/checkinStaff" method="post">
      <div class="slider-1">
        <div class="slider-1-container">
          <h1>Check In</h1>
          <div class="slider-1-content">
            
            <div class="form-group">
              <label for="court-id">Mã đặt</label>
              <input
                type="text"
                id="court-id"
                name="booking-id"
                placeholder="Nhập mã đặt sân"
                required
              />
            </div>
            
            
            <c:if test="${not empty booking}">
			    <table>
			        <thead>
			            <tr>
			                <th>Mã đặt</th>
			                <th>Mã khách</th>
			                <th>Vị trí</th>
			                <th>Ngày đặt sân</th>
			                <th>Giờ đặt</th>
			            </tr>
			        </thead>
			        <tbody>
			            <tr>
			                <td>${booking.bookingId}</td>
			                <td>${booking.user.customer.customerId}</td>
			                <td>${booking.court.location}</td>
			                <td>${booking.bookingDate}</td>
			                <td>${booking.slot.startTime}h - ${booking.slot.endTime}h</td>
			            </tr>
			        </tbody>
			    </table>
			</c:if>
              
            <button href="#" type="submit">Kiểm tra</button>
            <div class="form-group">
              <label>Danh sách tất cả sân đã đặt</label>
              <table>
                <thead>
                  <tr>
                    <th>Mã đặt</th>
                    <th>Mã khách</th>
                    <th>Vị trí</th>
                    <th>Ngày đặt sân</th>
                    <th>Giờ đặt</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="booking" items="${bookingList}">
				    <tr>
				      <td>${booking.bookingId}</td>
				      <td>${booking.user.customer.customerId}</td>
				      <td>${booking.court.location}</td>
				      <td>${booking.bookingDate}</td>				     
				      <td>${booking.slot.startTime}h - ${booking.slot.endTime}h</td>
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
