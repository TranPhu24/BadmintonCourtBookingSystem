<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Về Chúng Tôi | V Badminton</title>
    <link rel="stylesheet" href="resources/css/ve-chung-toi.css" />
    <script src="resources/js/dat-san.js" defer></script>
    <script src="resources/js/ve-chung-toi.js" defer></script>
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
        <div class="slider-1-container">
          <div class="slider-1-content1">
            <img
              src="resources/images/ve-chung-toi/slider1-content1.png"
              alt="slider1-content1"
            />
          </div>
          <div class="slider-1-content2">
            <img
              src="resources/images/ve-chung-toi/slider1-content2.png"
              alt="slider1-content2"
            />
          </div>
          <div class="slider-1-content2">
            <img
              src="resources/images/ve-chung-toi/slider1-content3.png"
              alt="slider1-content3"
            />
          </div>
        </div>
      </section>
      <!-- slider 2 -->
      <section class="slider-2">
        <div class="slider-2-container">
          <h1>Về chúng tôi</h1>
          <div class="slider-2-content">
            <img
              src="resources/images/ve-chung-toi/logo.png"
              alt="V Badminton Logo"
            />
            <div class="slider-2-content1">
              <p>
                V Badminton là một doanh nghiệp hàng đầu trong lĩnh vực cung cấp
                dịch vụ đặt sân cầu lông online.<br />
                Với nền tảng công nghệ hiện đại và tiện ích, V Badminton mang
                đến cho khách hàng trải nghiệm đặt sân thuận tiện và nhanh
                chóng.<br />
                V Badminton không chỉ giúp người chơi tiết kiệm thời gian mà còn
                đảm bảo sự linh hoạt trong việc lựa chọn thời gian và sân chơi
                phù hợp.<br />
                Với mục tiêu mang lại trải nghiệm tốt nhất cho khách hàng, V
                Badminton sẽ không ngừng cải tiến và phát triển hệ thống của
                mình.<br />
                Điều này giúp chúng tôi giữ vững vị thế là một trong những địa
                điểm tin cậy nhất khi cần đặt sân cầu lông online.<br />
              </p>
            </div>
            <div class="slider-2-content2">
              <h2>Sứ mệnh</h2>
              <div class="content1-1">
                <p>
                  <b>Sứ mệnh</b> của V Badminton là tạo ra một cộng đồng cầu
                  lông đầy sức sống và sự kết nối. Chúng tôi cam kết mang đến
                  trải nghiệm tuyệt vời thông qua việc cung cấp dịch vụ đặt sân
                  online tiện lợi và chất lượng.<br />
                  Hướng đến một môi trường chơi cầu lông thân thiện, nơi mọi
                  người có thể phát triển kỹ năng, tận hưởng niềm vui từ sân
                  chơi và xây dựng mối quan hệ xã hội.
                </p>
              </div>
              <h2>Giá trị cốt lõi</h2>
              <div class="content2-1">
                <h3>Chất lượng</h3>
                <p>
                  Chúng tôi cam kết cung cấp dịch vụ và sân chơi cầu lông chất
                  lượng, đảm bảo mỗi người chơi có trải nghiệm tốt nhất khi sử
                  dụng dịch vụ của chúng tôi.
                </p>
              </div>
              <div class="content2-2">
                <h3>Tiện lợi</h3>
                <p>
                  Với hệ thống đặt sân online tiện ích, chúng tôi mang lại sự
                  thuận tiện cho khách hàng, giúp họ dễ dàng lựa chọn thời gian
                  & sân chơi phù hợp với nhu cầu của mình.
                </p>
              </div>
              <div class="content2-3">
                <h3>Cam kết và sự tin cậy</h3>
                <p>
                  Chúng tôi luôn tuân thủ cam kết của mình và đặt niềm tin của
                  khách hàng lên hàng đầu, luôn lắng nghe và hỗ trợ mọi nhu cầu
                  của họ.
                </p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- slider 3 -->
      <section class="slider-3">
        <div class="slider-3-container">
          <div class="slider-3-content">
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
      <!-- slider 4 -->
      <section class="slider-4">
        <div class="slider-4-container">
          <div class="slider-4-content1">
            <b>Liên hệ ngay</b>
            <ul>
              <li>Hotline: 0835535470</li>
              <li>Email: vsport1503@gmail.com</li>
            </ul>
          </div>
          <div class="slider-4-content2">
            <b>Địa chỉ</b>
            <ul>
              <li>19 Nguyễn Hữu Thọ, P.Tân Phong, Quận 7, TP.HCM.</li>
            </ul>
          </div>
          <div class="slider-4-content3">
            <b>Giờ mở cửa</b>
            <ul>
              <li>Từ 05h00 sáng đến 24h mỗi ngày trong tuần.</li>
            </ul>
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
