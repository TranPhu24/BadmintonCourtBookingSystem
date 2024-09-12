document.addEventListener('DOMContentLoaded', function () {
  const userTypeSelect = document.getElementById('userTypeSelect');
  const managerFields = document.getElementById('managerFields');
  const customerFields = document.getElementById('customerFields');
  const staffFields = document.getElementById('staffFields');
  const form = document.getElementById('editCustomerForm');
  function hideAllForms() {
    managerFields.style.display = 'none';
    customerFields.style.display = 'none';
    staffFields.style.display = 'none';

    removeRequired(managerFields);
    removeRequired(customerFields);
    removeRequired(staffFields);
  }

  function addRequired(fields) {
    const inputs = fields.querySelectorAll('input');
    inputs.forEach(input => {
      input.setAttribute('required', 'true');
    });
  }

  function removeRequired(fields) {
    const inputs = fields.querySelectorAll('input');
    inputs.forEach(input => {
      input.removeAttribute('required');
    });
  }

  userTypeSelect.addEventListener('change', function () {
    hideAllForms();

    const selectedType = userTypeSelect.value;

    if (selectedType === 'manager') {
      managerFields.style.display = 'block';
      addRequired(managerFields);
    } else if (selectedType === 'customer') {
      customerFields.style.display = 'block';
      addRequired(customerFields);
    } else if (selectedType === 'staff') {
      staffFields.style.display = 'block';
      addRequired(staffFields);
    }
  });

  hideAllForms();

  form.addEventListener('submit', function (event) {
    const selectedType = userTypeSelect.value;

    if (selectedType === 'manager') {
      if (!managerFields.checkValidity()) {
        alert('Vui lòng nhập đầy đủ thông tin cho Manager');
        event.preventDefault(); 
      }
    } else if (selectedType === 'customer') {
      if (!customerFields.checkValidity()) {
        alert('Vui lòng nhập đầy đủ thông tin cho Customer');
        event.preventDefault();
      }
    } else if (selectedType === 'staff') {
      if (!staffFields.checkValidity()) {
        alert('Vui lòng nhập đầy đủ thông tin cho Staff');
        event.preventDefault();
      }
    }
  });
});
