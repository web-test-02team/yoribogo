const backButton=document.querySelector(".backButton");
backButton.addEventListener("click",()=>{
    window.location.href="http://localhost:10000/member/login";
});
const passwordReset=document.querySelector(".passwordReset");
const email = document.querySelector("input[name='memberEmail']");
const emailCheck = document.getElementById("emailCheck");
const hiddenWrong=document.querySelector(".hiddenWrong");
email.addEventListener("input", () => {
    // Check if the input is empty
    if (!email.value) {
        emailCheck.innerText = "필수항목 입니다.";
        emailCheck.style.color = "red";
        hiddenWrong.style.display = "flex";
    }
    else {
        if (isValidEmail(email.value)) {
            emailCheck.innerText = "";
            hiddenWrong.style.display = "none";
        }
        else {
            emailCheck.innerText = "올바른 이메일 형식이 아닙니다.";
            emailCheck.style.color = "red";
            hiddenWrong.style.display = "flex";
        }
    }
});
// 이메일 필드에서 포커스가 벗어났을 때
email.addEventListener("blur", () => {
    if (!email.value) {
        emailCheck.innerText = "필수항목 입니다.";
        emailCheck.style.color = "red";
        hiddenWrong.style.display = "flex";
    }
});
//이메일 형식 검사 함수
function isValidEmail(email) {
    const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
    return emailPattern.test(email);
}
passwordReset.addEventListener("click",(e)=>{
    e.preventDefault(); // 기본 제출 동작을 막음
    const emailValue = email.value.trim();
    const isFieldsEmpty = emailValue === '';
    if (!emailCheck.innerText && !isFieldsEmpty) {
        document.getElementById("myForm").submit();
    }
})