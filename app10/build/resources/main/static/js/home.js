function insert(){
    const title = document.querySelector("#title").value;
    const content = document.querySelector("#content").value;
    const vo = {
        title,
        content,
    }
    const url="http://127.0.0.1:8080/api/board";
    const option = {
        method : "post",
        headers : {
            "Content-type" : "application/json"
        },
        body : JSON.stringify(vo),
    };
    fetch(url, option)
    // ---------------------------------------- 요청 패킷 보냄
    .then(resp => resp.text())
    .then(data => {
        console.log(data);
        if(data == 1){
            alert("게시글 작성 성공!");
        }else{
            alert("게시글 작성 실패...");
        }
    })// 리턴된 결과 
}

function list(pno = "1"){
    console.log("pno : " + pno);
    const url=`http://127.0.0.1:8080/api/board?pno=${pno}`;
    fetch(url)
    // get방식으로 바디 필요없고, option은 선택사항이다
    // ---------------------------------------- 요청 패킷 보내기
    . then(resp => resp.json()) //요청읽기 json형식으로 오기때문에 문자열을 바꿔줌
    . then(map =>  {         //변수이름 임의지정
        const voList = map.voList;
        const pvo = map.pvo;
        console.log(map);
        const tbody = document.querySelector("tbody");
        let str = "";
        
        for(const vo of voList){
            str += `<tr onclick='selectOne(${vo.no});'>`;
            str += `<td>${vo.no}</td>`;
            str += `<td>${vo.title}</td>`;
            str += `<td>${vo.createdDate}</td>`;
            str += "</tr>";
        }
        tbody.innerHTML = str;
        // 버튼생성 메서드 실행
        createPageAreaBtn(pvo);
    })
}

function selectOne(no){ //get방식
    const url=`http://127.0.0.1:8080/api/board/${no}`
    fetch(url)
    // ---------------------------------------- 요청 패킷 보내기
    .then(resp => resp.json())
    .then(vo => {
        console.log(vo);
        const boardDetail = document.querySelector("#boardDetail");
        let str ="";
        str += `
            <h3>제목 : ${vo.title}</h3>
            <h4>작성일 : ${vo.createdDate}</h4>
            <h4>조회수 : ${vo.hit}</h4>
            <p>내용 : ${vo.content}</p>
        `
        boardDetail.innerHTML = str;
    })
}

function createPageAreaBtn(pvo){
    const pageArea = document.querySelector("#page-area");
    pageArea.innerHTML = "";

    if(pvo.startPage != 1){
        pageArea.innerHTML += `<button onclick="list(${pvo.startPage-1})">[이전]</button>`;
    }

    for(let i=pvo.startPage; i<=pvo.endPage; i++){
        if(pvo.currentPage == i){
            pageArea.innerHTML += `<button disabled onclick="list(${i})">[${i}]</button>`;    
        }else{
            pageArea.innerHTML += `<button onclick="list(${i})">[${i}]</button>`;
        }
    }
    
    if(pvo.endPage != pvo.maxPage){
        pageArea.innerHTML += `<button onclick="list(${pvo.endPage+1})">[다음]</button>`;
    }
}