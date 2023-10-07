// 공유 아이콘 클릭 시 공유 모달창 표시
const viewButton = document.querySelector(".viewButton")
const sharingDIV = document.querySelector(".sharingDIV")

viewButton.addEventListener("click", () => {
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
// 로그인후 클릭 하면 나오는 이벤트
// const loginImg=document.querySelector(".loginImg");
// const loginClick=document.querySelector(".loginClick");
// loginImg.addEventListener("click",()=>{
//     if(loginClick.style.display=='none'){
//         loginClick.style.display = 'block';
//     }else{
//         loginClick.style.display = 'none';
//     }
// })
//카카오 로그인시..
// const kakaoBtn=document.querySelector(".kakaoBtn");

//하트 댓글
const likeButtons = document.querySelectorAll(".likeBTN");

likeButtons.forEach((likeBTN) => {
    const likeImageNone = likeBTN.querySelector(".likeImageNone");
    const likeImageYes = likeBTN.querySelector(".likeImageYes");
    const likeCount = likeBTN.querySelector(".likeCount");
    let count = 0;

    likeBTN.addEventListener("click", () => {
        if (likeImageNone.style.display === 'none') {
            likeImageNone.style.display = 'block';
            likeImageYes.style.display = 'none';
            if (count > 0) {
                count--;
            }
            likeCount.textContent = count;
        } else {
            likeImageNone.style.display = 'none';
            likeImageYes.style.display = 'block';
            count++;
            likeCount.textContent = count;
        }
    });
});

//공유 창

// 모든 viweType 버튼과 clickView 요소를 선택합니다.
const viweTypeButtons = document.querySelectorAll(".viweType");
const clickViewDivs = document.querySelectorAll(".clickView");

// 모든 viweType 버튼에 대한 클릭 이벤트 핸들러를 등록합니다.
viweTypeButtons.forEach(button => {
    button.addEventListener("click", function(event) {
        // 클릭한 viweType 버튼의 data-target 속성 값을 가져옵니다.
        const targetId = button.dataset.target;

        // 가져온 targetId를 사용하여 clickView 요소를 찾습니다.
        const targetElement = document.getElementById(targetId);

        // 다른 모든 clickView 요소를 숨깁니다.
        clickViewDivs.forEach(div => {
            if (div !== targetElement) {
                div.style.display = "none";
            }
        });

        // 클릭한 요소가 이미 보이는 상태라면 닫습니다.
        if (targetElement.style.display === "block") {
            targetElement.style.display = "none";
        } else {
            targetElement.style.display = "block";
        }

        // 이벤트 버블링을 중지합니다.
        event.stopPropagation();
    });
});

// 전체 문서에 클릭 이벤트 핸들러를 등록합니다.
document.addEventListener("click", function() {
    // 모든 clickView 요소를 숨깁니다.
    clickViewDivs.forEach(div => {
        div.style.display = "none";
    });
});

//댓글창으로 이동 !!
//const replyBTN = document.querySelector(".replyBTN")


// 페이지 로드 시 초기화
window.addEventListener("DOMContentLoaded", (event) => {
    // 스크롤 이벤트 리스너 추가
    window.addEventListener("scroll", () => {
        const headerNavWrap = document.querySelector(".headerNavWrap");
        const headerNav=document.querySelector(".headerNav");
        const h3None=document.querySelector(".h3None");
        // 스크롤 위치를 가져옴
        const scrollPosition = window.scrollY;

        // 스크롤 위치에 따라 네비게이션 메뉴 스타일 변경
        if (scrollPosition > 100) {
            headerNavWrap.classList.add("scrolled");
            headerNav.classList.add("scrolled");
            h3None.style.display="block"
            h3None.classList.add("scrolled");
        } else {
            headerNavWrap.classList.remove("scrolled");
            headerNav.classList.remove("scrolled");
            h3None.style.display="none"
            h3None.classList.remove("scrolled");
        }
    });
});

const viewBtns=document.querySelectorAll(".viewBtn");
viewBtns.forEach((viewBtn)=>{
    viewBtn.addEventListener("click",()=>{
        sharingDIV.style.display = "block";
    });
});
const h3Element = document.querySelector("h3.h3None");
h3Element.classList.add("h3None");
