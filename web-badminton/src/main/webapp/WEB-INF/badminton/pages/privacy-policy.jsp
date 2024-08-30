<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Privacy Polycy | V Badminton</title>
    <link rel="stylesheet" href="resources/css/privacy-policy.css"/>
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
            <h1>Chính sách bảo mật</h1><br>
            <h2>Lưu ý quan trọng về chính sách bảo mật này</h2>
            <div class="letter-1">
                <p>
                  Chào mừng bạn đến với chính sách bảo mật của trang web của bạn. 
                  Xin lưu ý rằng nội dung trên trang này là một chỗ giữ chỗ và không cấu 
                  thành chính sách bảo mật hợp lệ. Bạn có trách nhiệm tạo và công bố 
                  chính sách bảo mật cho trang web của mình tuân thủ các luật và quy 
                  định hiện hành.
                </p>
            </div>
            <div class="letter-2">
                <p>
                  Nếu bạn thấy việc tạo chính sách bảo mật là một nhiệm vụ khó khăn, 
                  Jimdo sẽ giúp bạn. Jimdo đã hợp tác với Trusted Shops để cung cấp 
                  tiện ích bổ sung có tên là Legal Text Generator. Legal Text Generator 
                  cho phép bạn dễ dàng có được các văn bản pháp lý tùy chỉnh cho trang 
                  web của mình, bao gồm cả cửa hàng của bạn. Các văn bản được tự 
                  động tích hợp vào trang web của bạn và được cập nhật bất cứ khi nào 
                  luật thay đổi! Và nếu có sự cố xảy ra, bạn sẽ được bảo vệ bởi tính năng 
                  bảo vệ thông báo cảnh báo tuyệt vời của Trusted Shops. Nhấp vào <a href ="https://www.jimdo.com/addon/legal-text-generator/"><u><b>đây</b></u></a>
                  để biết thêm thông tin.
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
