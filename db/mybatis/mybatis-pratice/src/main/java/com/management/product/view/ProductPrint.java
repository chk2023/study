package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // 주석을 지우고 다음 네 가지 메소드를 작성하세요.

    public void printAllProductList(List<ProductDTO> productList) {

        // 1. 전체 조회한 목록 출력하는 메소드
        //    (조건) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.
        System.out.println("====== 메뉴 목록 ======");
        for (ProductDTO product : productList){
            System.out.println(product);
        }
    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        // 2. 조건에 따라 조회한 목록을 출력하는 메소드
        //    (조건 1) SearchCondition 객체로 검색 조건이 무엇인지 출력하세요.
        //    (조건 2) List<ProductDTO>로 받아온 데이터 목록을 전체 출력하세요.
        System.out.println("====== 메뉴 조회 ======");
        System.out.println(searchCondition.toString());
        for (ProductDTO product : productList) {
            System.out.println(product);
        }

    }

    public void printSuccessMessage(String successCode) {

        // 3. 성공메시지를 출력하는 메소드
        //    (조건) 성공코드를 전달받아 성공을 알리는 메시지를 출력하세요.
        System.out.println("====== Success ======");
        String successMessage = "";

        switch (successCode) {
            case "registNewProduct" :
                successMessage = "메뉴 추가에 성공하였습니다."; break;
            case "modifyProduct" :
                successMessage = "메뉴 수정에 성공하였습니다."; break;
            case "deleteProduct" :
                successMessage = "메뉴 삭제에 성공하였습니다."; break;
        }
        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {

        // 4. 에러메시지를 출력하는 메소드
        //    (조건) 에러코드를 전달받아 에러를 알리는 메시지를 출력하세요.
        System.out.println("====== Error ======");
        String errorMessage = "";

        switch (errorCode) {
            case "selectAllList" :
                errorMessage = "메뉴 목록 조회에 실패하였습니다."; break;
            case "selectList" :
                errorMessage = "메뉴 조회에 실패하였습니다."; break;
            case "registNewProduct" :
                errorMessage = "메뉴 추가에 실패하였습니다."; break;
            case "modifyProduct" :
                errorMessage = "메뉴 수정에 실패하였습니다."; break;
            case "deleteProduct" :
                errorMessage = "메뉴 삭제에 실패하였습니다."; break;
        }
        System.out.println(errorMessage);
    }

}
