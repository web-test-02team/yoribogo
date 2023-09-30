const deleteBtns = document.querySelectorAll(".deleteBtns");
const modalDiv = document.querySelector("#modalContainer");
const cancelBtn = document.querySelector(".cancelBtn");
const confirmBtn = document.querySelector(".confirmBtn");
const recipeLists = document.querySelectorAll(".recipeList");
const cancelLists = document.querySelectorAll(".cancelList");

const spanCount = document.querySelector(".spanCount");
const postNumber = document.querySelector(".postNumberP");
const cancelNumber = document.querySelector(".cancelNumberP");
const noData = document.querySelector(".noDataDisplay");

// 게시글 개수에 따른 숫자 바꾸기
function updateRecipeCount() {
    const newRecipeLists = document.querySelectorAll(".recipeList");
    const newCount = newRecipeLists.length;

    spanCount.textContent = newCount;
    postNumber.textContent = newCount;

    // 게시글 개수에 따라 noData 요소 표시 여부 업데이트
    if (newCount === 0) {
        noData.style.display = "block";
    } else {
        noData.style.display = "none";
    }
}
// 초기 업데이트 수행
updateRecipeCount();
function updateCancelCount() {
    const newCancelLists = document.querySelectorAll(".cancelList");
    const newCancelCount = newCancelLists.length;

    spanCount.textContent = newCancelCount;
    cancelNumber.textContent = newCancelCount;
}

deleteBtns.forEach((btn, index) => {
    btn.addEventListener("click", () => {
        modalDiv.style.display = "block";

        confirmBtn.addEventListener("click", () => {
            console.log(recipeLists[index]);
            recipeLists[index].remove();
            modalDiv.style.display = "none";

            updateRecipeCount();
        });
    });
});

cancelBtn.addEventListener("click", () => {
    modalDiv.style.display = "none";
});

cancelBtn.addEventListener("click", () => {
    modalDiv.style.display = "none";
});

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


// 카테고리, 공유, 조회순 모달
const categoryBtn = document.getElementById("rangeCategoryBtn");
const shareBtn = document.getElementById("rangeShareBtn");
const orderBtn = document.getElementById("rangeOrderBtn");
const rangeCategory = document.getElementById("rangeCategory");
const rangeShare = document.getElementById("rangeShare");
const rangeOrder = document.getElementById("rangeOrder");
const categorySpan = document.querySelector("#categorySpan");
const shareSpan = document.querySelector("#shareSpan");
const orderSpan = document.querySelector("#orderSpan");
const categoryBtns = document.querySelectorAll(".categoryBtns");
const shareBtns = document.querySelectorAll(".shareBtns");
const orderBtns = document.querySelectorAll(".orderBtns");
const categorySvg = document.querySelector(".svgCategory")
const shareSvg = document.querySelector(".svgShare")
const timeSvg = document.querySelector(".svgTime")
let isShowCategory = false;
let isShowShare = false;
let isShowOrder = false;


