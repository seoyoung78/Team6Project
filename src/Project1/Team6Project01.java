package Project1;

import java.util.Scanner;

public class Team6Project01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[][] boardArray = new String[100][5];

		int selectNum;	//switch문의 조건문, 입력값
		int listNum = 1; //게시글의 번호
		String title;
		String content;
		String writer;

		boolean run = true;
		boolean check = false;		//일치하는 번호가 있는지 검사
		boolean autoMenu = false;	//목록 자동 출력 검사


		while(run){
			if(autoMenu == true) {	//목록을 자동으로 출력해야 할 때
				selectNum = 1;
			}else {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.목록 | 2.생성(Create) | 3.읽기(Read) | 4.수정(Update) | 5.삭제(Delete) | 6.종료");
				System.out.println("--------------------------------------------------------------------------");
				System.out.print("메뉴 선택 : ");

				selectNum = Integer.parseInt(scan.nextLine());
			}

			switch (selectNum){
			case 1:
				System.out.println("1.목록> ");
				System.out.println("---------------------------------------------------");
				System.out.println("번호    제목    내용    글쓴이    조회수");
				System.out.println("---------------------------------------------------");

				for(int i=0; i<boardArray.length; i++) {	//출력
					if(boardArray[i][0] != null) {	//번호가 존재하면 출력
						System.out.println(boardArray[i][0] + "\t" +
								boardArray[i][1] + "\t" +
								boardArray[i][2] + "\t" +
								boardArray[i][3] + "\t" +
								boardArray[i][4]);
					}
				}

				autoMenu = false;
				break;
				
			case 2:
				System.out.println("2.생성> ");

				while(true) {
					System.out.print("제목 : ");
					title = scan.nextLine();
					
					if(title.length() != 0) {
						break;
					}
				}
				
				while(true) {
					System.out.print("내용 : ");
					content = scan.nextLine();
					
					if(content.length() != 0) {
						break;
					}
				}
				
				while(true) {
					System.out.print("글쓴이 : ");
					writer = scan.nextLine();
					
					if(writer.length() != 0) {
						break;
					}
				}
				
		
				String[] newBoard = {	//배열을 생성하고 
						String.valueOf(listNum),
						title,
						content,
						writer,
						String.valueOf(0)
				};

				for(int i =0;i<boardArray.length;i++) {		//삽입
					if(boardArray[i][0] == null) { //null 위치를 찾아서 삽입
						boardArray[i] = newBoard;
						listNum++;
						break;
					}
				}
				
				/*
				 	4
				 	null ex)5 생성
				 	null  
				 	1
				 	-> 최종 null 밑은 정렬이 되어있기 때문에 처음 null을 만났을때 까지만 정렬을 해주면 됨.
				 	   따라서 null을 만났을 때는 break로 반복문 종료
				 		
				 	결과 :	5
				 			4
				 			null
				 			1
				 */
				for(int i=0; i<boardArray.length; i++) {	//정렬
					if(boardArray[i][0] == null) {
						break;
					}
					for(int j=0; j<i; j++) { //현재위치 값과 다음위치 값을 비교하여 교체
						if(Integer.parseInt(boardArray[i][0]) > Integer.parseInt(boardArray[j][0])) {
							String[] temp = boardArray[i];
							boardArray[i] = boardArray[j];
							boardArray[j] = temp;
						
						}
					}
				}

				autoMenu = true;
				break;
				
			case 3:	
				System.out.println("3.읽기> ");
				System.out.print("글번호를 입력하세요 : ");
				int readNum = Integer.parseInt(scan.nextLine());

				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){	//번호를 찾을때까지 반복문 실행
						continue;
					}
					if (readNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("제목: " + boardArray[i][1]);
						System.out.println("내용: " + boardArray[i][2]);
						System.out.println("글쓴이: " + boardArray[i][3]);
						boardArray[i][4] = String.valueOf(Integer.parseInt(boardArray[i][4])+1);
						System.out.println("조회수: " + boardArray[i][4]);
						check = true;
						break;
					}
				}

				if(check == false) {
					System.out.println("읽을 게시글이 없습니다.");
				}else {
					check = false;
				}

				autoMenu = false;
				break;
				
			case 4:
				System.out.println("4.수정>");
				System.out.println("글번호를 입력하세요 : ");
				int updatetNum = Integer.parseInt(scan.nextLine());

				String updateTitle;
				String updateContent;
				
				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){	//번호를 찾을때까지 반복문 실행
						continue;
					}
					if (updatetNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("기존 제목: " + boardArray[i][1]);
						System.out.print("변경할 제목: ");
						updateTitle = scan.nextLine();
						System.out.println("기존 내용: " + boardArray[i][2]);
						System.out.print("변경할 내용: ");
						updateContent = scan.nextLine();
						
						//값이 있을경우에 새로운 값 저장
						if(updateTitle.length() != 0) {
							boardArray[i][1] = updateTitle;
						}
						if(updateContent.length() != 0) {
							boardArray[i][2] = updateContent;
						}
						System.out.println("수정되었습니다.");
						check = true;
						break;
					}
				}

				if(check == false) {
					System.out.println("수정할 게시글이 없습니다.");
				}else {
					check = false;
				}

				autoMenu = true;
				break;
				
			case 5:
				System.out.println("5.삭제>");
				System.out.println("글번호를 입력하세요 : ");
				int deleteNum = Integer.parseInt(scan.nextLine());

				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null) {	//번호를 찾을때까지 반복문 실행
						continue;
					}
					if (deleteNum == Integer.parseInt(boardArray[i][0])) {
						for(int j=0; j<boardArray[i].length; j++) {
							boardArray[i][j] = null;
						}
						System.out.println("삭제되었습니다.");
						check = true;
						break;
					}
				}

				if(check == false) {
					System.out.println("삭제할 게시글이 없습니다.");
				}else {
					check = false;
				}
				
				autoMenu = true;
				break;
				
			case 6:
				System.out.println("프로그램을 종료");
				run = false;
				break;
				
			default:
				System.out.println("정확한 번호를 입력해주세요.");
				break;
			}

		}
	}

}
