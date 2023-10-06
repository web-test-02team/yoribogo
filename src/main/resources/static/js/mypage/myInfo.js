const profileModal = document.getElementsByClassName("profileModalWrapper")[0];
const profileBtn = document.getElementsByClassName("profileBtn")[0];
let isShow = false;

profileBtn.addEventListener("click", (event) => {
    event.stopPropagation(); // 클릭 이벤트 전파를 막습니다.

    if (!isShow) {
        profileModal.style.display = "block";
        isShow = true;
    } else if (isShow) {
        profileModal.style.display = "none";
        isShow = false;
    }
});

// 전체 HTML을 클릭하는 이벤트 리스너 추가
document.addEventListener("click", (event) => {
    if (isShow && event.target !== profileModal && event.target !== profileBtn) {
        profileModal.style.display = "none";
        isShow = false;
    }
});

// 프로필 사진 업로드
const imageFile = document.querySelector(".imageFile");
const myProfile = document.querySelector(".myProfile");
const informationForm = document.querySelector("form[name='information-form']");
let profileName;
let profileUuid;
let previousValue = '';

imageFile.addEventListener("change", (e) => {
    const file = e.target.files[0];
    profileName = file.name;
    const formData = new FormData();
    formData.append("uploadFile", file);

    fetch("/file/profile-upload", {
        method: "POST",
        body: formData
    }).then((response) => response.text())
        .then((uuid) => {
            profileUuid = uuid;
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();
            month = month < 10 ? '0' + month : month;
            date = date < 10 ? '0' + date : date;
            let fileName = `${year}/${month}/${date}/t_${profileUuid}_${profileName}`;
            myProfile.setAttribute("src", `/file/display?fileName=${fileName}`);
        })
})

// 프로필 사진 쪽 이미지 업로드 클릭 시 발생하는 이벤트
const flex2Btn = document.querySelector(".flex2Btn");
flex2Btn.addEventListener("click", () => {
    imageFile.click();
})

// 커버 이미지 업로드
const backgroundFile = document.querySelector(".backgroundFile");
const backgroundImg = document.querySelector(".backgroundImg");
const svgCover = document.querySelector(".svgCover");
const backgroundSpan = document.querySelector(".backgroundSpan");
let backgroundName;
let backgroundUuid;

// 커버 업로드 시 동작할 함수
backgroundFile.addEventListener("change", (e) => {
    svgCover.style.display = 'none';
    backgroundSpan.style.display = 'block';
    const file = e.target.files[0];
    backgroundName = file.name;
    const formData = new FormData();
    formData.append("uploadFile", file);


    fetch("/file/background-upload", {
        method: "POST",
        body: formData
    }).then((response) => response.text())
        .then((uuid) => {
            backgroundUuid = uuid;
            let now = new Date();
            let year = now.getFullYear();
            let month = now.getMonth() + 1;
            let date = now.getDate();
            month = month < 10 ? '0' + month : month;
            date = date < 10 ? '0' + date : date;
            let fileName = `${year}/${month}/${date}/t_${backgroundUuid}_${backgroundName}`;
            backgroundImg.setAttribute("src", `/file/display?fileName=${fileName}`);
        })
})

// 커버 사진 쪽 이미지 업로드 클릭 시 발생하는 이벤트
const margin8Btn = document.querySelector(".margin8Btn");
margin8Btn.addEventListener("click", () => {
    backgroundFile.click();
})
// input 요소의 value를 파악하여 수정버튼 활성/비활성화
const myInformationInput = document.querySelector('input[name="myInformation"]');
const myInfoDivBtn = document.querySelector('.myInfoDivBtn');

function checkInputValue() {
    if (myInformationInput.value.length === 0) {
        myInfoDivBtn.disabled = true;
    } else {
        myInfoDivBtn.disabled = false;
    }
}

// input 요소의 값이 변경될 때마다 checkInputValue 함수를 실행
myInformationInput.addEventListener('input', checkInputValue);

checkInputValue();

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

// 수정버튼 클릭 시 form태그 사용
function nullProfileUuid(){
    let profileInput = document.createElement("input");
    profileInput.name = "uuid";
    profileInput.value = "";
    profileInput.type = "hidden";
    informationForm.append(profileInput);
}

function notNullProfileUuid(){
    let profileInput = document.createElement("input");
    profileInput.name = "uuid";
    profileInput.value = profileUuid;
    profileInput.type = "hidden";
    informationForm.append(profileInput);
}
function nullBackgroundUuid(){
    let backgroundInput = document.createElement("input");
    backgroundInput.name = "uuid";
    backgroundInput.value = "";
    backgroundInput.type = "hidden";
    informationForm.append(backgroundInput);
}
function notNullBackgroundUuid(){
    let backgroundInput = document.createElement("input");
    backgroundInput.name = "uuid";
    backgroundInput.value = backgroundUuid;
    backgroundInput.type = "hidden";
    informationForm.append(backgroundInput);
}

myInfoDivBtn.addEventListener("click", () => {

    if(profileUuid == null && backgroundUuid != null) {
        nullProfileUuid();
        notNullBackgroundUuid();
    }else if(profileUuid != null && backgroundUuid == null) {
        notNullProfileUuid();
        nullBackgroundUuid();
    }else if(profileUuid != null && backgroundUuid != null){
        notNullProfileUuid();
        notNullBackgroundUuid();
    }else{
        nullProfileUuid();
        nullBackgroundUuid();
    }

    informationForm.submit();
})