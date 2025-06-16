console.log("리스트 연결 되나용???");

const url = "http://127.0.0.1:8080/api/board/list";
//headers 와 body에 들어갈 내용이 없으므로 생략
//url만 연결하므로 디폴트 get방식
fetch(url)
.then(resp => resp.json())
.then(data => {
    console.log(data);
})