categoryBtn.addEventListener("click", () => {
    if (!isShowCategory) {
        rangeCategory.style.display = "block";
        categoryBtn.style.borderColor="#5b44ea";
        isShowCategory = true;
        categorySvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="shrink-0 ml-[4px] w-[10px] h-[10px]">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M20.73 15.58a1.076 1.076 0 0 1-1.587.13L12 9.168 4.857 15.71a1.076 1.076 0 0 1-1.586-.13 1.26 1.26 0 0 1 .122-1.695L12 6l8.607 7.885a1.26 1.26 0 0 1 .122 1.695Z"></path>
            </svg>
        `;
    } else if (isShowCategory) {
        rangeCategory.style.display = "none";
        isShowCategory = false;
        categoryBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        categorySvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});

categoryBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        categorySpan.textContent = buttonText;
        rangeCategory.style.display = "none";
        categoryBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        isShowCategory = false;
        categorySvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    });
});

// 전역 이벤트 리스너 추가
document.addEventListener("click", (event) => {
    const target = event.target;

    // 모달 영역인지 확인
    const isModalContent = rangeCategory.contains(target) || categoryBtn.contains(target);

    if (!isModalContent && isShowCategory) {
        // 모달이 열려있고, 모달 영역 외부를 클릭한 경우 모달을 닫음
        rangeCategory.style.display = "none";
        categoryBtn.style.borderColor = "rgba(0, 0, 0, 0.1)";
        isShowCategory = false;
        categorySvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});




shareBtn.addEventListener("click", () => {
    if (!isShowShare) {
        rangeShare.style.display = "block";
        shareBtn.style.borderColor="#5b44ea";
        isShowShare = true;
        shareSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="shrink-0 ml-[4px] w-[10px] h-[10px]">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M20.73 15.58a1.076 1.076 0 0 1-1.587.13L12 9.168 4.857 15.71a1.076 1.076 0 0 1-1.586-.13 1.26 1.26 0 0 1 .122-1.695L12 6l8.607 7.885a1.26 1.26 0 0 1 .122 1.695Z"></path>
            </svg>
        `;
    } else if (isShowShare) {
        rangeShare.style.display = "none";
        isShowShare = false;
        shareBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        shareSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});

orderBtn.addEventListener("click", () => {
    if (!isShowOrder) {
        rangeOrder.style.display = "block";
        orderBtn.style.borderColor="#5b44ea";
        isShowOrder = true;
        timeSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="shrink-0 ml-[4px] w-[10px] h-[10px]">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M20.73 15.58a1.076 1.076 0 0 1-1.587.13L12 9.168 4.857 15.71a1.076 1.076 0 0 1-1.586-.13 1.26 1.26 0 0 1 .122-1.695L12 6l8.607 7.885a1.26 1.26 0 0 1 .122 1.695Z"></path>
            </svg>
        `;
    } else if (isShowOrder) {
        rangeOrder.style.display = "none";
        isShowOrder = false;
        orderBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        timeSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});


shareBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        shareSpan.textContent = buttonText;
        rangeShare.style.display = "none";
        isShowShare = false;
        shareBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        shareSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    });
});

orderBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        orderSpan.textContent = buttonText;
        rangeOrder.style.display = "none";
        isShowOrder = false;
        orderBtn.style.borderColor="rgba(0, 0, 0, 0.1)";
        timeSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    });
});

// 전역 이벤트 리스너 추가
document.addEventListener("click", (event) => {
    const target = event.target;

    // 모달 영역인지 확인
    const isModalContent = rangeShare.contains(target) || shareBtn.contains(target);

    if (!isModalContent && isShowShare) {
        // 모달이 열려있고, 모달 영역 외부를 클릭한 경우 모달을 닫음
        rangeShare.style.display = "none";
        shareBtn.style.borderColor = "rgba(0, 0, 0, 0.1)";
        isShowShare = false;
        shareSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});

// 전역 이벤트 리스너 추가
document.addEventListener("click", (event) => {
    const target = event.target;

    // 모달 영역인지 확인
    const isModalContent = rangeOrder.contains(target) || orderBtn.contains(target);

    if (!isModalContent && isShowOrder) {
        // 모달이 열려있고, 모달 영역 외부를 클릭한 경우 모달을 닫음
        rangeOrder.style.display = "none";
        orderBtn.style.borderColor = "rgba(0, 0, 0, 0.1)";
        isShowOrder = false;
        timeSvg.innerHTML = `
            <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" class="svgCategory">
                <path fill-rule="evenodd" clip-rule="evenodd" d="M3.27 8.42a1.076 1.076 0 0 1 1.587-.13L12 14.832l7.143-6.544a1.076 1.076 0 0 1 1.586.13 1.26 1.26 0 0 1-.122 1.696L12 18l-8.607-7.885A1.26 1.26 0 0 1 3.27 8.42Z"></path>
            </svg>
        `;
    }
});