<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Đặt sân | V Badminton</title>
  <link rel="stylesheet" href="resources/css/dat-san.css" />
</head>
<body>
  <div class="container">
    <header>
      <div class="header-container">
        <div class="logo">
          <a href="<c:url value='/index' />">
            <img src="resources/images/home/logo.png" alt="V Badminton Logo" />
          </a>
        </div>
        <nav>
          <ul class="menu">
            <li><a href="<c:url value='/quan-ly-chung' />">Quản lí sân</a></li>
            <li><a href="<c:url value='/Admin_add' />">Cài đặt lịch</a></li>
            <li><a href="<c:url value='/index' />">Trang chủ</a></li>
          </ul>
        </nav>
      </div>
    </header>

    <form action="${pageContext.request.contextPath}/formsuauser" method="post" id="editCustomerForm">
      <div class="slider-3">
        <div class="slider-3-container">
          <h1>V Badminton</h1>
          <div class="slider-3-content">
            <div class="form-group">
              <label for="user-type">Tài khoản</label>
              <select id="userTypeSelect" name="user-type" disabled>
                <option value="">--Chọn vai trò--</option>
                <option value="customer" ${role == 'customer' ? 'selected' : ''}>Customer</option>
                <option value="manager" ${role == 'manager' ? 'selected' : ''}>Manager</option>
                <option value="staff" ${role == 'staff' ? 'selected' : ''}>Staff</option>
              </select>
            </div>

            <c:choose>
              <c:when test="${role == 'customer'}">
                <div class="form-group">
                  <label for="username">Tên tài khoản</label>
                  <input type="text" name="c_username" value="${user.userID}" readonly />
                  <label for="cccd">CCCD</label>
                  <input type="text" name="c_cccd" value="${user.customer.customerId}" readonly />
                  <label for="fullname">Tên người dùng</label>
                  <input type="text" name="c_fullname" value="${user.customer.customerName}" />
                  <label for="email">Email</label>
                  <input type="email" name="c_email" value="${user.customer.email}" />
                  <label for="phone">Phone</label>
                  <input type="tel" name="c_phone" value="${user.customer.phone}" />
                  <label for="timeplay">Timeplay</label>
                  <input type="text" name="c_timeplay" value="${user.customer.timeplay}" />
                  <label for="password">Mật khẩu</label>
                  <input type="text" name="c_password" value="${user.password}" />
                </div>
              </c:when>
              <c:when test="${role == 'manager'}">
                <div class="form-group">
                  <label for="username">Tên tài khoản</label>
                  <input type="text" name="m_username" value="${user.userID}" readonly />
                  <label for="cccd">CCCD</label>
                  <input type="text" name="m_cccd" value="${user.manager.managerId}" readonly />
                  <label for="fullname">Tên manager</label>
                  <input type="text" name="m_fullname" value="${user.manager.managerName}" />
                  <label for="password">Mật khẩu</label>
                  <input type="text" name="m_password" value="${user.password}" />
                </div>
              </c:when>
              <c:when test="${role == 'staff'}">
                <div class="form-group">
                  <label for="username">Tên tài khoản</label>
                  <input type="text" name="s_username" value="${user.userID}" readonly />
                  <label for="cccd">CCCD</label>
                  <input type="text" name="s_cccd" value="${user.staff.staffId}" readonly  />
                  <label for="fullname">Tên staff</label>
                  <input type="text" name="s_fullname" value="${user.staff.staffName}" />
                  <label for="password">Mật khẩu</label>
                  <input type="text" name="s_password" value="${user.password}" />
                </div>
              </c:when>
            </c:choose>

            <button type="submit" name="xacnhan" value="xacnhan">Xác nhận</button>
          </div>
        </div>
      </div>
    </form>

    <footer>
      <div class="contact">
        <img src="resources/images/home/logo.png" alt="V Badminton Logo" />
        <div class="contact-fanpage">
          <a href="#"><img src="resources/images/home/facebook.svg" alt="facebook" /></a>
          <a href="#"><img src="resources/images/home/instagram.svg" alt="instagram" /></a>
          <a href="#"><img src="resources/images/home/tiktok.svg" alt="tiktok" /></a>
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
