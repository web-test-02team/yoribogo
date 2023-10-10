// 스크롤이 가장 위일 경우 memberNameBar display: none 그 외 block
const memberNameBar = document.querySelector(".memberNameBar")
// 스크롤 이벤트 핸들러 함수
function handleScroll() {
    if (window.scrollY === 0) {
        // 스크롤이 가장 위에 있을 경우
        memberNameBar.style.display = "none";
    } else {
        // 스크롤이 위에서 벗어날 경우
        memberNameBar.style.display = "block";
    }
}
// 스크롤 이벤트 등록
window.addEventListener("scroll", handleScroll);

// 로그인후 클릭 하면 나오는 이벤트
const memberContainer=document.querySelector(".memberContainer");
const loginClick=document.querySelector(".loginClick");

memberContainer.addEventListener("click",() => {
    if(loginClick.style.display=='none'){
        loginClick.style.display = 'block';
    }else{
        loginClick.style.display = 'none';
    }
});

// 공유 아이콘 클릭 시 공유 모달창 표시
const sharingContainer = document.querySelector(".sharingContainer")
const sharingDIV = document.querySelector(".sharingDIV")

sharingContainer.addEventListener("click", () => {
    sharingDIV.style.display = "block";
})
// 회색면 클릭 시 필터 모달창 닫기 - 필터 모달창 닫히면서 전 상태로 돌리기
const sharingModalshadow = document.querySelector(".sharingModalshadow")

sharingModalshadow.addEventListener("click", () => {
    sharingDIV.style.display = "none";
})

// 모달창 내 X버튼 클릭 시 도달창 닫기
const closeBTN = document.querySelector(".close")

closeBTN.addEventListener("click", () => {
    sharingDIV.style.display = "none";
})

// 댓글 작성란 높이 조정
const replyWrite = document.querySelector(".replyWrite")
// 댓글 작성란의 내용이 변경될 때마다 높이를 조절
replyWrite.addEventListener("input", () => {
    // 현재 내용의 높이
    const currentHeight = replyWrite.scrollHeight;
    // 댓글 작성란의 높이를 현재 내용의 높이로 설정
    replyWrite.style.height = currentHeight + "px";
})

// 댓글창 변경
const cancel = document.querySelector(".cancel")
const replyWriteContainer = document.querySelector(".replyWriteContainer")
const replyWriteBTN = document.querySelector(".replyWriteBTN")
// 댓글창 클릭 시 작성란 켜짐
replyWriteBTN.addEventListener("click", () => {
    replyWriteBTN.style.display = 'none';
    replyWriteContainer.style.display = 'block';
})
// 댓글 취소버튼 누르면 댓글창 변경
cancel.addEventListener("click", () => {
    replyWriteBTN.style.display = 'flex';
    replyWriteContainer.style.display = 'none';
    replyWrite.value = "";
})

// 댓글 작성 유,무에 따른 등록버튼 활성화/비활성화
const registration = document.querySelector(".registration")

replyWrite.addEventListener("input", () => {
    // 댓글 입력 필드의 내용을 가져옵니다.
    const replyWriteContent = replyWrite.value.trim();
    // 입력된 문자열이 있는지 확인합니다.
    if (replyWriteContent.length > 0) {
        // 입력된 문자열이 있으면 disabled 속성을 제거합니다.
        registration.removeAttribute("disabled");
    } else {
        // 입력된 문자열이 없으면 disabled 속성을 추가합니다.
        registration.setAttribute("disabled", "disabled");
    }
})

// 등록버튼 클릭 시 댓글 목록에 추가
registration.addEventListener("click", () => {

})
//
const likeBTN = document.querySelector(".likeBTN")
const likeImageNone = document.querySelector(".likeImageNone")
const likeImageYes = document.querySelector(".likeImageYes")
const likeCount = document.querySelector(".likeCount")
let count = 0;
likeBTN.addEventListener("click", () => {
    if (likeImageNone.style.display == 'none') {
        likeImageNone.style.display = 'block'
        likeImageYes.style.display = 'none'
        if (count > 0) {
            count--;
        }
        likeCount.textContent = count
    } else {
        likeImageNone.style.display = 'none'
        likeImageYes.style.display = 'block'
        count++;
        likeCount.textContent = count
    }
})
// footer 댓글버튼 클릭시 화면이동
const replyBTN = document.querySelector(".replyBTN")
const requestingWrap = document.querySelector(".requestingWrap")

replyBTN.addEventListener("click", () => {
    requestingWrap.scrollIntoView({ behavior: "smooth" });
})
//
const deleteBTN = document.querySelector(".deleteBTN")
const replyDeleteCancelBTN = document.querySelector(".replyDeleteCancelBTN")
const replyDeleteAgreeBTN = document.querySelector(".replyDeleteAgreeBTN")
const replyDeleteDIV = document.querySelector(".replyDeleteDIV")

deleteBTN.addEventListener("click", () => {
    replyDeleteDIV.style.display = 'block';
})

replyDeleteCancelBTN.addEventListener("click", () => {
    replyDeleteDIV.style.display = 'none';

})

replyDeleteAgreeBTN.addEventListener("click", () => {
    replyDeleteDIV.style.display = 'none';
})

// 공유 옆 ...버튼 클릭 시 이벤트
const postToolBTN = document.querySelector(".postToolBTN");
const modifyAndDeleteWrap = document.querySelector(".modifyAndDeleteWrap");
postToolBTN.addEventListener("click", () => {
    if(modifyAndDeleteWrap.style.display === "none"){
        modifyAndDeleteWrap.style.display = "block";
    }else {
        modifyAndDeleteWrap.style.display = "none";
    }


    g
})
