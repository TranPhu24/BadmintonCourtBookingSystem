document.addEventListener('DOMContentLoaded', () => {
    const monthSelect = document.getElementById('month-select');
    const yearSelect = document.getElementById('year-select');
    const calendarBody = document.getElementById('calendar-body');

    const months = [
        "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6",
        "Tháng 7", "Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12"
    ];

    const currentYear = new Date().getFullYear();
    for (let i = 0; i < months.length; i++) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = months[i];
        monthSelect.appendChild(option);
    }

    for (let i = currentYear; i <= currentYear + 10; i++) {
        const option = document.createElement('option');
        option.value = i;
        option.textContent = i;
        yearSelect.appendChild(option);
    }

    monthSelect.value = new Date().getMonth();
    yearSelect.value = new Date().getFullYear();

    function generateCalendar(month, year) {
        calendarBody.innerHTML = '';
        const firstDay = new Date(year, month, 1).getDay();
        const lastDate = new Date(year, month + 1, 0).getDate();

        let row = document.createElement('tr');
        for (let i = 0; i < (firstDay === 0 ? 6 : firstDay - 1); i++) {
            row.appendChild(document.createElement('td'));
        }

        for (let date = 1; date <= lastDate; date++) {
            const cell = document.createElement('td');
            cell.textContent = date;
            row.appendChild(cell);

            if (row.children.length === 7) {
                calendarBody.appendChild(row);
                row = document.createElement('tr');
            }
        }

        if (row.children.length > 0) {
            calendarBody.appendChild(row);
        }
    }

    function updateCalendar() {
        const month = parseInt(monthSelect.value, 10);
        const year = parseInt(yearSelect.value, 10);
        generateCalendar(month, year);
    }

    monthSelect.addEventListener('change', updateCalendar);
    yearSelect.addEventListener('change', updateCalendar);

    updateCalendar();
});
