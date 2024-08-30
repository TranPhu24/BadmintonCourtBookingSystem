// JavaScript cho Manager.html

document.getElementById('saveButton').addEventListener('click', function() {
    // Lấy giá trị từ form
    var name = document.getElementById('name').value;
    var phone = document.getElementById('phone').value;
    var id = document.getElementById('id').value;
    var email = document.getElementById('email').value;
    var note = document.getElementById('note').value;
    var status = document.getElementById('status').value;
    
    // Tạo một mã giao dịch ngẫu nhiên và thời gian hiện tại
    var transactionCode = Math.floor(Math.random() * 1000000);
    var currentTime = new Date().toLocaleString();

    // Tạo hàng mới cho bảng lịch sử giao dịch
    var newRow = document.createElement('tr');
    newRow.innerHTML = `
        <td>${transactionCode}</td>
        <td>${currentTime}</td>
        <td><button onclick="viewTransactionDetails('${name}', '${phone}', '${id}', '${email}', '${note}', '${status}')">Xem chi tiết</button></td>
    `;
    
    document.getElementById('historyBody').appendChild(newRow);

    // Xóa dữ liệu trong form sau khi lưu
    document.getElementById('transactionForm').reset();
});

function viewTransactionDetails(name, phone, id, email, note, status) {
    alert(`Thông tin giao dịch:\n\nTên: ${name}\nSĐT: ${phone}\nMã ID: ${id}\nEmail: ${email}\nGhi chú: ${note}\nTrạng thái: ${status}`);
}
