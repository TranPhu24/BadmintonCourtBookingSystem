<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Imprint | V Badminton</title>
    <link rel="stylesheet" href="resources/css/imprint.css"/>
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
              <li><a href="<c:url value='/dat-san' />">Đặt Sân</a></li>
              <li><a href="<c:url value='/check-in' />">Check in</a></li>
              <li><a href="<c:url value='/dang-ky-san' />">Đăng ký sân</a></li>
              <li>
                <a href="<c:url value='/quan-ly-chung' />">Quản lý chung</a>
              </li>
              <li><a href="<c:url value='/thanh-toan' />">Thanh toán</a></li>
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
      <div class="slider-1">
        <div class="slider-1-container">
            <h1>Dấu ấn</h1>
            <div class="letter-1">
                <p>
                  Hầu hết các luật và quy định về viễn thông trên toàn thế giới đều quy 
                  định rằng các trang web không hoàn toàn mang tính riêng tư hoặc cá 
                  nhân phải có dấu ấn tuân thủ pháp luật. Điều này bao gồm các trang 
                  web có chứa blog hoặc văn bản mang tính báo chí.
                </p>
            </div>
            <div class="letter-2">
                <p>
                  Tên của người liên hệ chịu trách nhiệm về nội dung phải được nêu 
                  trong dấu ấn, cùng với địa chỉ và phương tiện liên lạc. Ví dụ, điều này có 
                  nghĩa là số điện thoại và địa chỉ email. Có thể cần thông tin khác theo 
                  quy định của pháp luật. Vui lòng tham khảo ý kiến ​​chuyên gia để tìm 
                  hiểu thông tin cụ thể nào là bắt buộc đối với trang web của bạn.
                </p>
            </div>
        </div>
      </div>
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
