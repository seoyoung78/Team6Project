package test;

import java.util.Scanner;

public class Team6Project01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);  // ��ĳ�ʸ� scan�� ��ƿ���

		String[][] boardArray = new String[100][5]; // �� 100�� �� 5���� 2�� �迭�� �����մϴ�.

		int selectNum; // ����ڰ� �� �޴��� int Ÿ������ �����ϰ�
		int listNum = 1; // �Խñ� ��ȣ�� 1�� �ʱ�ȭ �صӴϴ�. �Խñ� ��ȣ�� 1������ 100������ �����ϱ��.
		String title;  // ���� ����� �����
		String content; // ����
		String writer; // �۾��̸� String���� �����صӴϴ�.

		boolean check = false; //��ȿ�� �Է°����� �˻��ؼ� ��ȿ���� �ʴٸ� �ʱ�޴��� ���ư��� �� �ſ���.
		boolean run = true; // run�� �켱 true�� �����ؼ� while �ȿ��� ��� �޴��� ���ư����� �� �̴ϴ�.
		boolean autoMenu = false;	//���Ȯ���� �ʿ��� �� true�� �ٲ㼭 ����� �ڵ� ����� �̴ϴ�.


		while(run){
			if(autoMenu == true) { 
				//����� ����ϴ� �κ��� switch�� ���� case 1�� �ֽ��ϴ�.
				// while�ݺ��� ������ ����ڵ������ �ʿ��� ��� autoMemu�� true�� �ٲ��� �̴ϴ�.
				selectNum = 1;
			}else {
				System.out.println();
				System.out.println("--------------------------------------------------------------------------");
				System.out.println("1.��� | 2.����(Create) | 3.�б�(Read) | 4.����(Update) | 5.����(Delete) | 6.����");
				System.out.println("--------------------------------------------------------------------------");
				System.out.print("�޴� ���� : ");
				// �޴��� ���� ���ؼ� ���� �ɼ��� ����ϰ�
				selectNum = Integer.parseInt(scan.nextLine());
				// ��ĵ ���� String�� int Ÿ������ ��ȯ�� selectNum�� �����մϴ�.
			}

			switch (selectNum){
			case 1: // ����� �����ؼ� ����ϴ� �κ��Դϴ�. autoMenu�� true�� ��� �� �κ��� ����˴ϴ�.
				System.out.println("1.���> ");
				System.out.println("---------------------------------------------------");
				System.out.println("��ȣ    ����    ����    �۾���    ��ȸ��");
				System.out.println("---------------------------------------------------");

				for(int i=0; i<boardArray.length; i++) {	//����
					if(boardArray[i][0] == null) {
						break; //board[i][0]�� �Խñ۹�ȣ�ε�, 
							// �̰� null�� ���� ������ ������ �� �ڸ��̹Ƿ�
							// ���Ŀ� ������ ������ �ʾұ� ������ �ݺ����� ���������ϴ�.
					}
					for(int j=0; j<i; j++) {
						if(Integer.parseInt(boardArray[i][0]) > Integer.parseInt(boardArray[j][0])) {
							// �Խñ� ��ȣ�� �յڸ� ���ؼ� ���� �� ũ�ٸ�
							String[] temp = boardArray[i];  // �� �Խñ��� temp �迭�� ����ϴ�.
							boardArray[i] = boardArray[j]; // ���ڸ��� ���� �Խñ��� ���
							boardArray[j] = temp; // ���ڸ��� temp �迭�� ��� ��迭 �մϴ�.
						
						}
						
					}
				}
				
				for(int i=0; i<boardArray.length; i++) {	//���
					if(boardArray[i][0] != null) { // �Խñ��� null�� �ƴ� ���
						System.out.println(boardArray[i][0] + "\t" +
								boardArray[i][1] + "\t" +
								boardArray[i][2] + "\t" +
								boardArray[i][3] + "\t" +
								boardArray[i][4]);
					} // ��ü �Խñ��� ����մϴ�.
				}

				autoMenu = false; // autoMenu�� false�� ������ �޴� ������ ���������ϴ�.
				break; // switch �� ���������ϴ�.
			case 2: // ����� �����ϴ� �κ��Դϴ�.
				System.out.println("2.����> ");

				System.out.print("���� : ");
				title = scan.nextLine();
				System.out.print("���� : ");
				content = scan.nextLine();
				System.out.print("�۾��� : ");
				writer = scan.nextLine();
				// ����, ����, �۾��̸� String���� �Է¹޽��ϴ�.

				String[] newBoard = {
						String.valueOf(listNum), // null�� �ִٸ� StringŸ������ �ٲ� �Խñ� ��ȣ�� �����մϴ�.
						title,
						content,
						writer, // ����, ����, �۾��̸� �����ϰ�
						String.valueOf(0) // ��ȸ���� 0���� ���������� String Ÿ������ �ٲ� �ʱ�ȭ�մϴ�.
				};

				for(int i =0;i<boardArray.length;i++) {
					if(boardArray[i][0] == null) {  // ������ �ڸ����� null �� �ֽ��ϴ�. �׷��� null �� �ִ� �ڸ��� ã��
						boardArray[i] = newBoard;  // ���Ӱ� ���� ������ �����մϴ�.
						listNum++; // �Խñ� ��ȣ�� �������� 1�� ������ ���¿��� �Խñ� ��ȣ�� �����ϰ� �Էµ��� �ʾƿ�.
						break;
					}
				}

				autoMenu = true; // autoMenu�� true�� �ٲ���� ������ case 1�� �Ѿ�� ��ü ����� ������ �� ����մϴ�.
				break;
			case 3:	// �Խñ��� �о���ڽ��ϴ�.
				System.out.println("3.�б�> ");
				System.out.print("�۹�ȣ�� �Է��ϼ��� : ");
				int readNum = Integer.parseInt(scan.nextLine());
				// �Է¹��� String Ÿ�� ��ȣ�� Int�� ��ȯ�� readNum�� �ֽ��ϴ�.
				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){
						continue;
					} // ���� ���������� null�� �ִ� ���� ������ �̹� �Ǿ� �ִٴ� ���̴� �н��ϰ� 
					if (readNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("����: " + boardArray[i][1]);
						System.out.println("����: " + boardArray[i][2]);
						System.out.println("�۾���: " + boardArray[i][3]);
						boardArray[i][4] = String.valueOf(Integer.parseInt(boardArray[i][4])+1);
						System.out.println("��ȸ��: " + boardArray[i][4]);
						check = true;
						break;
					} // �Է¹��� �Խñ� ��ȣ�� ���� �Խñ� ��ȣ�� ���ؼ� ��ġ�ϴ� ������ �Խñ� ������ ����մϴ�. 
					// �Խñ��� �ٲ� ��� check �� true�� �ٲ���� ������ �Ǵٸ� ����� ������
				}
				// �Է¹��� �Խñ��� ���� ��� check �� ������ false �����̹Ƿ�
				// �Ʒ��� ���� "���� �Խñ��� ����"�� ������ ��µ˴ϴ�.

				if(check == false) {
					System.out.println("���� �Խñ��� �����ϴ�.");
				}else {
					check = false; 
				}

				autoMenu = false; // autoMenu�� false�̹Ƿ� �ٽ� �޴��� ������ �� �ִ� �ɼ��� ����մϴ�.
				break;
			case 4: // �Խñ��� �����ϰڽ��ϴ�.
				System.out.println("4.����>");
				System.out.println("�۹�ȣ�� �Է��ϼ��� : ");
				int updateNum = Integer.parseInt(scan.nextLine());
				// ���������� ���ڸ� String���� �о� Int�� ��ȯ�� ����ְ�
				String updateTitle; // ������ �����
				String updateContent; // ������ ������ �Է¹��� ������ �������ݴϴ�.
				
				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null){
						continue;
					} // ���������� �Խñ۹�ȣ�� null�̸� �н��ϰ�
					if (updateNum == Integer.parseInt(boardArray[i][0])) {
						System.out.println("���� ����: " + boardArray[i][1]); // ���������� ���� ����� ��
						System.out.print("������ ����: "); 
						updateTitle = scan.nextLine(); // ������ ������ �Է¹޽��ϴ�.
						System.out.println("���� ����: " + boardArray[i][2]); // �������뵵 ���� ����ϰ�
						System.out.print("������ ����: "); 
						updateContent = scan.nextLine(); // ������ ������ �Է¹޽��ϴ�.
						
						if(updateTitle.length() != 0) { // ������ ������ �Է¹��� ������ ���̸� �����ؼ� �� ������ �ƴ϶��
							boardArray[i][1] = updateTitle; // �Խñ��� ������Ʈ �մϴ�.
						}
						if(updateContent.length() != 0) { // ���뵵 ���������� �����ϰ�
							boardArray[i][2] = updateContent;
							System.out.println("�����Ǿ����ϴ�."); // �����Ǿ��ٴ� ����� �������ϴ�.
						}
						
						check = true; // ������ �Ǿ��ٸ� check�� true�� ���� �Խñ��� ��ȿ�ϴٰ� üũ�մϴ�.
						break;
					}
				}

				if(check == false) { // �Խñ� ��ȣ�� ��ȿ�� ��쿡�� ���� ������Ʈ�� ����ǹǷ� check�� true�̰�, 
						// ���� �� ������ ��µ��� �ʽ��ϴ�.
					System.out.println("������ �Խñ��� �����ϴ�.");
				}else {
					check = false;
				}

				autoMenu = true; //autoMenu �� true�� �Է��� case 1�� �Ѿ ��ü �Խñ��� ������ �� ����մϴ�.
				break;
			case 5:
				System.out.println("5.����>");
				System.out.println("�۹�ȣ�� �Է��ϼ��� : ");
				int deleteNum = Integer.parseInt(scan.nextLine());	// ���������� ���������� �Խñ� ��ȣ�� �Է¹޽��ϴ�.

				for (int i = 0; i < boardArray.length; i++) {
					if(boardArray[i][0] == null) {
						continue; // null �̸� �н��ϰ� 
					}
					if (deleteNum == Integer.parseInt(boardArray[i][0])) {
						for(int j=0; j<boardArray[i].length; j++) {
							boardArray[i][j] = null; // �ش�Ǵ� �Խñ� ��ȣ�� �Խñ���ü�� null�� �ٲ��ݴϴ�.
						}
						System.out.println("�����Ǿ����ϴ�.");
						check = true; // �����Ǹ� ��ȿ���� true�� check �ϰ�
						break;
					}
				}

				if(check == false) {
					System.out.println("������ �Խñ��� �����ϴ�.");
				}else {
					check = false;
				}
				
				autoMenu = true; // ���������� ��ü ��� ������ �� ����մϴ�.
				break;
			case 6:
				System.out.println("���α׷��� ����");
				run = false; // 6�� ������ run�� false �� �ٲ� ���α׷��� �����մϴ�.
				break;
			}

		}
	}

}
