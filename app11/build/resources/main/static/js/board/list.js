function list(){
    const url="http://127.0.0.1:8080/api/board"
    fetch(url)
    .then(resp => resp.json())
    .then( map =>{
        const volist = map.data;
        let str = "";
        for(const vo of volist){
            str += `
            <tr onclick="location.href='http://127.0.0.1:8080/board/detail/${vo.no}'">
                <td>${vo.no}</td>
                <td>${vo.title}</td>
                <td>${vo.writerNo}</td>
            </tr>
        `
        }

        const tbody = document.querySelector("tbody");
        tbody.innerHTML="";
        tbody.innerHTML = str;
    })
}

//목록조회 함수 호출
list();