var operatingHoursData = {
  "quận 1, tp.hcm": "06:00 - 24:00",
  "quận 3, tp.hcm": "05:00 - 22:00",
  "quận 7, tp.hcm": "08:00 - 20:00",
};

function showOperatingHours() {
  var location = document.getElementById("location").value.trim().toLowerCase();
  var operatingHours = operatingHoursData[location];

  if (operatingHours) {
    document.getElementById("operating-hours").style.display = "block";
    document.getElementById("operating-hours-display").innerText =
      operatingHours;
    document.getElementById("playing-time").style.display = "block";
  } else {
    document.getElementById("operating-hours").style.display = "none";
    document.getElementById("playing-time").style.display = "none";
  }
}

function checkPlayingTime() {
  var operatingHours = document.getElementById(
    "operating-hours-display"
  ).innerText;
  var playTime = document.getElementById("play-time").value;

  var operatingHoursArray = operatingHours.split(" - ");
  var startHour = convertToMinutes(operatingHoursArray[0]);
  var endHour = convertToMinutes(operatingHoursArray[1]);
  var playTimeMinutes = convertToMinutes(playTime);

  var result = document.getElementById("time-check-result");

  if (playTimeMinutes >= startHour && playTimeMinutes <= endHour) {
    result.style.color = "green";
    result.innerText = "Giờ này có thể vào chơi.";
  } else {
    result.style.color = "red";
    result.innerText = "Giờ này không thể vào chơi.";
  }
}

function convertToMinutes(time) {
  var timeParts = time.split(":");
  return parseInt(timeParts[0]) * 60 + parseInt(timeParts[1]);
}
