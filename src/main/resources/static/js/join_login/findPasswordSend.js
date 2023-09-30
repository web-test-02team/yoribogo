const backButton=document.querySelector(".backButton");
backButton.addEventListener("click",()=>{
    window.location.href="http://localhost:10000/member/findPassword";
})
const pw = document.querySelector("input[name='memberPassword']");
const pwCheck = document.getElementById("pwCheck");
const pwCh = document.querySelector("input[name='check']");
const pw2Check=document.getElementById("pwCheck2");
const hiddenWrong=document.querySelectorAll(".hiddenWrong");


pw.addEventListener("input", (e) => {
    const enteredPassword = e.target.value;
    if (!enteredPassword) {
        pwCheck.innerText = "필수항목 입니다.";
        pwCheck.style.color = "red";
        hiddenWrong[2].style.display = "flex";
    } else if (enteredPassword.length < 8 || enteredPassword.length > 20) {
        pwCheck.innerText = "8자 이상, 20자 이하로 입력해주세요.";
        pwCheck.style.color = "red";
        hiddenWrong[2].style.display = "flex";
    }else if (!/^(?=.*[A-Za-z])(?=.*\d|[^A-Za-z0-9]).{2,}$/.test(enteredPassword)) {
        pwCheck.innerText = '영문, 숫자, 특수문자 중 2가지 이상의 조합으로 입력해주세요.';
        pwCheck.style.color = 'red';
    }
    else {
        pwCheck.innerText = "";
        hiddenWrong[2].style.display = "none";
    }
});
