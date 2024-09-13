<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm sân mơi</title>
    <link rel="stylesheet" href="resources/css/Manager.css"> 
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
  <header>
    <div class="header-container">
      <div class="logo">
        <a href="<c:url value='/index' />"><img src="resources/images/home/logo.png" alt="V Badminton Logo" /></a>
      </div>
      <nav>
            <ul class="menu">
              <li>
                <a href="<c:url value='/quan-ly-chung' />">Quản lí sân</a>
              </li>
              
          <li><a href="<c:url value='/Admin_add' />">Cài đặt lịch</a></li>
              <li>
                <a href="<c:url value='/index' />">Trang chủ</a>
              </li>
            </ul>
          </nav>
    </div>
    
  </header>
      <main></main>
    <div class="container">
        <div class="transaction-history">
            <h2>Danh sách cần duyệt</h2>
            <table id="historyTable">
                <thead>
                    <tr>
                        <th>Mã đặt</th>
                        <th>Thứ</th>
                        <th>Vị trí</th>
                        <th>Từ</th>
                        <th>Đến</th>
                        <th>Trạng thái</th>
                    </tr>
                </thead>
                <tbody id="historyBody">
                    <c:forEach var="booking" items="${listBooking}">
				    <tr>
				      <td>${booking.bookingId}</td>
				      <td>${booking.bookingDay}</td>
				      <td>${booking.court.location}</td>
				      <td>${booking.slot.startTime}</td>
				      <td>${booking.slot.endTime}</td>
				      <td>
				        <a href="<c:url value='/bookingIdtoAdd?id=${booking.bookingId}' />">Cài đặt</a>

				      </td>
				    </tr>
				  </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="transaction-form" ">
            <h2>Cài đặt lịch </h2>
            <form id="transactionForm" action="${pageContext.request.contextPath}/updateBooking" method="post">
			    <label for="name">Mã đặt:</label>
			    <input type="text" id="name" name="customerId" value="${booking.bookingId}" >
			    
			    <label for="name">Mã khách hàng:</label>
			    <input type="text" id="name" name="customerId" value="${booking.user.customer.customerId}" >
			
			    <label for="name">Mã sân:</label>
			    <input type="text" id="name" name="courtId" value="${booking.court.courtId}" >
			    
			    <label for="name">Mã slot:</label>
			    <input type="text" id="name" name="slotId" value="${booking.slot.slotId}" >
			
			    <label for="name">Mã thanh toán:</label>
			    <input type="text" id="name" name="paymentId" value="${booking.payment.paymentId}" >
			
			    <label for="name">Cài đặt ngày:</label>
			    <input type="date" id="date" name="date" required>
			
			    <button type="submit" id="saveButton" name="btnluu" value="luu">Lưu</button>
			</form>

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
</body>
</html>
