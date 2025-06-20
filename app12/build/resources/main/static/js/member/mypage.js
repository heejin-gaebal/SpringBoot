function edit(){
    const userPwd = document.querySelector("input[name=userId]").value;
    const userNick = document.querySelector("input[name=userNick]").value;
    const vo = {
        userPwd,
        userNick,
    }
    const url ="http://127.0.0.1:8080/api/member"
    const option = {
        method : "PUT",
        headers : {            
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(vo),
    };
    fetch(url , option)
    .then(resp => resp.json())
    .then(map => {
        if(map.data == 1){
            alert("정보수정 성공!");
        }else{
            alert("정보수정 실패ㅠ");
        }
    })
    console.log(map.data);
}

function quit(){

}