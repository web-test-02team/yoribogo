const loginButton = document.querySelector(".loginButton");
// const postWrite = document.querySelector(".postWrite");
// const mainPage = document.querySelector(".mainPage");
// const reviewPage = document.querySelector(".reviewPage");
// const filterBtn = document.getElementById("filterBtn");
// let filterContainer = document.getElementById("filterContainer");
// let filterWrap = document.getElementById("filterWrap");
// const freeItems = document.querySelectorAll(".freeItem");
// let filterItems = document.querySelectorAll(".filterItem");
// const freeList = document.querySelector(".freeList");
// const categoryButton = document.querySelector(".categoryButton")
// const catagoryInputs = document.querySelectorAll(".catagoryInput")
// let checkStatuses = new Array(10);
// const warningWindowWrap = document.querySelector(".warningWindowWrap")
// const warningWindow = document.querySelector(".warningWindow")

// const loginButton = document.querySelector(".loginButton");
const postWrite = document.querySelector(".postWrite");
// const paymentSystem=document.querySelector(".paymentSystem")
//로그인으로가기
loginButton.addEventListener("click", () => {
    window.location.href = "http://localhost:10000/member/login";
})

//마이페이지로 가기
postWrite.addEventListener("click", () => {
    window.location.href = "http://localhost:10000/mypage/myrecipe";
})

// 로그인 버튼 클릭 시 로그인 화면으로 이동
// loginButton.addEventListener("click", () => {
//     window.location.href = "";
// })
// 로그인후 클릭 하면 나오는 이벤트
const navLogin=document.querySelector(".navLogin");
const loginClick=document.querySelector(".loginClick");

// navLogin.addEventListener("click",()=>{
//     if(loginClick.style.display=='none'){
//         loginClick.style.display = 'block';
//     }else{
//         loginClick.style.display = 'none';
//     }
// })

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
// postWrite.addEventListener("click", () => {
//     window.location.href = "";
// })
// 메인 카테고리 클릭 시 메인 페이지로 이동
// mainPage.addEventListener("click", () => {
//     window.location.href = "";
// })
// 후기 카테고리 클릭 시 후기 페이지로 이동
// reviewPage.addEventListener("click", () => {
//     window.location.href = "";
// })