package org.ohgiraffers.fileupload;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @PostMapping("/single-file")
    public String singleFileUpload(
            @RequestParam String singleFileDescription,
            @RequestParam MultipartFile singleFile,
            Model model
    ) {
        System.out.println("singleFileDescription : " + singleFileDescription);
        System.out.println("singleFile : " + singleFile);

        /* 서버로 전달 된 MultipartFile 객체를 설정하는 경로에 저장한다. */
        String root = "src/main/resources/static";
        String filepath = root + "/uploadFiles";
        File dir = new File(filepath);

        if (!dir.exists()) dir.mkdirs();

        /* 파일명이 중복 되면 덮어쓰기 될 수 있으므로 중복 되지 않는 이름으로 변경 처리 */
        String originFileName = singleFile.getOriginalFilename(); //업로드 파일명
        String ext = originFileName.substring(originFileName.lastIndexOf(".")); //업로드 파일명에서 확장자 분리
        String savedName = UUID.randomUUID() + ext; // 고유한 파일명 생성 + 확장자 추가

        /* 파일 저장 */
        try {
            singleFile.transferTo(new File(filepath + "/" + savedName));
            model.addAttribute("message", "파일 업로드 완료!");
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "result";
    }

    @PostMapping("/multi-file")
    public String multiFileUpload(
            @RequestParam List<MultipartFile> multipartFiles,
            @RequestParam String multiFileDescription,
            Model model
    ) {

        String root = "src/main/resources/static";
        String filepath = root + "/uploadFiles";
        File dir = new File(filepath);

        if (!dir.exists()) dir.mkdirs();

        List<FileDTO> files = new ArrayList<>();

        try {

            /* 다중 파일 반복문 이용해서 파일명 변경 처리 후 저장 */
            for (MultipartFile file : multipartFiles) {
                /* 파일명이 중복 되면 덮어쓰기 될 수 있으므로 중복 되지 않는 이름으로 변경 처리 */
                String originFileName = file.getOriginalFilename(); //업로드 파일명
                String ext = originFileName.substring(originFileName.lastIndexOf(".")); //업로드 파일명에서 확장자 분리
                String savedName = UUID.randomUUID() + ext; // 고유한 파일명 생성 + 확장자 추가

                /* 파일에 관한 정보 추출 후 FileDTO에 보관 */
                files.add(new FileDTO(originFileName, savedName, filepath, multiFileDescription));

                /* 파일 저장 */

                file.transferTo(new File(filepath + "/" + savedName));

            }

            /* 서버의 정해진 경로로 파일 저장이 완료 되면 List<FileDTO> 타입의 객체에 저장된 정보를
            * DB에 insert 한다. */
            System.out.println("files : " + files);
            model.addAttribute("message", "파일 업로드 완료!");

        } catch (IOException e) {

            /* 파일 저장 중간에 실패 시 이전에 저장 된 파일 삭제 */
             for (FileDTO file : files) {
                 new File(filePath + "/" + file.getSavedFileName()).delete();
             }

            model.addAttribute("message", "파일 업로드 실패!");

        }


        return "result";
    }


}
