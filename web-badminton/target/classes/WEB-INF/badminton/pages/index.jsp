<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home | V Badminton</title>
    <link rel="stylesheet" href="resources/css/style.css" />
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
      <section class="slider-1">
        <div class="slider-letter">
          <h1>ĐẶT NHANH CHỐT NHANH CÓ NGAY SÂN XỊN !!!</h1>
          <a href="<c:url value='/login' />" class="btn">Đặt Ngay</a>
        </div>
        <div class="slider-image">
          <img src="resources/images/home/slider1.png" alt="slider1" />
        </div>
      </section>
      <!-- slider 2 -->
      <section class="slider-2">
        <div class="slider-2-container">
          <div class="slider-2-content">
            <h1>V Badminton</h1>
            <p>
              V Badminton là nơi cung cấp dịch vụ đặt sân badminton trực tuyến
              nhanh chóng, tiện lợi. Chúng tôi cam kết mang đến cho bạn những
              trận đấu sôi động, hấp dẫn cùng với những sân chất lượng.
            </p>
            <a href="#" class="btn">Đọc thêm</a>
          </div>
        </div>
      </section>
      <!-- slider 3 -->
      <section class="slider-3">
        <div class="slider-3-container">
          <h1>TIN TỨC</h1>
          <div class="slider-3-content">
            <div class="slider-3-content1">
              <img
                src="resources/images/home/slider3-content1.png"
                alt="slider3-content1"
              />
              <h2>15 LỢI ÍCH CỦA VIỆC THAM GIA CẦU LÔNG</h2>
              <p>
                Chơi cầu lông là cách vận động toàn thân và tiêu thụ nhiều năng
                lượng hơn cả chạy bộ, đạp xe, thể dục nhịp điệu và cả đá bóng.
              </p>
              <a href="" class="btn">Xem thêm</a>
            </div>
            <div class="slider-3-content2">
              <img
                src="resources/images/home/slider3-content2.png"
                alt="slider3-content2"
              />
              <h2>ĐÁNH CẦU LÔNG CÓ TÁC DỤNG GÌ?</h2>
              <p>
                Giúp tăng cường sức mạnh cơ bắp, cải thiện sức bền và khả năng
                phối hợp vận động. Ngoài ra, đánh cầu lông còn giúp giảm căng
                thẳng, mệt mỏi, stress
              </p>
              <a href="#" class="btn">Xem thêm</a>
            </div>
            <div class="slider-3-content3">
              <img
                src="resources/images/home/slider3-content3.png"
                alt="slider3-content-"
              />
              <h2>
                NHỮNG LƯU Ý KHI CHƠI CẦU LÔNG ĐỂ TRÁNH TÁC HẠI XẤU ĐẾN SỨC KHOẺ
              </h2>
              <p>
                Chơi cầu lông thường xuyên sẽ giúp cải thiện vóc dáng, tăng
                cường sức bền, giảm thiểu nguy cơ mắc các bệnh về huyết áp, tim
                mạch... Tuy nhiên, nếu không chơi cầu lông đúng cách, cơ thể sẽ
                khó tránh được sự tổn hại về sức khoẻ.
              </p>
              <a href="#" class="btn">Xem thêm</a>
            </div>
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
