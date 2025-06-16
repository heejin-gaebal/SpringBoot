
function f01(){
    console.log("f01() 호출 완료~~");
    const title = document.querySelector("#a").value;
    const content = document.querySelector("#b").value;

    // POST : 127.0.0.1:8080/board/insert + packet body -> data
    const vo = {
        // title : title, 키와 값이 동일하면 아래처럼 변형 가능
        // content : content,
        title,
        content,
    };
    const url = "http://127.0.0.1:8080/api/board/insert";
    const option = {
        method : "POST",
        headers : {
            //내가 보내는거 JSON이야!
            //body에서 객체를 json으로 바꿔줄 거니까 headers에서 이 패킷 내용형식이 json이라고 타입을 지정해준다
            "Content-Type" : "application/json"
        }, 
        body :JSON.stringify(vo), //객체를 json형식으로 바꿔주기
    };
    fetch(url, option)
    .then(resp => resp.text())
    .then(data => {
        console.log("data : " + data);
        if(data == 1){
            location.href="http://127.0.0.1:8080/board/list";
        }else{
            alert("뭔가 단단히 잘못됨")
        }
    });
}