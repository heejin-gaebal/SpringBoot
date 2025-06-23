function selectBoardOne(){
    const no = location.href.split("/").pop();
    const url = `http://127.0.0.1:8080/api/board/${no}`;
    fetch(url)
    .then(resp => resp.json()) //응답을 json형식으로 파싱해서 json()으로 호출
    .then(map => {
        console.log(map);

        const resultArea = document.querySelector("#result-area");
        const vo = map.data;
        resultArea.innerHTML = `
            <h1>${vo.title}</h1>
            <h3>${vo.hit}</h3>
            <h3>${vo.writerNo}</h3>
            <h3>${vo.content}</h3>
            <h3>${vo.originName}</h3>
            <h3>${vo.changeName}</h3>
            <img src="http://192.168.20.206:5500/upload/${vo.changeName}">
        `;
        // <img src="아이피:포트/식별자">
    });
}

selectBoardOne();