// const content = document.querySelector('.textBoxHidden');

// document.querySelector('.more').addEventListener('click', function() {
//   if(content.style.display === 'none' || content.style.display === '') {
//       content.style.display = 'block';
//   } else {
//       content.style.display = 'none';
//   }
// });



document.querySelector('.more').addEventListener('click', function () {
    // '더보기' 버튼 숨김
    this.style.display = 'none';
    document.querySelector('.textBoxHidden').style.height = 'auto';
    document.querySelector('.emptySpace').style.display = 'none';
});



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
// // 로그인후 클릭 하면 나오는 이벤트
// let loginImg = document.querySelector(".loginImg");
// const loginClick = document.querySelector(".loginClick");
// loginImg.addEventListener("click", () => {
//     if (loginClick.style.display == 'none') {
//         loginClick.style.display = 'block';
//     } else {
//         loginClick.style.display = 'none';
//     }
// })
//카카오 로그인시..
// const kakaoBtn=document.querySelector(".kakaoBtn");

// 페이지 로드 시 초기화
window.addEventListener("DOMContentLoaded", (event) => {
    // 스크롤 이벤트 리스너 추가
    window.addEventListener("scroll", () => {
        const headerNavWrap = document.querySelector(".headerNavWrap");
        const headerNav = document.querySelector(".headerNav");
        const h3None = document.querySelector(".h3None");
        // 스크롤 위치를 가져옴
        const scrollPosition = window.scrollY;

        // 스크롤 위치에 따라 네비게이션 메뉴 스타일 변경
        if (scrollPosition > 100) {
            headerNavWrap.classList.add("scrolled");
            headerNav.classList.add("scrolled");
            h3None.style.display = "block"
            h3None.classList.add("scrolled");
        } else {
            headerNavWrap.classList.remove("scrolled");
            headerNav.classList.remove("scrolled");
            h3None.style.display = "none"
            h3None.classList.remove("scrolled");
        }
    });
});
const postButton=document.querySelector(".postButton");
postButton.addEventListener("click",()=>{
    window.location.href="http://localhost:10000/member/mainPost";
})