document.addEventListener('DOMContentLoaded', function() {
  const consentButton = document.getElementById('consentButton');
  const map = document.getElementById('map');

  if (consentButton && map) {
    consentButton.addEventListener('click', function() {

      map.classList.remove('map-hidden');
      map.classList.add('map-visible');
    });
  } else {
    console.error('Button or map element not found.');
  }
});
