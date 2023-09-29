// NodeList.prototype.map = Array.prototype.map;

// const checkOptionAll = document.querySelector(".checkOptionAll");
// const checkOptions = document.querySelectorAll(".checkOption");
// checkOptionAll.addEventListener("click", () => {
//   checkOptions.forEach((checkOption) => {
//     checkOption.checked = checkOptionAll.checked;
//   });
// });

// checkOptions.forEach((checkOption) => {
  
//   checkOption.addEventListener("click", (e) => {
//     checkOptionAll.checked = checkOptions.map((checkOption) => checkOption.checked).filter((checked) => checked).length === 5;
//   });
// });


function checkSelectAll() {
  // 전체 동의 체크 후 개별 자동 체크
  const agreeCheckBox = document.querySelectorAll('input[name="check"]');
  // 개별 하나씩 동의체크
  const checking = document.querySelectorAll('input[name="check"]:checked');
  // 개별체크 후 전체 동의 체크 자동 체크
  const selectAll = document.querySelector('input[name="checkAll"]');

  if(agreeCheckBox.length-1 === checking.length) {
    selectAll.checked = true;
  } else {
    selectAll.checked = false;
  }
}

function selectAll(selectAll) {
  const agreeCheckBox = document.getElementsByName('check');

  agreeCheckBox.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  });
}

const backButton=document.querySelector(".backButton");
backButton.addEventListener("click",()=>{
  window.location.href="http://localhost:10000/member/login";
})
const button = document.querySelector(".join");
const email = document.querySelector("input[name='memberEmail']");
const emailCheck = document.getElementById("emailCheck");
const nameCh = document.querySelector("input[name='memberName']");
const nameCheck=document.getElementById("nameCheck");
const pw = document.querySelector("input[name='memberPassword']");
const pwCheck = document.getElementById("pwCheck");
const pwCh = document.querySelector("input[name='check']");
const pw2Check=document.getElementById("pwCheck2");
const hiddenWrong=document.querySelectorAll(".hiddenWrong");
const agreeCheck=document.getElementById("agreeCheck");
//이메일 경고
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
function isValidEmail(email) {
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
  return emailPattern.test(email);
}
// 이름 검사
nameCh.addEventListener("input",()=>{
  if(!nameCh.value){
    nameCheck.innerText = "필수항목 입니다.";
    nameCheck.style.color = "red";
    hiddenWrong[1].style.display = "flex";
  }else {
    nameCheck.innerText = "";
    hiddenWrong[1].style.display = "none";
  }
});
//비밀번호 검사
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
pw.addEventListener("blur", () => {
  if (!pw.value) {
    pwCheck.innerText = "필수항목 입니다.";
    pwCheck.style.color = "red";
    hiddenWrong[2].style.display = "flex";
  }
});
//비밀번호 확인 검사
pwCh.addEventListener("input",(e)=>{
  const enteredPassword2 = e.target.value;
  const passwordCheck=pw.value;
  if (!enteredPassword2) {
    pw2Check.innerText = "필수항목 입니다.";
    pw2Check.style.color = "red";
    hiddenWrong[3].style.display = "flex";
  } else if (enteredPassword2.length < 8 || enteredPassword2.length > 20) {
    pw2Check.innerText = "8자 이상, 20자 이하로 입력해주세요.";
    pw2Check.style.color = "red";
    hiddenWrong[3].style.display = "flex";
  }
  else if(enteredPassword2 !== passwordCheck){
    pw2Check.innerText = "비밀번호가 일치하지 않습니다.";
    pw2Check.style.color = "red";
    hiddenWrong[3].style.display = "flex";
  }
  else {
    pw2Check.innerText = "";
    hiddenWrong[3].style.display = "none";
  }
})

pwCh.addEventListener("blur", () => {
  if (!pwCh.value) {
    pw2Check.innerText = "필수항목 입니다.";
    pw2Check.style.color = "red";
    hiddenWrong[3].style.display = "flex";
  }
});
//필수항목 검사
const agreeCheckBox = document.querySelectorAll('input[name="check"]');
const form=document.querySelector("form");
button.addEventListener("click",(e)=>{
  e.preventDefault(); // 기본 제출 동작을 막음
  // 이메일 유효성 검사
  const isEmailValid = !emailCheck.innerText;

  // 이름 유효성 검사
  const isNameValid = !nameCheck.innerText;

  // 비밀번호 유효성 검사
  const isPasswordValid = !pwCheck.innerText && !pw2Check.innerText;

  // 필수 약관 동의 여부
  const isAgreeChecked = agreeCheckBox[1].checked && agreeCheckBox[2].checked && agreeCheckBox[3].checked;
  // 입력 필드가 비어있는지 확인
  const isFieldsNotEmpty = email.value.trim() !== '' &&
      nameCh.value.trim() !== '' &&
      pw.value.trim() !== '' &&
      pwCh.value.trim() !== '';

  if (!isAgreeChecked) {
    agreeCheck.innerText = "필수 약관에 동의해주세요.";
    agreeCheck.style.color = "red";
    hiddenWrong[4].style.display = "flex";
  } else if (isEmailValid && isNameValid && isPasswordValid && isFieldsNotEmpty) {
    form.submit();
  }
});
// 모든 체크박스가 체크되면 오류 메시지를 숨김
for (let i = 1; i <= 3; i++) {
  agreeCheckBox[i].addEventListener("change", () => {
    if (agreeCheckBox[1].checked && agreeCheckBox[2].checked && agreeCheckBox[3].checked) {
      agreeCheck.innerText="";
      hiddenWrong[4].style.display = "none";
    }
    })
  };