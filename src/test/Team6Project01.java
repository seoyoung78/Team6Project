package test;

import java.util.Scanner;

public class Team6Project01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // 스캐너를 scan에 담아오고

		String[][] boardArray = new String[100][5]; // 행 100개 열 5개의 2차 배열을 선언합니다.

		int selectNum; // 사용자가 고를 메뉴를 int 타입으로 선언하고
		int listNum = 1; // 게시글 번호를 1로 초기화 해둡니다. 게시글 번호는 1번부터 100번까지 있으니까요.
		String title;  // 추후 사용할 제목과
		String content; // 내용
		String writer; // 글쓴이를 String으로 선언해둡니다.

		boolean check = false; //유효한 입력값인지 검사해서 유효하지 않다면 초기메뉴로 돌아가게 할 거에요.
		boolean run = true; // run은 우선 true로 설정해서 while 안에서 모든 메뉴가 돌아가도록 할 겁니다.
		boolean autoMenu = false;	//목록확인이 필요할 때 true로 바꿔서 목록을 자동 출력할 겁니다.


		while(run){
			if(autoMenu == true) { 
				//목록을 출력하는 부분은 switch문 안의 case 1에 있습니다.
				// while반복문 내에서 목록자동출력이 필요한 경우 autoMemu를 true로 바꿔줄 겁니다.
				selectNum = 1;
			}else {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.목록 | 2.생성(Create) | 3.읽기(Read) | 4.수정(Update) | 5.삭제(Delete) | 6.종료");
				System.out.println("--------------------------------------------------------------------------");
				System.out.print("메뉴 선택 : ");
				// 메뉴를 고르기 위해서 선택 옵션을 출력하고
				selectNum = Integer.parseInt(scan.nextLine());
				// 스캔 받은 String을 int 타입으로 변환해 selectNum에 저장합니다.
			}

			switch (selectNum){
			case 1: // 목록을 정렬해서 출력하는 부분입니다. autoMenu가 true인 경우 이 부분이 실행됩니다.
				System.out.println("1.목록> ");
				System.out.println("---------------------------------------------------");
				System.out.println("번호    제목    내용    글쓴이    조회수");
				System.out.println("---------------------------------------------------");

				for(int i=0; i<boardArray.length; i++) {	//정렬
					if(boardArray[i][0] == null) {
						break; //board[i][0]는 게시글번호인데, 
							// 이게 null인 경우는 어차피 삭제가 된 자리이므로
							// 정렬에 문제가 생기지 않았기 때문에 반복문을 빠져나갑니다.
					}
					for(int j=0; j<i; j++) {
						if(Integer.parseInt(boardArray[i][0]) > Integer.parseInt(boardArray[j][0])) {
							// 게시글 번호의 앞뒤를 비교해서 앞이 더 크다면
							String[] temp = boardArray[i];  // 그 게시글을 temp 배열에 담습니다.
							boardArray[i] = boardArray[j]; // 앞자리에 뒤의 게시글을 담고
							boardArray[j] = temp; // 뒷자리에 temp 배열을 담아 재배열 합니다.
						
						}
						
					}
				}
				
				for(int i=0; i<boardArray.length; i++) {	//출력
					if(boardArray[i][0] != null) { // 게시글이 null이 아닌 경우
						System.out.println(boardArray[i][0] + "\t" +
								boardArray[i][1] + "\t" +
								boardArray[i][2] + "\t" +
								boardArray[i][3] + "\t" +
								boardArray[i][4]);
					} // 전체 게시글을 출력합니다.
				}

				autoMenu = false; // autoMenu를 false로 만들어야 메뉴 선택이 가능해집니다.
				break; // switch 를 빠져나갑니다.
			case 2: // 목록을 생성하는 부분입니다.
				System.out.println("2.생성> ");

				System.out.print("제목 : ");
				title = scan.nextLine();
				System.out.print("내용 : ");
				content = scan.nextLine();
				System.out.print("글쓴이 : ");
				writer = scan.nextLine();
				// 제목, 내용, 글쓴이를 String으로 입력받습니다.

				String[] newBoard = {
						String.valueOf(listNum), // null이 있다면 String타입으로 바꿔 게시글 번호를 저장합니다.
						title,
						content,
						writer, // 제목, 내용, 글쓴이를 저장하고
						String.valueOf(0) // 조회수는 0부터 시작하지만 String 타입으로 바꿔 초기화합니다.
				};

				for(int i =0;i<boardArray.length;i++) {
					if(boardArray[i][0] == null) {  // 삭제된 자리에는 null 이 있습니다. 그래서 null 이 있는 자리를 찾아
						boardArray[i] = newBoard;  // 새롭게 받은 값들을 저장합니다.
						listNum++; // 게시글 번호는 기존보다 1이 증가된 상태여야 게시글 번호가 동일하게 입력되지 않아요.
						break;
					}
				}

				autoMenu = true; // autoMenu가 true로 바뀌었기 때문에 case 1로 넘어가서 전체 목록을 재정렬 후 출력합니다.
				break;
			case 3:	// 게시글을 읽어오겠습니다.
				System.out.println("3.읽기> ");
				System.out.print("글번호를 입력하세요 : ");
				int readNum = Integer.parseInt(scan.nextLine());
				// 입력받은 String 타입 번호를 Int로 변환해 readNum에 넣습니다.
				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){
						continue;
					} // 위와 마찬가지로 null이 있는 경우는 정렬이 이미 되어 있다는 뜻이니 패스하고 
					if (readNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("제목: " + boardArray[i][1]);
						System.out.println("내용: " + boardArray[i][2]);
						System.out.println("글쓴이: " + boardArray[i][3]);
						boardArray[i][4] = String.valueOf(Integer.parseInt(boardArray[i][4])+1);
						System.out.println("조회수: " + boardArray[i][4]);
						check = true;
						break;
					} // 입력받은 게시글 번호와 기존 게시글 번호를 비교해서 일치하는 순간의 게시글 정보를 출력합니다. 
					// 게시글이 바뀐 경우 check 가 true로 바뀌었기 때문에 또다른 출력은 없지만
				}
				// 입력받은 게시글이 없는 경우 check 는 여전히 false 상태이므로
				// 아래와 같이 "읽을 게시글이 없다"는 문장이 출력됩니다.

				if(check == false) {
					System.out.println("읽을 게시글이 없습니다.");
				}else {
					check = false; 
				}

				autoMenu = false; // autoMenu가 false이므로 다시 메뉴를 선택할 수 있는 옵션을 출력합니다.
				break;
			case 4: // 게시글을 수정하겠습니다.
				System.out.println("4.수정>");
				System.out.println("글번호를 입력하세요 : ");
				int updateNum = Integer.parseInt(scan.nextLine());
				// 마찬가지로 숫자를 String으로 읽어 Int로 변환해 담아주고
				String updateTitle; // 수정된 제목과
				String updateContent; // 수정된 내용을 입력받을 변수를 선언해줍니다.
				
				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){
						continue;
					} // 마찬가지로 게시글번호거 null이면 패스하고
					if (updateNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("기존 제목: " + boardArray[i][1]); // 기존제목을 먼저 출력한 후
						System.out.print("변경할 제목: "); 
						updateTitle = scan.nextLine(); // 변경할 제목을 입력받습니다.
						System.out.println("기존 내용: " + boardArray[i][2]); // 기존내용도 먼저 출력하고
						System.out.print("변경할 내용: "); 
						updateContent = scan.nextLine(); // 변경할 내용을 입력받습니다.
						
						if(updateTitle.length() != 0) { // 변경할 내용을 입력받은 변수의 길이를 측정해서 빈 내용이 아니라면
							boardArray[i][1] = updateTitle; // 게시글을 업데이트 합니다.
						}
						if(updateContent.length() != 0) { // 내용도 마찬가지로 수정하고
							boardArray[i][2] = updateContent;
							System.out.println("수정되었습니다."); // 수정되었다는 출력을 내보냅니다.
						}
						
						check = true; // 수정이 되었다면 check를 true로 만들어서 게시글이 유효하다고 체크합니다.
						break;
					}
				}

				if(check == false) { // 게시글 번호가 유효한 경우에는 위의 업데이트가 실행되므로 check가 true이고, 
						// 따라서 이 문장은 출력되지 않습니다.
					System.out.println("수정할 게시글이 없습니다.");
				}else {
					check = false;
				}

				autoMenu = true; //autoMenu 에 true를 입력해 case 1로 넘어가 전체 게시글을 재정렬 후 출력합니다.
				break;
			case 5:
				System.out.println("5.삭제>");
				System.out.println("글번호를 입력하세요 : ");
				int deleteNum = Integer.parseInt(scan.nextLine());	// 삭제에서도 마찬가지로 게시글 번호를 입력받습니다.

				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null) {
						continue; // null 이면 패스하고 
					}
					if (deleteNum == Integer.parseInt(boardArray[i][0])) {
						for(int j=0; j<boardArray[i].length; j++) {
							boardArray[i][j] = null; // 해당되는 게시글 번호의 게시글전체를 null로 바꿔줍니다.
						}
						System.out.println("삭제되었습니다.");
						check = true; // 삭제되면 유효성을 true로 check 하고
						break;
					}
				}

				if(check == false) {
					System.out.println("삭제할 게시글이 없습니다.");
				}else {
					check = false;
				}
				
				autoMenu = true; // 마찬가지로 전체 목록 재정렬 후 출력합니다.
				break;
			case 6:
				System.out.println("프로그램을 종료");
				run = false; // 6을 누르면 run을 false 로 바꿔 프로그램을 종료합니다.
				break;
			}

		}
	}

}
