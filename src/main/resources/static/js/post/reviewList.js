const loginButton = document.querySelector(".loginButton");
const postWrite = document.querySelector(".postWrite");
const mainPage = document.querySelector(".mainPage");
const recipePage = document.querySelector(".recipePage");
const filterBtn = document.getElementById("filterBtn");
let filterContainer = document.getElementById("filterContainer");
let filterWrap = document.getElementById("filterWrap");
const freeItems = document.querySelectorAll(".freeItem");
let filterItems = document.querySelectorAll(".filterItem");
const freeList = document.querySelector(".freeList");
const categoryButton = document.querySelector(".categoryButton")
const catagoryInputs = document.querySelectorAll(".catagoryInput")
let checkStatuses = new Array(10);
const warningWindowWrap = document.querySelector(".warningWindowWrap")
const warningWindow = document.querySelector(".warningWindow")

// 로그인 버튼 클릭 시 로그인 화면으로 이동
loginButton.addEventListener("click", () => {
    window.location.href = "/member/login";
})
// 로그인후 클릭 하면 나오는 이벤트
const navLogin=document.querySelector(".navLogin");
const loginClick=document.querySelector(".loginClick");

navLogin.addEventListener("click",()=>{
    if(loginClick.style.display==='none'){
        loginClick.style.display = 'block';
    }else{
        loginClick.style.display = 'none';
    }
})
//검색 버튼, x 버튼 클릭 이벤트
const wrapNext=document.querySelector("#__next");
const searchWrap=document.querySelector(".searchWrap")

