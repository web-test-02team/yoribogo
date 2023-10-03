const profileModal = document.getElementsByClassName("profileModalWrapper")[0];
const profileBtn = document.getElementsByClassName("profileBtn")[0];
let isShow = false;

profileBtn.addEventListener("click", (event) => {
    event.stopPropagation(); // 클릭 이벤트 전파를 막습니다.

    if (!isShow) {
        console.log(isShow);
        profileModal.style.display = "block";
        isShow = true;
    } else if (isShow) {
        console.log(isShow);
        profileModal.style.display = "none";
        isShow = false;
    }
});

// 전체 HTML을 클릭하는 이벤트 리스너 추가
document.addEventListener("click", (event) => {
    if (isShow && event.target !== profileModal && event.target !== profileBtn) {
        console.log(isShow);
        profileModal.style.display = "none";
        isShow = false;
    }
});

// 프로필 사진 업로드
const imageInput = document.querySelector("input[name=uploadFile]");
const myProfile = document.querySelector(".myProfile");
imageInput.addEventListener("change", (e) => {
    const file = e.target.files[0];
    const name = file.name;
    const formData = new FormData();
    formData.append("uploadFile", file);

    fetch("/file/upload", {
        method: "POST",
        body: formData
    }).then((response) => response.json())
        .then((uuids) => {
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();
            month = month < 10 ? '0' + month : month;
            date = date < 10 ? '0' + date : date;
            let fileName = `${year}/${month}/${date}/t_${uuids[0]}_${name}`;
            myProfile.setAttribute("src", `/file/display?fileName=${fileName}`);
            // let input = document.createElement("input");
            // input.name = "uuid";
            // input.value = uuids[0];
            // input.type = "hidden";
            // form.append(input);
        })
})

const flex2Btn = document.querySelector(".flex2Btn");
flex2Btn.addEventListener("click", () => {
    imageInput.click();
})

// 커버 이미지 업로드
const coverImageInput = document.getElementById("coverImageInput");
const dashedDiv = document.querySelector(".dashedDiv");

// 이미지 업로드 시 동작할 함수
coverImageInput.addEventListener("change", function () {
    dashedDiv.innerHTML = "";
    const file = coverImageInput.files[0];

    if (file) {
        const reader = new FileReader();

        reader.onload = function (e) {
            dashedDiv.style.backgroundImage = `url('${e.target.result}')`;

            // Add this part to set the image width and height to 100%
            const img = new Image();
            img.src = e.target.result;
            img.onload = function () {
                dashedDiv.style.backgroundSize = "100% 100%";
            };
        };

        reader.readAsDataURL(file);
    }
});

