// "돌아가기" 버튼 클릭 시 페이지 돌아가기
function goBack() {
    window.history.back();
}

function saveNewUser() {
    // 입력된 데이터 가져오기
    const newUser = {
        SERVER_IP: document.getElementById('serverIpInput').value,
        DATABASE_TYPE: document.getElementById('dbTypeInput').value,
        DATABASE_ID: document.getElementById('dbIdInput').value,
        REF_INFO: document.getElementById('refInfoInput').value,
        DATABASE_VERSION: document.getElementById('dbVersionInput').value,
        DATABASE_USER_ID: document.getElementById('dbUserIdInput').value,
    };

    console.log("새로운 사용자 데이터:", JSON.stringify(newUser));

    // 서버로 POST 요청
    axios.post('/new', newUser)
        .then(response => {
            // 성공적으로 처리되었을 경우
            alert('새로운 사용자가 생성되었습니다.');
            window.location.href = "/view/get"; // 목록 페이지로 이동
        })
        .catch(error => {
            // 실패했을 경우
            console.error('사용자 생성 실패:', error);
            alert("사용자 생성에 실패했습니다. 관리자에게 문의하세요.");
        });
}
