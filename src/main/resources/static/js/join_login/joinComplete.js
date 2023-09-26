const modal = document.getElementById("modalWindowWrap");

function openModal() {
  modal.style.display = "block";
}

function closeModal() {
  modal.style.display = "none";
}

window.onclick = function (e) {
  if (e.target == modal) {
    closeModal();
  }
}



// const modal = document.getElementById("modalWindowWrap");

// function openModal() {
//   modal.style.display = "block";
// }

// document.getElementById("openModal").addEventListener("click", openModal);

// const checkButton = document.querySelector(".sendCheckButton");
// checkButton.addEventListener("click", function() {
//   modal.style.display = "none";
// });

// window.addEventListener("click", function(e) {
//   if (e.target == modal) {
//       modal.style.display = "none";
//   }
// });


