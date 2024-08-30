<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login Selection</title>
    <link rel="stylesheet" href="resources/css/login_styles.css" />
    <link rel="stylesheet" href="resources/css/Em.css" />
    <link rel="stylesheet" href="resources/css/style.css" />
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }

      .login-selection-container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        padding: 20px;
        text-align: center;
        width: 300px; /* Adjust the width as needed */
      }

      .button-container {
        margin-top: 20px;
      }

      .btn {
        background-color: #162930;
        border: none;
        border-radius: 6px;
        color: #fff;
        cursor: pointer;
        font-size: 16px;
        padding: 10px 20px;
        margin: 10px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        transition: background-color 0.3s, box-shadow 0.3s;
      }

      .btn:hover {
        background-color: #0056b3;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
      }

      .btn:active {
        background-color: #004494;
      }
    </style>
  </head>
  <body>
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
    <main>
      <div class="login-selection-container">
        <h2>Select Login Type</h2>
        <span class="icon-close"
          ><ion-icon name="close-outline"></ion-icon
        ></span>
        <div class="button-container">
          <button
            onclick="window.location.href='<c:url value='/form_login' />'"
            class="btn"
          >
            Login as User
          </button>

          <button
            onclick="window.location.href='<c:url value='/form_Employe_login' />'"
            class="btn"
          >
            Login as Employee
          </button>
        </div>
      </div>
    </main>
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
  </body>
  <script src="resources/js/login_script.js"></script>
</html>
