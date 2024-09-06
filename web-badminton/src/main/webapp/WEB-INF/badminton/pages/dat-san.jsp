<%@page contentType="text/html" pageEncoding="UTF-8"%> <%@ taglib
uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Đặt sân | V Badminton</title>
    <link rel="stylesheet" href="resources/css/dat-san.css" />
    <script src="resources/js/dat-lich.js"></script>
    <script src="resources/js/dat-san.js"></script>
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
              <li><a href="<c:url value='/list-san-customer' />">Danh sách sân</a></li>
              <li><a href="<c:url value='/dat-san' />">Đặt Sân</a></li>

              <li><a href="<c:url value='/thanh-toan' />">Thanh toán</a></li>
              <li><a href="<c:url value='/index' />">Trang Chủ</a></li>
            </ul>
          </nav>
        </div>
      </header>
      
      <!-- slider 3 -->
      <form action="${pageContext.request.contextPath}/datsanCustomer" method="post">
      <div class="slider-3">
        <div class="slider-3-container">
          <h1>V Badminton</h1>
          <div class="slider-3-content">
            
            <div class="form-group">
              <label for="booking-type">Loại đặt lịch</label>
              <select id="booking-type" name="booking-type" required>
                <option value="">--Chọn loại đặt lịch--</option>
                <option value="fixed">Lịch cố định (>= 1 tháng)</option>
                <option value="daily">Lịch ngày (1 lần chơi)</option>
                <option value="flexible">Lịch linh hoạt (số giờ/tháng)</option>
              </select>
            </div>
            <!-- Lịch cố định -->
            <div class="form-group" name="lichcodinh" value="lichcodinh" id="fixed-options" style="display: none">
              <label for="fixed-days">Chọn thứ trong tuần</label>
              <select id="fixed-days" name="fixed-days" required>
                <option name="day" value="monday">Thứ Hai</option>
                <option name="day" value="tuesday">Thứ Ba</option>
                <option name="day" value="wednesday">Thứ Tư</option>
                <option name="day" value="thursday">Thứ Năm</option>
                <option name="day" value="friday">Thứ Sáu</option>
                <option name="day" value="saturday">Thứ Bảy</option>
                <option name="day" value="sunday">Chủ Nhật</option>
              </select>
              <label for="fixed-days">Chọn Slot</label>
              <select id="fixed-days" name="slotInfo" >
               
				<c:forEach var="court" items="${courts}">
		                <c:forEach var="slot" items="${slots}">		                    
		                     <option value="${court.courtId}-${slot.slotId}">${court.location}-${slot.startTime} - ${slot.endTime}</option>
		                </c:forEach>
		            </c:forEach>
              </select>              
            </div>
            <!-- Đặt lịch ngày -->
            <div class="form-group" name="lichngay" value="lichngay"  id="daily-options" style="display: none">
              <label for="daily-date">Ngày đặt</label>
              <input
                type="date"
                id="daily-date"
                name="daily-date"
              /><br />
              <label for="fixed-days">Chọn Slot</label>
              <select id="fixed-days" name="slotInfo" >
              <c:forEach var="court" items="${courts}">
		                <c:forEach var="slot" items="${slots}">		                    
		                    <option value="${court.courtId}-${slot.slotId}">${court.location}-${slot.startTime} - ${slot.endTime}</option>
		                </c:forEach>
		            </c:forEach>
              </select>
              
            </div>
            <!-- Lịch linh hoạt -->
            <div class="form-group" name="lichlinhhoat" value="lichlinhhoat" id="flexible-options" style="display: none">
              <label for="hours">Tổng số giờ trong tháng</label>
              <input
                type="number"
                id="hours"
                name="hours"
                placeholder="Nhập tổng số giờ"
              />
            </div>
            <!-- <div class="form-group">
              <label for="message">Ghi chú</label>
              <textarea id="message" name="message" required></textarea>
              <p>
                <a href="/pages/privacy-policy.html">Chính sách bảo mật</a> của
                chúng tôi được áp dụng.
              </p>
            </div> -->
            <button type="submit" name="datsan" value="datsan">Đặt sân</button>

            <div class="form-group">
              <label>Thông tin sân</label>
              <table>
                <thead>
                  <tr>
                    <th>Vị trí sân</th>
                    <th>Thời gian sân</th>
                    <th>Thời gian slot</th>
                  </tr>
                </thead>
                <tbody>
                   <c:forEach var="court" items="${courts}">
		                <c:forEach var="slot" items="${slots}">
		                    <tr>
		                        <td>${court.location}</td>                      
		                        <td>${court.startTime}-${court.endTime}</td>
		                        <td>${slot.startTime}-${slot.endTime}</td>
		                    </tr>
		                </c:forEach>
		            </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      </form>
      <!-- slider 1 -->
       <section class="slider-1">
        <div class="slider-1-container">
          <h2>GIỚI THIỆU VỀ SÂN CẦU LÔNG V BADMINTON</h2>
          <div class="slider-1-content">
            <div class="slider-1-content1">
                <div class="content1-img1">
                    <img src="resources/images/dat-san/slider1-content1.png" alt="slider1-content1">
                </div>
                <div class="content1-letter1">
                    <h3>CƠ SỞ VẬT CHẤT</h3>
                    <ul>
                        <li>Sân cầu lông V Badminton có 10 sân với hệ thống thảm ngoại 
                            nhập, thiết bị chiếu sáng và nhiệt độ đạt tiêu chuẩn quốc gia.</li>
                        <li>Bãi giữ xe rộng rãi, nhà vệ sinh sạch sẽ.</li>
                    </ul>
                </div>
            </div>
            <div class="slider-1-content2">
                <div class="content1-img2">
                    <img src="resources/images/dat-san/slider1-content2.png" alt="slider1-content2">
                </div>
                <div class="content1-letter2">
                    <h3>DỊCH VỤ</h3>
                    <ul>
                        <li>Sân cầu lông có căn tin phục vụ nước.</li>
                        <li>Bán đồ cầu lông như quần áo, giày, cầu, phụ kiện cầu lông,...</li>
                        <li>Cho thuê vợt giá rẻ.</li>
                        <li>Nhận dạy cầu lông căn bản đến nâng cao do các huấn luyện viên hướng dẫn tận tình.</li>
                    </ul>
                </div>
            </div>
            <div class="slider-1-content3">
                <div class="content1-img3">
                    <img src="resources/images/dat-san/slider1-content3.png" alt="slider1-content3">
                </div>
                <div class="content1-letter3">
                    <ul>
                        <li><b>GIỜ HOẠT ĐỘNG:</b> Từ 5h00 đến 24h tất cả các ngày trong tuần.</li>
                        <li><b>ĐỊA CHỈ:</b> 19 Nguyễn Hữu Thọ, Phường Tân Phong, Quận 7, TP.HCM.</li>
                    </ul>
                </div>
            </div>
            <div class="slider-1-content4">
                <div class="content1-img4">
                    <img src="resources/images/dat-san/slider1-content4.png" alt="slider1-content4">
                </div>
                <div class="content1-letter4">
                    <h3>BẢNG GIÁ CÔNG KHAI </h3>
                </div>
            </div>
          </div>
        </div>
      </section> -->
      <!-- slider 2 -->
      <!-- <section class="slider-2">
        <div class="slider-2-container">
          <div class="slider-2-content">
            <h2>Đặt lịch ngay!</h2>
            <p>
                Cuộc sống có thể bận rộn, nhưng chúng tôi hiểu điều đó. Vì vậy, chúng tôi muốn đảm bảo 
                rằng việc đặt sân của bạn là một quá trình thuận tiện nhất có thể. Đặt sân với chúng tôi ngay 
                trên trang web của chúng tôi mọi lúc, mọi nơi—không còn bị ràng buộc bởi giờ làm việc hành 
                chính. Chỉ cần chọn thời gian phù hợp và nhấp chuột, mọi thứ sẽ được sắp xếp đơn giản như vậy!
            </p>
            <p>Liên hệ đặt sân bên dưới.</p>
          </div>
        </div>
      </section> 
      <!-- slider 4 -->
      <section class="slider-4">
        <div class="slider-4-container">
          <div class="slider-4-content">
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
