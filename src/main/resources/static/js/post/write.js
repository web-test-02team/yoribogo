// 프로필모달
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

// textarea 요소를 가져옵니다.
const textarea = document.getElementById('write');

// 입력된 내용에 따라 textarea의 높이를 조절하는 함수를 만듭니다.
function adjustTextareaHeight() {
    textarea.style.height = 'auto'; // 높이 초기화

    const scrollHeight = textarea.scrollHeight;
    textarea.style.height = scrollHeight + 'px'; // 새로운 높이 설정
}

// textarea 내용이 변경될 때마다 높이를 조절하도록 이벤트 리스너를 추가합니다.
textarea.addEventListener('input', adjustTextareaHeight);

// 페이지 로드 시 초기 높이 설정
adjustTextareaHeight();

// postKindSelect 클릭 시 postKindListWrap felx적용
const postKindSelect = document.querySelector(".postKindSelect");
const postKindListWrap = document.querySelector(".postKindListWrap");

postKindSelect.addEventListener("click", () => {
    postKindListWrap.style.display = 'flex'
})

// postKindItemBTN 클릭 시 안의 e.target의 텍스트내용을 postKindSelectInput value에 넣기
const postKindItemBTNs = document.querySelectorAll(".postKindItemBTN")
const postKindSelectInput = document.querySelector(".postKindSelectInput")

postKindItemBTNs.forEach((postKindItemBTN) => postKindItemBTN.addEventListener("click", (e) => {
    postKindSelectInput.value = e.target.textContent;

    postKindListWrap.style.display = 'none'
}))

// 문서의 클릭 이벤트로 postKindSelect와 하위요소를 제외한 나머지 클릭 시 닫힘
document.addEventListener('click', function(event) {
    // 클릭된 요소가 postKindSelect인지 확인합니다.
    if (event.target === postKindSelect || postKindSelect.contains(event.target)) {
        // 클릭된 요소가 postKindSelect 또는 그 하위 요소일 경우, postKindListWrap 표시합니다.
        postKindListWrap.style.display = 'block';
    } else {
        // 그렇지 않을 경우, postKindListWrap을 숨김.
        postKindListWrap.style.display = 'none';
    }
});

// sharingSelect 클릭 시 sharingListWrap felx적용
const sharingSelect = document.querySelector(".sharingSelect");
const sharingListWrap = document.querySelector(".sharingListWrap");

sharingSelect.addEventListener("click", () => {
    sharingListWrap.style.display = 'flex'
})

// sharingItemBTN 클릭 시 안의 e.target의 텍스트내용을 sharingSelectInput value에 넣기
const sharingItemBTNs = document.querySelectorAll(".sharingItemBTN")
const sharingSelectInput = document.querySelector(".sharingSelectInput")

sharingItemBTNs.forEach((sharingItemBTN) => sharingItemBTN.addEventListener("click", (e) => {
    sharingSelectInput.value = e.target.textContent;

    sharingListWrap.style.display = 'none'
}))

// 문서의 클릭 이벤트로 sharingSelect와 하위요소를 제외한 나머지 클릭 시 닫힘
document.addEventListener('click', function(event) {
    // 클릭된 요소가 sharingSelect인지 확인합니다.
    if (event.target === sharingSelect || sharingSelect.contains(event.target)) {
        // 클릭된 요소가 sharingSelect 또는 그 하위 요소일 경우, sharingListWrap 표시합니다.
        sharingListWrap.style.display = 'block';
    } else {
        // 그렇지 않을 경우, categoryListWrap을 숨김.
        sharingListWrap.style.display = 'none';
    }
});

// 태그 X버튼을 누를 경우 해당태그 삭제
const deleteTagBTNs = document.querySelectorAll(".tagWrap>button");

deleteTagBTNs.forEach((deleteTagBTN) => deleteTagBTN.addEventListener("click", () => {
    // 클릭된 버튼의 부모인 tagWrap 요소를 찾아서 삭제
    const tagWrap = deleteTagBTN.closest(".tagWrap");

    if (tagWrap) {
        tagWrap.remove();
    }
}))

// categorySelect 클릭 시 categoryListWrap felx적용
const categorySelect = document.querySelector(".categorySelect");
const categoryListWrap = document.querySelector(".categoryListWrap");

categorySelect.addEventListener("click", () => {
    categoryListWrap.style.display = 'flex'
})

//
const categoryItemBTNs = document.querySelectorAll(".categoryItemBTN")
const categorySelectInput = document.querySelector(".categorySelectInput")

categoryItemBTNs.forEach((categoryItemBTN) => categoryItemBTN.addEventListener("click", (e) => {
    if(e.target.textContent === '카테고리 미설정'){
        categorySelectInput.value = "";
    }else {
        categorySelectInput.value = e.target.textContent;
    }
    contentListWrap.style.display = 'none'
}))

// 문서의 클릭 이벤트로 categorySelect와 하위요소를 제외한 나머지 클릭 시 닫힘
document.addEventListener('click', function(event) {
    // 클릭된 요소가 categorySelect인지 확인합니다.
    if (event.target === categorySelect || categorySelect.contains(event.target)) {
        // 클릭된 요소가 categorySelect 또는 그 하위 요소일 경우, categoryListWrap을 표시합니다.
        categoryListWrap.style.display = 'block';
    } else {
        // 그렇지 않을 경우, categoryListWrap을 숨김.
        categoryListWrap.style.display = 'none';
    }
});

// 업로드 버튼 클릭 시 파일업로드 모달창 켜기
const uploadBTN = document.querySelector(".uploadBTN");
const attachingFileModalWrap = document.querySelector(".attachingFileModalWrap");
const attachingFileModalGray = document.querySelector(".attachingFileModalGray");

uploadBTN.addEventListener("click", () => {
    attachingFileModalWrap.style.display = 'block';
    attachingFileModalGray.style.display = 'block';
})

// 취소 또는 X버튼을 클릭했을 경우 모달창 닫기
const modalCloseBTN = document.querySelector(".modalCloseBTN");

modalCloseBTN.addEventListener("click", () => {
    attachingFileModalWrap.style.display = 'none';
    attachingFileModalGray.style.display = 'none';
})

const cancelBTN = document.querySelector(".cancelBTN");

cancelBTN.addEventListener("click", () => {
    attachingFileModalWrap.style.display = 'none';
    attachingFileModalGray.style.display = 'none';
})

// 첨부 눌렀을 때 모달창 닫기
const confirmBTN = document.querySelector(".confirmBTN");

confirmBTN.addEventListener("click", () => {
    attachingFileModalWrap.style.display = 'none';
    attachingFileModalGray.style.display = 'none';
})