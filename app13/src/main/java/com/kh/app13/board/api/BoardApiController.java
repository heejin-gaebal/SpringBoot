package com.kh.app13.board.api;

import com.kh.app13.board.service.BoardService;
import com.kh.app13.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    //게시글 작성 | 파일업로드
    @PostMapping
    public Map<String, Object> insert(BoardVo vo, MultipartFile f) throws IOException {

        vo.setWriterNo("1");

        String dirPath = "D:\\dev\\spring_boot_repo\\app13\\src\\main\\resources\\static\\upload\\";
//        String filename = f.getOriginalFilename(); //원본 파일명
        String random = System.currentTimeMillis() + "_" + UUID.randomUUID().toString(); //파일의 랜덤값 문자열로 출력하게 toString 추가
        String originalFilename = f.getOriginalFilename(); //원본 파일명
        int extIdx = originalFilename.lastIndexOf("."); //파일명의 마지막 인덱스 요소 "."를 extIdx에 저장
        String ext = originalFilename.substring(extIdx); //파일명의 extIdx를 추출
        String changeName = random + ext; //랜덤 파일명 완성

        //파일 업로드 경로 \\ 파일 이름 dirPath+fileName = savePath
        String savePath = dirPath + changeName;
        File targetFile = new File(savePath);

        f.transferTo(targetFile);
        //저장할 위치의 타겟파일 객체
        //클라이언트로부터 받은 파일을 f의 targetFile로 받을 수 있음

        //service
        vo.setOriginName(originalFilename);
        vo.setChangeName(changeName);
        int result = service.insert(vo);

        //result
        Map<String, Object> map = new HashMap<>();
        map.put("data" , result);
        map.put("status" , "insert ok!!");

        return map;
    }

    @GetMapping("{no}")
    public Map<String, Object> selectOne(@PathVariable String no){

        BoardVo vo = service.selectOne(no);

        Map<String, Object> map = new HashMap<>();
        map.put("data" , vo);
        map.put("status" , "selectOne ok!!");

        return map;
    }
}
