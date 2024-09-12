<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Đặt sân | V Badminton</title>
    <link rel="stylesheet" href="resources/css/dat-san.css" />
    <script src="resources/js/edit-customer.js"></script>
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
                <a href="<c:url value='/Manager_IF' />">Thông tin cá nhân</a>
              </li>
	              <li><a href="<c:url value='/dang-ky-san' />">Đăng kí sân</a></li>
	              <li><a href="<c:url value='/dang-ky-slot' />">Đăng kí slot</a></li>
              <li>
                <a href="<c:url value='/quan-ly-chung' />">Quản lí sân</a>
              </li>
              
          <li><a href="<c:url value='/Admin_add' />">Thêm sân mới</a></li>
              <li><a href="<c:url value='/index' />">Trang chủ</a></li>
            </ul>
          </nav>
        </div>
      </header>
      
      <!-- slider 3 -->
      <form action="${pageContext.request.contextPath}/addCustomer" method="post" id="editCustomerForm">
		  <div class="slider-3">
		    <div class="slider-3-container">
		      <h1>V Badminton</h1>
		      <div class="slider-3-content">
		        <div class="form-group">
		          <label for="user-type">Tài khoản</label>
		          <select id="userTypeSelect" name="user-type" required>
		            <option value="">--Chọn vai trò--</option>
		            <option value="customer">Customer</option>
		            <option value="manager">Manager</option>
		            <option value="staff">Staff</option>
		          </select>
		        </div>
		
		        <!-- Customer -->
		        <div class="form-group" id="customerFields" style="display: none;">
		          <div class="slider-1-content">
			          <label for="username">Tên tài khoản</label>
			          <input type="text" name="c_username" placeholder="Nhập tên tài khoản" />
			          <label for="cccd">CCCD</label>
			          <input type="text" name="c_cccd" placeholder="Nhập CCCD" />
			          <label for="fullname">Tên người dùng</label>
			          <input type="text" name="c_fullname" placeholder="Nhập tên người dùng" />
			          <label for="email">Email</label>
			          <input type="email" name="c_email" placeholder="Nhập email" />
			          <label for="phone">Phone</label>
			          <input type="tel" name="c_phone" placeholder="Nhập số điện thoại" />
			          <label for="timeplay">Timeplay</label>
			          <input type="text" name="c_timeplay" placeholder="Nhập thời gian chơi" />
			          <label for="password">Mật khẩu</label>
			          <input type="text" name="c_password" placeholder="Nhập mật khẩu" />
			        </div>
			    </div>
		
		        <!-- Manager -->
		        <div class="form-group" id="managerFields" style="display: none;">
		          <div class="slider-1-content">
			          <label for="username">Tên tài khoản</label>
			          <input type="text" name="m_username" placeholder="Nhập tên tài khoản" />
			          <label for="cccd">Tên manager</label>
			          <input type="text" name="m_cccd" placeholder="Nhập CCCD" />
			          <label for="fullname">Tên manager</label>
			          <input type="text" name="m_fullname" placeholder="Nhập tên manager" />
			          <label for="password">Mật khẩu</label>
			          <input type="text" name="m_password" placeholder="Nhập mật khẩu" />
			        </div>
			    </div>
		
		        <!-- Staff -->
		        <div class="form-group" id="staffFields" style="display: none;">
		         <div class="slider-1-content">
			          <label for="username">Tên tài khoản</label>
			          <input type="text" name="s_username" placeholder="Nhập tên tài khoản" />
			          <label for="cccd">CCCD</label>
			          <input type="text" name="s_username" placeholder="Nhập CCCD" />
			          <label for="fullname">Tên staff</label>
			          <input type="text" name="s_fullname" placeholder="Nhập tên staff" />
			          <label for="password">Mật khẩu</label>
			          <input type="text" name="s_password" placeholder="Nhập mật khẩu" />
			        </div>
		        </div>
		
		        <button type="submit" name="xacnhan" value="xacnhan">Xác nhận</button>
		      </div>
		    </div>
		  </div>
		</form>

      
      
      
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
