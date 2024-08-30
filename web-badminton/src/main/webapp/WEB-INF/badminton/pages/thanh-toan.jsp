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
              <li><a href="<c:url value='/index' />">Trang Chủ</a></li>
              <li><a href="<c:url value='/dat-san' />">Đặt Sân</a></li>

              <li><a href="<c:url value='/thanh-toan' />">Thanh toán</a></li>
            </ul>
          </nav>
        </div>
      </header>
      <!-- slider 1 -->
      <div class="slider1">
        <div class="slider-1-container">
          <h1>Thông Tin Thanh Toán</h1>
          <div class="slider-1-content">
            <form id="payment-form" action="/process-payment" method="POST">
              <div class="form-group">
                <label for="customer-id">Mã khách hàng</label>
                <input
                  type="text"
                  id="customer-id"
                  name="customer-id"
                  readonly
                />
              </div>
              <div class="form-group">
                <label for="location">Vị trí</label>
                <input type="text" id="location" name="location" readonly />
              </div>
              <div class="form-group">
                <label for="amount">Số lượng</label>
                <input type="text" id="amount" name="amount" readonly />
              </div>
              <div class="form-group">
                <label for="time-of-booking">Thời gian đặt sân</label>
                <input
                  type="time"
                  id="time-of-booking"
                  name="time-of-booking"
                  readonly
                />
              </div>
              <div class="form-group">
                <label for="amount-type">Loại đặt sân</label>
                <select id="amount-type" name="amount-type" readonly>
                  <option value="by-time">Theo giờ</option>
                  <option value="by-date">Theo ngày</option>
                  <option value="fixed">Cố định</option>
                </select>
              </div>
              <div class="form-group">
                <label for="payment-method">Loại hình thanh toán</label>
                <select id="payment-method" name="payment-method" required>
                  <option value="bank-transfer">Chuyển khoản ngân hàng</option>
                  <option value="credit-card">Thẻ tín dụng</option>
                  <option value="paypal">Thời gian cá nhân</option>
                </select>
              </div>
              <div class="form-group">
                <label for="price">Giá tiền</label>
                <input type="text" id="price" name="price" readonly />
              </div>
              <!-- <div class="form-group">
                <label for="payment-time">Giờ thanh toán</label>
                <input
                  type="text"
                  id="payment-time"
                  name="payment-time"
                  readonly
                />
              </div> -->
              <!-- <div class="form-group">
                <label for="payment-date">Ngày thanh toán</label>
                <input
                  type="text"
                  id="payment-date"
                  name="payment-date"
                  readonly
                />
              </div> -->
              <div class="form-group">
                <label for="status">Trạng thái</label>
                <select id="status" name="status" disabled>
                  <option value="pending">Chưa thanh toán</option>
                  <option value="completed">Đã thanh toán</option>
                </select>
              </div>
              <button href="#" type="submit">Xác Nhận Thanh Toán</button>
            </form>
          </div>
        </div>
      </div>
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
