package movie;

import dto.MovieDTO;
import sort.AscRatings;
import sort.AscTitle;
import sort.DescRatings;
import sort.DescTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieMenu {
    /* 필드 */
    private MovieManager movieManager = new MovieManager();
    private Scanner sc = new Scanner(System.in);

    /* 메서드 */
    public void menu() {

        while (true) {
            System.out.println("====== 영화 관리시스템입니다 ======");
            System.out.println("다음 메뉴 중 하나를 선택해주세요.");
            System.out.println("1. 리스트 추가");
            System.out.println("2. 리스트 수정");
            System.out.println("3. 리스트 삭제");
            System.out.println("4. 리스트 조회"); //1. 전체 조회 2. 정렬하여 조회
            System.out.println("5. 리스트 검색"); //1. 제목으로 검색 2. 감독으로 검색
            System.out.println("6. 프로그램 종료");
            System.out.print("메뉴 선택 : ");
            System.out.println();

            int userMenuInput = sc.nextInt();

            if (userMenuInput == 1) {
                addList();
            } else if (userMenuInput == 2) {
                updateList();
            } else if (userMenuInput == 3) {
                deleteList();
            } else if (userMenuInput == 4) {
                System.out.println("====== 조회 메뉴 ======");
                System.out.println("1. 전체 조회");
                System.out.println("2. 정렬하여 조회");
                System.out.print("메뉴 선택 : ");
                int userMenuInquiry = sc.nextInt();
                if (userMenuInquiry == 1) {
                    selectList();
                } else if (userMenuInquiry == 2) {
                    sortList();
                }
            } else if (userMenuInput == 5) {
                System.out.println("====== 검색 메뉴 ======");
                System.out.println("1. 제목으로 검색");
                System.out.println("2. 감독으로 검색");
                System.out.print("메뉴 선택 : ");
                int userFindMenu = sc.nextInt();
                if (userFindMenu == 1) {
                    searchTitle();
                } else if (userFindMenu == 2) {
                    searchDirectors();
                }
            } else if (userMenuInput == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private void addList() {
        System.out.println("영화 제목을 입력해주세요.");
        System.out.println("입력 : ");
        sc.nextLine();
        String movieTitle = sc.nextLine();
        System.out.println("감독 이름을 입력해주세요.");
        System.out.println("입력 : ");
        String movieDriectors = sc.nextLine();
        System.out.println("영화 평점을 입력해주세요.");
        System.out.println("입력 : ");
        String movieRatings = sc.nextLine();

        movieManager.addList(new MovieDTO(movieTitle, movieDriectors, movieRatings));

    }

    private void updateList() {
        System.out.println("수정할 영화의 id를 입력해주세요.");
        System.out.println("입력 : ");
        int movieId = sc.nextInt();
        System.out.println("수정할 영화의 제목을 입력해주세요.");
        System.out.println("입력 : ");
        sc.nextLine();
        String movieTitle = sc.nextLine();
        System.out.println("수정할 영화의 감독 이름을 입력해주세요.");
        System.out.println("입력 : ");
        String movieDirectors = sc.nextLine();
        System.out.println("수정할 영화의 평점을 입력해주세요.");
        System.out.println("입력 : ");
        String movieRatings = sc.nextLine();

        MovieDTO updateMovie = new MovieDTO(movieId, movieTitle, movieDirectors, movieRatings);

        if (movieManager.updateList(updateMovie)) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("수정할 영화를 찾지 못했습니다.");
        }

    }

    private void deleteList() {
        System.out.println("삭제할 영화의 id를 입력해주세요.");
        System.out.println("입력 : ");
        if (movieManager.deleteList(sc.nextInt())){
            System.out.println("영화가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 영화를 찾지 못했습니다.");
        }
        sc.nextLine();
    }

    private void selectList() {
        System.out.println("====== 전체 영화 조회 ======");
        List<MovieDTO> movieList = movieManager.selectList();

        if (!movieList.isEmpty()) {
            for (MovieDTO movie : movieList) {
                System.out.println(movie.toString());
            }
        } else {
            System.out.println("영화 목록이 존재하지 않습니다.");
        }
    }

    public void sortList() {
        System.out.println("====== 정렬 메뉴 ======");
        System.out.println("1. 제목 오름차순 정렬");
        System.out.println("2. 제목 내림차순 정렬");
        System.out.println("3. 평점(IMDb) 오름차순 정렬");
        System.out.println("4. 평점(IMDb) 내림차순 정렬");
        System.out.print("메뉴 선택 : ");
        int userSortInput = sc.nextInt();
        ascDsc(userSortInput);
    }

    public void ascDsc(int userSortInput) {
        List<MovieDTO> movieList = movieManager.selectList();

        if (movieList.isEmpty()) {
            System.out.println("목록이 존재하지 않습니다.");
            return;
        }

        /* 사본 데이터 별도 생성 */
        List<MovieDTO> sortList = new ArrayList<>();
        sortList.addAll(movieList);


        if (userSortInput == 1){
            System.out.println("====== 영화 제목 오름차순 정렬 ======");
            sortList.sort(new AscTitle());
        } else if (userSortInput == 2) {
            System.out.println("====== 영화 제목 내림차순 정렬 ======");
            sortList.sort(new DescTitle());
        } else if (userSortInput == 3) {
            System.out.println("====== 영화 평점 오름차순 정렬 ======");
            sortList.sort(new AscRatings());
        } else if (userSortInput == 4) {
            System.out.println("====== 영화 평점 내림차순 정렬 ======");
            sortList.sort(new DescRatings());
        }

        for (int i = 0; i < sortList.size(); i++) {
            System.out.println(sortList.get(i));
        }
    }

    private void searchTitle() {
        System.out.println("검색하실 영화 제목을 입력해주세요.");
        System.out.println("입력 : ");
        sc.nextLine();
        List<MovieDTO> searchList = movieManager.searchTitle(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }

    private void searchDirectors() {
        System.out.println("검색하실 감독 이름을 입력해주세요.");
        System.out.println("입력 : ");
        sc.nextLine();
        List<MovieDTO> searchList = movieManager.searchDirectors(sc.nextLine());

        if (!searchList.isEmpty()) {
            for (int i = 0; i < searchList.size(); i++) {
                System.out.println(searchList.get(i));
            }
        } else {
            System.out.println("검색 결과가 없습니다.");
        }
    }
}


