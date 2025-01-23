// 수정된 데이터를 서버로 전송
function saveChanges() {
    const updatedData = {
        num: document.getElementById('numInput').value, // 번호는 readonly로 수정 불가
        SERVER_IP: document.getElementById('serverIpInput').value,
        DATABASE_TYPE: document.getElementById('dbTypeInput').value,
        DATABASE_ID: document.getElementById('dbIdInput').value,
        REF_INFO: document.getElementById('refInfoInput').value,
        DATABASE_VERSION: document.getElementById('dbVersionInput').value,
        DATABASE_USER_ID: document.getElementById('dbUserIdInput').value
    };
//    console.log("updatedData = ", JSON.stringify(updatedData));

    axios.put('/update', [updatedData])
        .then(response => {
            alert('수정이 완료되었습니다.');
            window.location.href = "/view/get";
        })
        .catch(error => {
            console.error('수정 실패:', error);
            alert("관리자에게 문의하세요.");
        });
}

// "돌아가기" 버튼 클릭 시 페이지 돌아가기
function goBack() {
    window.history.back();
}