document.addEventListener('DOMContentLoaded', function() {
    const bookingTypeSelect = document.getElementById('booking-type');
    const fixedOptions = document.getElementById('fixed-options');
    const dailyOptions = document.getElementById('daily-options');
    const flexibleOptions = document.getElementById('flexible-options');

    bookingTypeSelect.addEventListener('change', function() {
        // Ẩn tất cả các tùy chọn
        fixedOptions.style.display = 'none';
        dailyOptions.style.display = 'none';
        flexibleOptions.style.display = 'none';

        // Hiển thị tùy chọn dựa trên loại đặt lịch được chọn
        if (bookingTypeSelect.value === 'fixed') {
            fixedOptions.style.display = 'block';
        } else if (bookingTypeSelect.value === 'daily') {
            dailyOptions.style.display = 'block';
        } else if (bookingTypeSelect.value === 'flexible') {
            flexibleOptions.style.display = 'block';
        }
    });
});
