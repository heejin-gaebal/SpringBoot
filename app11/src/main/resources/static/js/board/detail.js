function detail(){
    const no = location.href.split("/").pop();
    const url=`http://127.0.0.1:8080/api/board/${no}`;
    fetch(url)
    .then(resp => resp.json())
    .then(map => {
        const vo = map.data;
        const title= document.querySelector("input[name=title]");
        const content= document.querySelector("textarea[name=content]");

        title.value = vo.title;
        content.value = vo.content;
    })
    .catch(err=> {
        console.log(err);
        alert("몽가가 몽가 잘못댐");
        location.href="http://127.0.0.1:8080/board/list";
    })
}
detail();

function update(){
    const no = location.href.split("/").pop();
    const title= document.querySelector("input[name=title]").value;
    const content= document.querySelector("textarea[name=content]").value;
    const vo = {
        no,
        title,
        content,
    };
    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "PUT",
        headers : {
            "Content-Type" : "application/json"
        } ,
        body : JSON.stringify(vo) ,
    };
    fetch(url , option)
    .then(resp => resp.json())
    .then(map => {
        if(map.data == 1){
            alert("게시글 수정 성공 !");
            location.reload();
        }
    })
}

function del(){
    const result = confirm("정말 삭제하시겠습니까?");
    if(!result){
        return;
    }
    const no = location.href.split("/").pop();
    const vo = {
        no,
    };
    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "delete",
        headers : {
            "Content-Type" : "application/json"
        } ,
        body : JSON.stringify(vo) ,
    };
    fetch(url , option)
    .then(resp => resp.json())
    .then(map => {
        if(map.data == 1){
            alert("게시글 삭제 성공 !");
            location.href="http://127.0.0.1:8080/board/list"
        }
    })
}