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
    window.location.href = `/updatePage/${num}`;
}

