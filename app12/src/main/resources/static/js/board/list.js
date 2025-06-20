function boardList(){
    const url = "http://127.0.0.1:8080/api/board";
    fetch(url)
    .then(resp => resp.json())
    .then(map => {
        const volist = map.data;
        const tbody = document.querySelector("tbody");
        tbody.innerHTML="";
        let str = "";

        for(const vo of volist){
            str += `
                <tr>
                    <td>${vo.no}</td>
                    <td>${vo.title}</td>
                    <td>${vo.writerNo}</td>
                <tr>
            `
        }
        tbody.innerHTML = str;
    })
}
boardList();