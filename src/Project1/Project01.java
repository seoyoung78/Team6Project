package Project1;

import java.util.Scanner;

public class Project01 {

	public static void main(String[] args) {
		boolean run = true;
		String[][] boardArry = new String[100][5];
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("1.��� | 2.����(Creat) | 3.�б�(Read) | 4.����(Update) | 5.����(Delete) | 6.����");
			System.out.println("--------------------------------------------------------------------------");
			System.out.print("�޴�����: ");
			
			String select = scanner.nextLine();
			int num;
			int i;
			int max;
			
			switch (select) {
				case "1" :
					System.out.println("--------------------------------------------------------------------------");
					System.out.println("��ȣ		����		����		�۾���		��ȸ��");
					System.out.println("--------------------------------------------------------------------------");
					
					max = 0;				
					for (i = 0; i < boardArry.length; i++) {
						if (boardArry[i][0] != null && Integer.parseInt(boardArry[i][0]) >= max) {
							max = Integer.parseInt(boardArry[i][0]);
						}
					}
					
					boolean button = true;
					
					while (button ) {
						for (i = 0; i < boardArry.length; i++) {
							if (boardArry[i][0] != null && Integer.parseInt(boardArry[i][0]) == max) {
								System.out.println(boardArry[i][0] + "		" + boardArry[i][1] + "		" + boardArry[i][2] + "		" + boardArry[i][3] + "		" + boardArry[i][4]);
								max--;
							} else if (boardArry[i][0] != null && Integer.parseInt(boardArry[i][0]) < max && max != 0) {								
								max--;
							}
							for (i = 0; i < boardArry.length; i++) {
								
							}
						}
						
						/*for (i = 0; i < boardArry.length; i++) {
							if (boardArry[i][0] != null && Integer.parseInt(boardArry[i][0]) < max && max != 0) {
								//System.out.println(max);
								max--;
								break;
							}	
						}*/
						
						if (max == 0) {
							button = false;
						}
					}
													
					break;
					
				case "2" :
					max = 0;				
					for (i = 0; i < boardArry.length; i++) {
						if (boardArry[i][0] != null && Integer.parseInt(boardArry[i][0]) > max) {
							max = Integer.parseInt(boardArry[i][0]);
						}
					}
					
					for (i = 0; i < boardArry.length; i++) {						
												
						if (boardArry[i][0] == null) {
							if (i+1 == max) {
								boardArry[i][0] = String.valueOf(i+1);
							} else {
								boardArry[i][0] = String.valueOf(max+1);
							}

							System.out.print("����: ");
							boardArry[i][1] = scanner.nextLine();
							System.out.print("����: ");
							boardArry[i][2] = scanner.nextLine();
							System.out.print("�۾���: ");
							boardArry[i][3] = scanner.nextLine();
							boardArry[i][4] = "0";
							
							break;

						}
			
					}
					
					break;
					
				case "3" :
					System.out.print("��ȣ: ");
					num = Integer.parseInt(scanner.nextLine());	;
					
					for (i = 0; i < boardArry.length; i++) {
						if ( boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) { 
							int count = Integer.parseInt(boardArry[i][4]);
							count++;
							boardArry[i][4] = String.valueOf(count);
								
							System.out.println("����: " + boardArry[i][1]);
							System.out.println("����: " + boardArry[i][2]);
							System.out.println("�۾���: " + boardArry[i][3]);
							System.out.println("��ȸ��: " + boardArry[i][4]);
							
							break;
						}
					}
					
					break;
					
				case "4" :
					System.out.print("��ȣ: ");
					num = Integer.parseInt(scanner.nextLine());	;
					
					for (i = 0; i < boardArry.length; i++) {
						if ( boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) {
							String oldTitle = boardArry[i][1];
							System.out.println("��������: " + oldTitle);
							System.out.print("��������: ");
							String newTitle = scanner.nextLine();
							if (!newTitle.equals("")) {
								boardArry[i][1] = newTitle;
							} else {
								boardArry[i][1] = oldTitle;
							}
							
							String oldContent = boardArry[i][2];
							System.out.println("��������: " + oldContent);
							System.out.print("��������: ");
							String newContent = scanner.nextLine();
							if (!newContent.equals("")) {
								boardArry[i][2] = newContent;
							} else {
								boardArry[i][2] = oldContent;
							}
						}
					}
					
					break;
					
				case "5" :
					System.out.print("��ȣ: ");
					num = Integer.parseInt(scanner.nextLine());	
					
					for (i = 0; i < boardArry.length; i++) {
						if (boardArry[i][0] != null && num == Integer.parseInt(boardArry[i][0])) {
							for (int j = 0; j < boardArry[i].length; j++) {
								//System.out.print(boardArry[i][j] + ", ");
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
