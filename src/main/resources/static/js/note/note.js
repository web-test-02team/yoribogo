// DOM 요소 가져오기
const writeNoteTextarea = document.getElementById('writeNote');
const recipientInput = document.querySelector('.flex2Btn');
const sendButton = document.querySelector('.myInfoDivBtn');
const textCount = document.querySelector('.textCount');

// 쪽지 내용 길이 체크 함수
function checkContentLength() {
    const maxLength = 1000; // 최대 길이 설정
    const currentLength = writeNoteTextarea.value.length;

    if (currentLength <= maxLength) {
        textCount.textContent = `${currentLength}/${maxLength}`;
    } else {
        // 최대 길이를 초과한 경우 처리 (예: 경고 메시지 표시)
        textCount.textContent = `${currentLength}/${maxLength} (최대 길이 초과)`;
        // 필요한 추가 처리를 여기에 추가하세요.
    }
}

// "보내기" 버튼 클릭 이벤트 핸들러
sendButton.addEventListener('click', function () {
    const recipientValue = recipientInput.value.trim(); // 받는 사람 입력 값
    const noteContent = writeNoteTextarea.value.trim(); // 쪽지 내용

    // 받는 사람 입력 여부 체크
    if (!recipientValue) {
        alert('받는 사람을 입력해주세요.');
    } else if (!noteContent) {
        alert('쪽지 내용을 입력해주세요.');
    } else {
        // 받는 사람과 쪽지 내용을 입력한 경우
        // 여기에 쪽지를 보내는 로직을 추가하세요.
        // 예: 쪽지를 서버로 전송하는 등의 작업을 수행합니다.
        // 보낸 후 메시지를 표시합니다.
        alert('쪽지를 보냈습니다.');

        // 추가 작업을 수행하세요.
    }
});

// 텍스트 입력 이벤트 리스너 등록
writeNoteTextarea.addEventListener('keyup', checkContentLength);
