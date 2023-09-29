const button = document.querySelector(".loginBox");
const email = document.querySelector("input[name='memberEmail']");
const pw = document.querySelector("input[name='memberPassword']");
const emailCheck = document.getElementById("emailCheck");
const pwCheck = document.getElementById("pwCheck");
const hiddenWrong=document.querySelectorAll(".hiddenWrong");
// const myForm=document.getElementById("myForm");
// 이메일 경고
email.addEventListener("input", () => {
    // Check if the input is empty
    if (!email.value) {
        emailCheck.innerText = "필수항목 입니다.";
        emailCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    }
else {
    if (isValidEmail(email.value)) {
        emailCheck.innerText = "";
        hiddenWrong[0].style.display = "none";
    }
    else {
        emailCheck.innerText = "올바른 이메일 형식이 아닙니다.";
        emailCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    }
}
});
// 이메일 필드에서 포커스가 벗어났을 때
email.addEventListener("blur", () => {
    if (!email.value) {
        emailCheck.innerText = "필수항목 입니다.";
        emailCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    }
});
//이메일 형식 검사 함수
function isValidEmail(email) {
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
}

  // 비밀번호 경고
pw.addEventListener("input", (e) => {
    const enteredPassword = e.target.value;
    if (!enteredPassword) {
        pwCheck.innerText = "필수항목 입니다.";
        pwCheck.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    } else if (enteredPassword.length < 8 || enteredPassword.length > 20) {
        pwCheck.innerText = "8자 이상, 20자 이하로 입력해주세요.";
        pwCheck.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    } else {
        pwCheck.innerText = "";
        hiddenWrong[1].style.display = "none";
    }
});
pw.addEventListener("blur", () => {
    if (!pw.value) {
        pwCheck.innerText = "필수항목 입니다.";
        pwCheck.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    }
});
// 제출 버튼 클릭 시 폼 유효성 검사 후 제출
button.addEventListener("click", (e) => {
    e.preventDefault(); // 기본 제출 동작을 막음
    const emailValue = email.value.trim();
    const pwValue = pw.value.trim();
    // 입력 필드가 비어있는지 확인
    const isFieldsEmpty = emailValue === '' || pwValue === '';

    // 이메일과 비밀번호 모두 유효한 경우에만 폼을 제출
    if (!emailCheck.innerText && !pwCheck.innerText && !isFieldsEmpty) {
        document.getElementById("myForm").submit();
    }
});
const emailLogin=document.querySelector(".emailLogin");
const backButton=document.querySelector(".backButton");
emailLogin.addEventListener("click",()=>{
    window.location.href = "http://localhost:10000/member/join";
})
backButton.addEventListener("click",()=>{
    window.location.href = "http://localhost:10000";
})

