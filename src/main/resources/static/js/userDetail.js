// "돌아가기" 버튼 클릭 시 페이지 돌아가기
function goBack() {
    window.history.back();
}

function deleteUser() {
    const num = document.getElementById('numInput').textContent.trim(); // 삭제할 사용자 번호

    // 데이터는 배열로 보냄
    const nums = [parseInt(num)];

    // axios를 사용해 삭제 요청
    axios.post('/delete', nums)
        .then(response => {
            alert('사용자가 삭제되었습니다.');
            window.location.href = "/view/get";  // 삭제 후 페이지 리다이렉션
        })
        .catch(error => {
            console.error('삭제 실패:', error);
            alert("관리자에게 문의주세요.");
        });
}

function update() {
    const num = document.getElementById('numInput').textContent.trim();
    // 모든 input 요소를 선택
    const inputs = document.querySelectorAll('#userDetailContainer .value');

    // 각 input 요소에서 readonly 속성 제거
    inputs.forEach(input => {
        input.removeAttribute('readonly');
    });

    // 저장 버튼 활성화 및 색상 변경
    const saveButton = document.getElementById('saveChangesBtn');
    saveButton.disabled = false;
    saveButton.style.backgroundColor = '#008b8b';
    saveButton.style.cursor = 'pointer'; // 커서를 포인터로 변경

    // 수정 버튼 비활성화 및 색상 변경
    const updateButton = document.getElementById('updateBtn');
    updateButton.disabled = true;
    updateButton.style.backgroundColor = '#008b8b';
    updateButton.style.backgroundColor = 'gray';
    updateButton.style.cursor = 'not-allowed';

    // <h1> 텍스트 변경
    const heading = document.querySelector('h1');
    heading.textContent = '수정 페이지';

}

// 수정된 데이터를 서버로 전송
function saveChanges() {
    const updatedData = {
        num: document.getElementById('numInput').textContent.trim(),
        SERVER_IP: document.getElementById('serverIpInput').value,
        DATABASE_TYPE: document.getElementById('dbTypeInput').value,
        DATABASE_ID: document.getElementById('dbIdInput').value,
        REF_INFO: document.getElementById('refInfoInput').value,
        DATABASE_VERSION: document.getElementById('dbVersionInput').value,
        DATABASE_USER_ID: document.getElementById('dbUserIdInput').value
    };
    console.log("updatedData = ", updatedData);

    axios.put('/update', updatedData)
        .then(response => {
            alert('수정이 완료되었습니다.');
            window.location.href = "/view/get";
        })
        .catch(error => {
            console.error('수정 실패:', error);
            alert("관리자에게 문의하세요.");
        });
}

