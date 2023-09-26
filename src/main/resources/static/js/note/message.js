const deleteBtns = document.querySelectorAll(".deleteBtns");
const modalDiv = document.querySelector("#modalContainer");
const cancelBtn = document.querySelector(".cancelBtn");
const confirmBtn = document.querySelector(".confirmBtn");
const recipeLists = document.querySelectorAll(".recipeList");
const cancelLists = document.querySelectorAll(".cancelList");

// 게시글 개수에 따른 숫자 바꾸기
const spanCount = document.querySelector(".spanCount");
const postNumber = document.querySelector(".postNumberP");
const cancelNumber = document.querySelector(".cancelNumberP");

// 게시완료와 임시완료
const uploadCompleteBtn = document.getElementById("uploadCompleteBar");
const saveDraftBtn = document.getElementById("saveDraftBar");
const uploadCompleteUl = document.getElementById("uploadCompleteUl");
const saveDraftUl = document.getElementById("saveDraftUl");
// 임시로 페이징 버튼 숨김
const uploadUnderBar = document.getElementById("uploadUnderBar");
const saveUnderBar = document.getElementById("saveUnderBar");

// 게시글 개수에 따른 숫자 바꾸기
spanCount.textContent = recipeLists.length;
postNumber.textContent = recipeLists.length;
cancelNumber.textContent = cancelLists.length;

function updateRecipeCount() {
    const newRecipeLists = document.querySelectorAll(".recipeList");
    const newCount = newRecipeLists.length;

    spanCount.textContent = newCount;
    postNumber.textContent = newCount;
}
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

saveDraftBtn.addEventListener("click", () => {
    saveDraftBtn.style.color = "#1d1d1e";
    uploadCompleteBtn.style.color = "#b9b9bb";
    saveUnderBar.style.display = "block";
    uploadUnderBar.style.display = "none";
    uploadCompleteUl.style.display = "none";
    saveDraftUl.style.display = "block";
    spanCount.textContent = cancelLists.length;

    deleteBtns.forEach((btn, index) => {
        btn.addEventListener("click", () => {
            modalDiv.style.display = "block";

            confirmBtn.addEventListener("click", () => {
                cancelLists[index - recipeLists.length].remove();
                modalDiv.style.display = "none";

                updateCancelCount();
            });
        });
    });
});
uploadCompleteBtn.addEventListener("click", () => {
    spanCount.textContent = recipeLists.length;
    saveDraftBtn.style.color = "#b9b9bb";
    uploadCompleteBtn.style.color = "#1d1d1e";
    saveUnderBar.style.display = "none";
    uploadUnderBar.style.display = "block";
    uploadCompleteUl.style.display = "block";
    saveDraftUl.style.display = "none";
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

function closeModals() {
    rangeCategory.style.display = "none";
    rangeShare.style.display = "none";
    rangeOrder.style.display = "none";
}

// 카테고리, 공유, 조회순 버튼 클릭 이벤트
categoryBtn.addEventListener("click", () => {
    closeModals();
    rangeCategory.style.display = "block";
});

shareBtn.addEventListener("click", () => {
    closeModals();
    rangeShare.style.display = "block";
});

orderBtn.addEventListener("click", () => {
    closeModals();
    rangeOrder.style.display = "block";
});

// 클릭 이벤트를 사용하여 다른 영역 클릭 시 모달 닫기
document.addEventListener("click", (event) => {
    if (!event.target.closest("#rangeCategoryBtn")) {
        rangeCategory.style.display = "none";
    }
    if (!event.target.closest("#rangeShareBtn")) {
        rangeShare.style.display = "none";
    }
    if (!event.target.closest("#rangeOrderBtn")) {
        rangeOrder.style.display = "none";
    }
});

// 카테고리, 공유, 조회순 항목 선택 이벤트
categoryBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        categorySpan.textContent = buttonText;
    });
});

shareBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        shareSpan.textContent = buttonText;
    });
});

orderBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
        const buttonText = btn.textContent.trim();
        orderSpan.textContent = buttonText;
    });
});




