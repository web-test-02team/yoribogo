const backButton=document.querySelector(".backButton");
backButton.addEventListener("click",()=>{
    window.location.href="http://localhost:10000/member/findPassword";
})

//유효성 검사
const pw = document.querySelector("input[name='newPassword']");
const pwCheck = document.getElementById("pwCheck");
const pwCh = document.querySelector("input[name='check']");
const pw2Check=document.getElementById("pwCheck2");
const hiddenWrong=document.querySelectorAll(".hiddenWrong");


pw.addEventListener("input", (e) => {
    const enteredPassword = e.target.value;
    if (!enteredPassword) {
        pwCheck.innerText = "필수항목 입니다.";
        pwCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    } else if (enteredPassword.length < 8 || enteredPassword.length > 20) {
        pwCheck.innerText = "8자 이상, 20자 이하로 입력해주세요.";
        pwCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    }else if (!/^(?=.*[A-Za-z])(?=.*\d|[^A-Za-z0-9]).{2,}$/.test(enteredPassword)) {
        pwCheck.innerText = '영문, 숫자, 특수문자 중 2가지 이상의 조합으로 입력해주세요.';
        pwCheck.style.color = 'red';
    }
    else {
        pwCheck.innerText = "";
        hiddenWrong[0].style.display = "none";
    }
});
pw.addEventListener("blur", () => {
    if (!pw.value) {
        pwCheck.innerText = "필수항목 입니다.";
        pwCheck.style.color = "red";
        hiddenWrong[0].style.display = "flex";
    }
});
//비밀번호 확인 검사
pwCh.addEventListener("input",(e)=>{
    const enteredPassword2 = e.target.value;
    const passwordCheck=pw.value;
    if (!enteredPassword2) {
        pw2Check.innerText = "필수항목 입니다.";
        pw2Check.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    } else if (enteredPassword2.length < 8 || enteredPassword2.length > 20) {
        pw2Check.innerText = "8자 이상, 20자 이하로 입력해주세요.";
        pw2Check.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    }
    else if(enteredPassword2 !== passwordCheck){
        pw2Check.innerText = "비밀번호가 일치하지 않습니다.";
        pw2Check.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    }
    else {
        pw2Check.innerText = "";
        hiddenWrong[1].style.display = "none";
    }
})
pwCh.addEventListener("blur", () => {
    if (!pwCh.value) {
        pw2Check.innerText = "필수항목 입니다.";
        pw2Check.style.color = "red";
        hiddenWrong[1].style.display = "flex";
    }
});
const loginBox=document.querySelector(".loginBox");
loginBox.addEventListener("click",(e)=>{
    e.preventDefault();
    const pwValue = pw.value.trim();
    const pwChValue = pwCh.value.trim();
    // 입력 필드가 비어있는지 확인
    const isFieldsEmpty = pwValue === '' || pwChValue === '';
    // 비밀번호 유효성 검사
    const isPasswordValid = !pwCheck.innerText && !pw2Check.innerText;
    if (isPasswordValid && !isFieldsEmpty) {
        document.getElementById("myForm").submit();
    }
})