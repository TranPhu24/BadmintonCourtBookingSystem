document.addEventListener('DOMContentLoaded', function() {
  const headers = document.querySelectorAll('.slider-2-content2 h2');

  headers.forEach(function(header) {

    header.style.cursor = 'pointer';

    header.addEventListener('click', function() {

      header.classList.toggle('active');

      let content = header.nextElementSibling;
      
      while (content && content.tagName.toLowerCase() !== 'h2') {
        if (content.style.display === 'block') {
          content.style.display = 'none';
        } else {
          content.style.display = 'block';
        }
        content = content.nextElementSibling;
      }
    });
  });
});