function searchButton(){
    wrapNext.style.display="none"
    searchWrap.style.display="block"
}
function closeX(){
    searchWrap.style.display="none"
    wrapNext.style.display="block";
}
// postWrite 클릭 시 이동
postWrite.addEventListener("click", () => {
    window.location.href = "";
})
// 메인 카테고리 클릭 시 메인 페이지로 이동
mainPage.addEventListener("click", () => {
    window.location.href = "/";
})
// 레시피 카테고리 클릭 시 레시피 페이지로 이동
recipePage.addEventListener("click", () => {
    window.location.href = "http://localhost:10000/post/recipelist";
})
// 필턴 클릭 시 필터 모달창 표시
filterBtn.addEventListener("click", () => {
    filterContainer.style.display = "block";
    catagoryInputs.forEach((catagoryInput, i) => {
        checkStatuses[i] = catagoryInput.checked;
    })
})
// 회색면 클릭 시 필터 모달창 닫기 - 필터 모달창 닫히면서 전 상태로 돌리기
filterWrap.addEventListener("click", () => {
    filterContainer.style.display = "none";
    catagoryInputs.forEach((catagoryInput, i) => {
        catagoryInput.checked = checkStatuses[i];
    })
})
// 카테고리 클릭 시 최소2개 이상 선택 경고창 표시
function showWarningAndResetCatagoryInput(catagoryInput) {
    warningWindowWrap.style.display = 'flex';
    catagoryInput.checked = true;
    warningWindow.classList.remove('slideDown');
    warningWindow.classList.add('slideUp');
    setTimeout(() => {
        warningWindow.classList.remove('slideUp');
        warningWindow.classList.add('slideDown');
        setTimeout(() => {
            warningWindowWrap.style.display = 'none';
        }, 200);
    }, 2000);
}
catagoryInputs.forEach(catagoryInput => {
    catagoryInput.addEventListener('click', () => {
        const checkedCount = document.querySelectorAll('.catagoryInput:checked').length;
        if (checkedCount < 2) {
            showWarningAndResetCatagoryInput(catagoryInput);
        }
    });
});
// 필터 내 적용버튼 클릭 시 변경사항 적용 이벤트
categoryButton.addEventListener("click",() => {
    filterContainer.style.display = "none";
})
// 새 탭으로 페이지 이동: 이동 할 게시글 주소 입력 필요
freeItems.forEach((freeItem) => freeItem.addEventListener("click", () => {
    window.open('');
}))
// 페이징 밑 무한 스크롤
let page = 1;
let isLoading = false;
// 서버에서 데이터를 가져오는 메소드
// async function getPosts() {
//   // fetch에 데이터를 가져 올 주소 입력
//   const response = await fetch("")
//   const posts = await response.json();
//   return posts.reverse(); // 최신순으로 가져오도록 역순으로 정렬
// }
// 가져온 데이터로 li태그를 만들어 클래스 이름을 주고 안에 내용을 만들어
// ul태그안에 작성하는 메소드(ul에 innerHtml할 경우 덮어쓰기가 되어 한개의 리스트만 작성된다)
// function appendPost(post) {
//   const li = document.createElement('li');
//   li.className = 'freeItemWrap';
//   li.innerHTML = `
//   <div>
//     <!-- 버튼태그에 클릭 이벤트 리스너 있으니 게시글 상세보기로 연결 -->
//     <button type="button" class="freeItem">
//       <div class="itemThumbnail">
//         <!-- 게시글 정보 가져와서 h2와 p태그 value 채우기 -->
//         <div class="contentThumbnail">
//           <h2 class="contentHeader">${post.title}</h2>
//           <p class="content">${post.body}</p>
//         </div>
//         <!-- 게시글에 이미지 있을 경우 display: block설정 필요 -->
//         <div class="imageThumbnailWrap">
//           <span class="imageThumbnail">
//             <img alt src="" decoding="async" data-nimg="fill" class="image">
//           </span>
//         </div>
//       </div>
//       <div class="itemThumbnailFooter">
//         <!-- css속성 background: url() 괄호안에 프로필의 이미지 입력 -->
//         <div class="userImage"></div>
//         <div class="nameTimeHits">
//           <!-- 닉넴임 -->
//           <span class="nickname">${post.userId}</span>
//           <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="circle">
//             <circle cx="12" cy="12" r="4"></circle>
//           </svg>
//           <!-- 등록시간 기준 0시간, 0일, 0달, 0년 전으로 입력 -->
//           <span class="time">1시간 전</span>
//           <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="circle">
//             <circle cx="12" cy="12" r="4"></circle>
//           </svg>
//           <!-- 뒤의 숫자는 받아서 출력 -->
//           <span class="hits">조회수 1</span>
//         </div>
//       </div>
//     </button>
//   </div>
//   `
//   freeList.appendChild(li);
// }
// // 한번에 보여줄 리스트의 갯수를 정하고 차츰 페이지를 증가시킨다
// function showList() {
//   // 중복되어 실행되는 경우가 있어 그것을 막기위해 로딩 유무 파악
//   if (isLoading) return;

//   isLoading = true;
//   getPosts().then((posts) => {
//     const rowCount = 20;
//     const offset = (page - 1) * rowCount;
//     const limit = offset + rowCount;
//     posts = posts.slice(offset, limit);

//     if(posts.length > 0) {
//       posts.forEach((post) => {
//         appendPost(post);
//       });
//       page++;
//     }
//     isLoading = false;
//   })
// }
// // 스크롤의 위치를 검색하고 조건에 맞춰 실행하는 함수
// function handleScroll() {
//   // 현재 문서의 상단에서 스크롤바의 위치까지의 거리를 나타내는 값을 가져온다.
//   const scrollTop = document.documentElement.scrollTop;
//   // 현재 창의 뷰포트 높이를 나타낸다.
//   const windowHeight = window.innerHeight;
//   // 문서의 총 높이를 나타내는 값을 가져온다.
//   const totalHeight = document.documentElement.scrollHeight;
//   // 스크롤바가 문서의 아래쪽 끝에 도달했을 때 아래의 코드를 실행한다.
//   if (scrollTop + windowHeight >= totalHeight - 1) {
//     showList();
//   }
// }
// // 스크롤 이벤트가 발생할 때마다 스크롤바의 위치를 검사하여 새로운 콘텐츠를 불러오게 된다.
// window.addEventListener("scroll", handleScroll);
// // 최초 실행하여 1페이지를 보여준다
// showList();