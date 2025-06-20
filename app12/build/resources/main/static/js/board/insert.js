function insert(){
    const title = document.querySelector("input[name=title]").value;
    const content = document.querySelector("textarea[name=content]").value;
    const vo = {
        title ,
        content ,
    };
    
    /* 
        왜 insert를 빼야하지?
        BoardApiController에서 insert메서드에 매핑을 POST로 하고 경로지정을 해주지 않았으므로
        클라이언트는 컨트롤러의 기본 URL인 /api/board로 요청해야 함

        만약 매핑할때 경로까지 설정해서 @PostMapping("/insert") 이렇게 매핑했으면 
        http://127.0.0.1:8080/api/board/list 이런식의 url을 받아온다
    */
    
    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "POST" , 
        headers : {
            "Content-Type" : "application/json" ,
        } , 
        body : JSON.stringify(vo) ,
    };
    fetch(url , option)
    .then( resp => resp.json() )
    .then( map => {
        if(map.data == 1){
            alert("게시글 작성 성공 !");
            location.href = "http://127.0.0.1:8080/board/list";
        }else{
            alert("게시글 작성 실패 ...");
        }
    } )
    ;
}