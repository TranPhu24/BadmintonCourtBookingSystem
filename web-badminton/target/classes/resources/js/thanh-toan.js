document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('payment-form');
    const statusSelect = document.getElementById('status');
    const paymentTimeInput = document.getElementById('payment-time');
    const paymentDateInput = document.getElementById('payment-date');

    form.addEventListener('submit', function(event) {
        event.preventDefault(); 

        // Cập nhật trạng thái thành "Đã thanh toán"
        statusSelect.value = 'completed';

        // Lấy thời gian hiện tại
        const currentDate = new Date();
        const timeString = currentDate.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' });
        const dateString = currentDate.toLocaleDateString();

        // Hiển thị thời gian và ngày thanh toán
        paymentTimeInput.value = timeString;
        paymentDateInput.value = dateString;
    });
});
