package Project1;

import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {
			
		boolean run = true; 
			
		String[][] boardArry = new String[100][5];
		Scanner scanner = new Scanner(System.in);
		
		int count = 0;	// 생성하는 배열의 수 누적으로 카운트 하는 변수
		int num;
		int i;
		
		while (run) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.목록 | 2.생성(Creat) | 3.읽기(Read) | 4.수정(Update) | 5.삭제(Delete) | 6.종료");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("메뉴선택: ");
			
			String select = scanner.nextLine(); // 키보드 입력값을 select 변수에 저장
					
			switch (select) {
				case "1" : // select = 1 일 경우 목록 출력
					System.out.println("--------------------------------------------------------------------------");
					System.out.println("번호\t\t제목\t\t내용\t\t글쓴이\t\t조회수");
					System.out.println("--------------------------------------------------------------------------");
					
					int max = count; // 내림차순 정렬을 위해 생성된 누적 배열의 수를 번호의 최대값이라 보고 max 변수에 저장 
					int compare = max; // 삭제된 행이 있을 경우 비교를 위한 변수
					
					boolean button = true;
					
					while (button) {
						for (i = 0; i < boardArry.length; i++) {
							if (boardArry[i][0] != null) {
								if (Integer.parseInt(boardArry[i][0]) == max) { // 번호가 큰 순으로 출력
									System.out.println(boardArry[i][0] + "\t\t" + boardArry[i][1] + "\t\t" + boardArry[i][2] + "\t\t" + boardArry[i][3] + "\t\t" + boardArry[i][4]);
									max--; // 최댓값이 출력 됐으면 최대값은 -1
								} 
							}
						}
						
						if (max == compare) { // 삭제된 행이 있으면 max와 compare이 동일 해짐 --> 삭제 된 행 밑의 번호 배열 출력 하기 위해
							max--;
						} else {
							compare--; // 삭제된 행이 없을 경우
						}
						
						if (max == 0) { // 모두 출력한 경우 종료
							button = false;
						} 
						
					}
													
					break;
					
				case "2" : // select = 2 일 경우 생성
					
					for (i = 0; i < boardArry.length; i++) {					
												
						if (boardArry[i][0] == null) {
							if (i == count) { // 삭제가 없을 경우 동일
								boardArry[i][0] = String.valueOf(i+1);
							} else { // 삭제가 발생했을 경우 누적의 다음 값으로 번호 입력
								boardArry[i][0] = String.valueOf(count+1);
							}

							System.out.print("제목: ");
							boardArry[i][1] = scanner.nextLine();
							System.out.print("내용: ");
							boardArry[i][2] = scanner.nextLine();
							System.out.print("글쓴이: ");
							boardArry[i][3] = scanner.nextLine();
							boardArry[i][4] = "0";
							
							count++; // 내용이 생성 되면 카운트 +1
							
							break;

						}
			
					}
					
					break;
					
				case "3" : // select = 3인 경우 배열의 번호를 받아 내용 읽기
					System.out.print("번호: ");
					num = Integer.parseInt(scanner.nextLine());	// 읽고자 하는 번호 받음
					
					for (i = 0; i < boardArry.length; i++) {
						if ( boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) { 
							int hit = Integer.parseInt(boardArry[i][4]); // 읽으면 조회수 +1
							hit++;
							boardArry[i][4] = String.valueOf(hit);
								
							System.out.println("제목: " + boardArry[i][1]);
							System.out.println("내용: " + boardArry[i][2]);
							System.out.println("글쓴이: " + boardArry[i][3]);
							System.out.println("조회수: " + boardArry[i][4]);
							
							break;
						}
					}
					
					break;
					
				case "4" : // select = 4인 경우 배열의 번호를 받아 수정
					System.out.print("번호: ");
					num = Integer.parseInt(scanner.nextLine());	;
					
					for (i = 0; i < boardArry.length; i++) {
						if ( boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) {
							String oldTitle = boardArry[i][1]; // 기존제목을 oldTitle 변수에 저장
							System.out.println("기존제목: " + oldTitle);
							System.out.print("수정제목: ");
							String newTitle = scanner.nextLine(); // newTitle 변수에 키보드 값 입력
							if (newTitle.equals("")) { // newTitle이 공백이면 기존 제목 그대로
								boardArry[i][1] = oldTitle;
							} else {
								boardArry[i][1] = newTitle; // 공백이 아니면 제목을 newTitle로 수정
							}
							
							String oldContent = boardArry[i][2];
							System.out.println("기존내용: " + oldContent); // 기존내용을 oldContent 변수에 저장
							System.out.print("수정내용: ");
							String newContent = scanner.nextLine(); // newContent 변수에 키보드 값 입력
							if (newContent.equals("")) { // newContent가 공백이면 기존내용 그대로
								boardArry[i][2] = oldContent;
							} else {
								boardArry[i][2] = newContent; // 공백이 아니면 내용 newContent로 수정
							}
						}
					}
					
					break;
					
				case "5" :
					System.out.print("번호: ");
					num = Integer.parseInt(scanner.nextLine());	// 삭제할 번호 받아 저장
					
					for (i = 0; i < boardArry.length; i++) {
						if (boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) {
							for (int j = 0; j < boardArry[i].length; j++) {
								boardArry[i][j] = null;
							}
							break;
						}
					}
					
					break;
					
				case "6" :
					run = false;
					break;
			}
			
		}

	}

}