// // 유효성 검사
// const urlTitle = document.getElementById("urlTitle");
// const urlInput = document.getElementById("urlInput");
// const urlLabel = document.getElementsByClassName("info6Label")[2];
// const validationWrap = document.querySelector(".validationWrap");
// const makeLinkBtn = document.querySelector(".flexEndBtn");
//
// urlLabel.addEventListener("click", () => {
//     console.log("클릭됨");
// });
//
// function updateValidationAndButton() {
//     const title = urlTitle.value;
//     const url = urlInput.value;
//     const urlPattern = /^https?:\/\/(?:www\.)?[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}(?:\/\S*)?$/;
//
//     if (title !== "") {
//         if (url == "") {
//             validationWrap.style.display = "none";
//             urlLabel.style.borderWith = "1px";
//             urlLabel.style.borderColor = "rgba(0,0,0,.1)";
//         } else if (urlPattern.test(url)) {
//             validationWrap.style.display = "none";
//             sdf;
//             makeLinkBtn.style.backgroundColor = "#fda942";
//             makeLinkBtn.style.color = "#fff";
//             makeLinkBtn.style.cursor = "pointer";
//             urlLabel.style.borderWith = "1px";
//             urlLabel.style.borderColor = "rgba(0,0,0,.1)";
//         } else {
//             validationWrap.style.display = "block";
//             urlLabel.style.borderWith = "2px";
//             urlLabel.style.borderColor = "#eb4545";
//         }
//     } else {
//         if (urlPattern.test(url) || url == "") {
//             validationWrap.style.display = "none";
//             makeLinkBtn.style.backgroundColor = "#f3f3f4";
//             makeLinkBtn.style.color = "#b9b9bb";
//             urlLabel.style.borderWith = "1px";
//             urlLabel.style.borderColor = "rgba(0,0,0,.1)";
//         } else {
//             validationWrap.style.display = "block";
//             makeLinkBtn.style.backgroundColor = "#f3f3f4";
//             makeLinkBtn.style.color = "#b9b9bb";
//             urlLabel.style.borderWith = "2px";
//             urlLabel.style.borderColor = "#eb4545";
//         }
//     }
// }
//
// urlInput.addEventListener("input", function () {
//     updateValidationAndButton();
// });
// urlTitle.addEventListener("input", function () {
//     updateValidationAndButton();
// });
//
// // SNS계정 유효성 검사
// const urlLabels = document.querySelectorAll(".info6LabelUrls");
// const validationWrapUrls = document.querySelectorAll(".validationWrapUrls");
//
// // Define a function to validate URLs
// function validateURL(url) {
//     // Regular expression for a simple URL validation
//     const urlPattern = /^(https?:\/\/)?([\w.]+)\.([a-z]{2,6}\.?)(\/[\w./]*)*\/?$/i;
//     return urlPattern.test(url);
// }
//
// // Loop through each label and add an event listener to the input field
// urlLabels.forEach((label, index) => {
//     const input = label.querySelector(".labelText");
//
//     input.addEventListener("input", () => {
//         const urlValue = input.value.trim(); // Get trimmed value
//
//         if (urlValue === "") {
//             validationWrapUrls[index].style.display = "none";
//             label.style.borderWith = "1px";
//             label.style.borderColor = "rgba(0,0,0,.1)";
//         } else if (validateURL(urlValue)) {
//             validationWrapUrls[index].style.display = "none";
//             label.style.borderWith = "1px";
//             label.style.borderColor = "rgba(0,0,0,.1)";
//         } else {
//             validationWrapUrls[index].style.display = "block";
//             label.style.borderWith = "2px";
//             label.style.borderColor = "#eb4545";
//         }
//     });
// });

// updateInputAndValidation 함수를 전역 범위에 정의합니다.
function updateInputAndValidation(inputElement) {
    // 글자 수 업데이트
    const textCountElement = inputElement.closest(".infoDiv6").querySelector(".textCount");
    const maxLength = 50;
    const currentLength = inputElement.value.length;
    textCountElement.textContent = `${currentLength}/${maxLength}`;

    // 유효성 검사
    const oneSentenceValidationWrap = document.querySelector(".validationWrapOneSentence");
    const label = inputElement.parentElement;
    if (inputElement.value.trim() === "") {
        oneSentenceValidationWrap.style.display = "block"; // Show validation message
        label.style.borderWith = "2px";
        label.style.borderColor = "#eb4545";
    } else {
        oneSentenceValidationWrap.style.display = "none"; // Hide validation message
        label.style.borderWith = "1px";
        label.style.borderColor = "rgba(0,0,0,.1)";
    }
}

function updateNameAndValidation(inputElement) {
    // 글자 수 업데이트
    const textCountElement = inputElement.closest(".infoDiv6").querySelector(".textCount");
    const maxLength = 50;
    const currentLength = inputElement.value.length;
    textCountElement.textContent = `${currentLength}/${maxLength}`;

    // 유효성 검사
    const oneSentenceValidationWrap2 = document.querySelector(".validationWrapOneSentence2");
    const label2 = inputElement.parentElement;
    if (inputElement.value.trim() === "") {
        oneSentenceValidationWrap2.style.display = "block"; // Show validation message
        label2.style.borderWith = "2px";
        label2.style.borderColor = "#eb4545";
    } else {
        oneSentenceValidationWrap2.style.display = "none"; // Hide validation message
        label2.style.borderWith = "1px";
        label2.style.borderColor = "rgba(0,0,0,.1)";
    }
}

