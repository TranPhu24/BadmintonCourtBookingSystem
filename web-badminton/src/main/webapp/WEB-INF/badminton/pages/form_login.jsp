<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=fomr, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="resources/css/login_styles.css">
    <link rel="stylesheet" href="resources/css/style.css">
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
    <div class="wrapper">
        <span class="icon-close"><a href="<c:url value='/login' />"><ion-icon name="close-outline"></ion-icon></span></a>
        <div class="form-box login">
            <h2>login</h2>
            <form action="${pageContext.request.contextPath}/formLoginCustomer" method="post">
			    <div class="input-box">
			        <span class="icon"><ion-icon name="mail"></ion-icon></span>
			        <input type="text" name="username" required>
			        <label>Name</label>
			    </div>
			    <div class="input-box">
			        <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
			        <input type="password" name="password" required>
			        <label>Password</label>
			    </div>
			    <div class="remember-forgot">
			        <label><input type="checkbox"> Remember me</label>
			        <a href="#">Forgot Password</a>
			    </div>	   
			    <button type="submit" class="btn" name="btnLogin" value="login">Login</button>
			    <div class="login-register">
			        <p>Don't have an account?<a href="#" class="register-link">Register</a></p>
			    </div>
			</form>

    </div>



    <div class="form-box register">
        <h2>Registrantion</h2>
        <form action="${pageContext.request.contextPath}/formRegister" method="post">
		    <div class="input-box">
		        <span class="icon">
		            <ion-icon name="person"></ion-icon>
		        </span>
		        <input type="text" name="username" required>
		        <label>Username</label>
		    </div>
		
		    <div class="input-box">
		        <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
		        <input type="password" name="password" required>
		        <label>Password</label>
		    </div>
		    <div class="input-box">
		        <span class="icon"><ion-icon name="person"></ion-icon></span>
		        <input type="text" name="cccd" required>
		        <label>CMND/CCCD</label>
		    </div>
		    <div class="input-box">
		        <span class="icon"><ion-icon name="person"></ion-icon></span>
		        <input type="email" name="email" required>
		        <label>Email</label>
		    </div>
		    <div class="input-box">
		        <span class="icon"><ion-icon name="person"></ion-icon></span>
		        <input type="text" name="name" required>
		        <label>Tên</label>
		    </div>
		    <div class="input-box">
		        <span class="icon"><ion-icon name="person"></ion-icon></span>
		        <input type="text" name="phone" required>
		        <label>Phone</label>
		    </div>
		    <div class="remember-forgot">
		        <label><input type="checkbox"> I agree to the terms conditions</label>
		    </div>
		    
		    <button type="submit" class="btn" name="btnRegister" value="register">Register</button>
		    <div class="login-register">
		        <p>Already have an account?<a href="#" class="login-link">login</a></p>
		    </div>
		</form>

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
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
</html>