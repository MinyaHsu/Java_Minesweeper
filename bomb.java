import java.util.Scanner;
public class bomb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[9][9];
		String[][] hide = new String[9][9];
		int x,y,xb,yb;
		String l,m;
		int k = 0;//���u�ƶq
		int finish = 0;
		int end = 0;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				map[i][j]="   ";
			}
		}
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				hide[i][j]="   ";
			}
		}
		
		//�W�h����
		System.out.println("�w��Ө�i��a�p�j�C��");
		System.out.println("1.����J����@��}��");
		System.out.println("2.��l�W���Ʀr�N��A�H�L�����ߪ��E�c�椺���h�֦a�p");
		System.out.println("3.���a�p�N����");
		System.out.println("4.��X�Ҧ��S���a�p����l");
		System.out.println("��:�a�p  �i�i�i:�P��S���u");
		printmap(map);
		System.out.println("�i�C���}�l�j");
		System.out.println("�п�ܶ}����m");
		while(true) {
			System.out.print("X��:");
			x = sc.nextInt();
			if(x>=0 && x<=8) {
				break;
			}else {
				System.out.println("�п�J0~8��������");
			}
		}
		while(true) {
			System.out.print("Y��:");
			y = sc.nextInt();
			if(y>=0 && y<=8) {
				break;
			}else {
				System.out.println("�п�J0~8��������");
			}
		}
		
		//�a�p�]�w
		for(int i=1;i<=10;i++) {
			xb = (int)(Math.random()*9);
			yb = (int)(Math.random()*9);
			if(xb!=x && yb!=y && hide[yb][xb]=="   " && xb!=x-1 && xb!=x+1 && yb!=y-1 && yb!=y+1) {
				hide[yb][xb]=" �� ";
			}else {
				i--;
			}
		}
	
		//�Ʀr�ͦ��A�P�򦳦h�֬��u
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(hide[i][j]=="   ") {
					for(int a=-1;a<=1;a++) {//�W�U
						for(int b=-1;b<=1;b++) {//���k
							if(i+a>=0 && i+a<=8 && j+b>=0 && j+b<=8) {
								if(hide[i+a][j+b]==" �� ") {
									k++;
								}
							}	
						}
					}
					if(k!=0) {
						l =String.valueOf(k);
						m=" "+l+" ";
						hide[i][j]=m;
						k=0;
					}
				}
			}
		}
		
		//�}��
		for(int a=0;a>=-8;a--) {//���W
			if(y+a>=0 && y+a<=8) {
				if(hide[y+a][x]=="   ") {//�Ů�
					map[y+a][x]="�i�i�i";
					for(int b=-1;b>=-8;b--){//��
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}
					for(int b=1;b<=8;b++) {//�k
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
				}else if(hide[y+a][x]!="   " && hide[y+a][x]!=" �� "){//���Ʀr
					map[y+a][x]=hide[y+a][x];
					for(int b=-1;b>=-8;b--){//��
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
					for(int b=1;b<=8;b++) {//�k
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}break;
				}
			}
		}
		for(int a=0;a<=8;a++) {//���U
			if(y+a>=0 && y+a<=8) {
				if(hide[y+a][x]=="   ") {//�Ů�
					map[y+a][x]="�i�i�i";
					for(int b=-1;b>=-8;b--){//��
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}
					for(int b=1;b<=8;b++) {//�k
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
				}else if(hide[y+a][x]!="   " && hide[y+a][x]!=" �� "){//���Ʀr
					map[y+a][x]=hide[y+a][x];
					for(int b=-1;b>=-8;b--){//��
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
					for(int b=1;b<=8;b++) {//�k
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="�i�i�i";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" �� "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}break;
				}
			}
		}
		printmap(map);
		//�}����
		while(true) {
			System.out.println("�i��J��ܦ�m�j");
			while(true) {
				while(true) {
					System.out.print("X��:");
					x = sc.nextInt();
					if(x>=0 && x<=8) {
						break;
					}else {
						System.out.println("�п�J0~8��������");
					}
				}
				while(true) {
					System.out.print("Y��:");
					y = sc.nextInt();
					if(y>=0 && y<=8) {
						break;
					}else {
						System.out.println("�п�J0~8��������");
					}
				}
				if(map[y][x]!="   ") {
					System.out.println("�i���i�惡��j");
				}else {
					break;
				}
			}
			
			//���l
			if(hide[y][x]=="   ") {//�Ů�
				map[y][x]="�i�i�i";
				printmap(map);
			}else if(hide[y][x]==" �� ") {//���u
				for(int i=0;i<=8;i++) {
					for(int j=0;j<=8;j++) {
						if(hide[i][j]==" �� ") {
							map[i][j]=hide[i][j];
						}
					}
				}
				printmap(map);
				System.out.println("�i�C�����ѡj");
				break;
			}else {//�Ʀr
				map[y][x]=hide[y][x];
				printmap(map);
			}
			
			//�ӧQ�P�w
			for(int i=0;i<=8;i++) {
				for(int j=0;j<=8;j++) {
					if(hide[i][j]!=" �� ") {
						if(hide[i][j]=="   " && map[i][j]=="�i�i�i") {
							finish++;
						}else if(hide[i][j]!="   " && hide[i][j]==map[i][j]){
							finish++;
						}
						if(finish==71) {
							System.out.println("�i�C���ӧQ�j");
							end=1;
						}
					}
				}
			}
			finish=0;
			if(end==1) {
				break;
			}
		}
	}
	public static void printmap(String map[][]) {
		System.out.println("   �z�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�s�w�w�w�{");
		System.out.println("  0�x"+map[0][0]+"�x"+map[0][1]+"�x"+map[0][2]+"�x"+map[0][3]+"�x"+map[0][4]+"�x"+map[0][5]+"�x"+map[0][6]+"�x"+map[0][7]+"�x"+map[0][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  1�x"+map[1][0]+"�x"+map[1][1]+"�x"+map[1][2]+"�x"+map[1][3]+"�x"+map[1][4]+"�x"+map[1][5]+"�x"+map[1][6]+"�x"+map[1][7]+"�x"+map[1][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  2�x"+map[2][0]+"�x"+map[2][1]+"�x"+map[2][2]+"�x"+map[2][3]+"�x"+map[2][4]+"�x"+map[2][5]+"�x"+map[2][6]+"�x"+map[2][7]+"�x"+map[2][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  3�x"+map[3][0]+"�x"+map[3][1]+"�x"+map[3][2]+"�x"+map[3][3]+"�x"+map[3][4]+"�x"+map[3][5]+"�x"+map[3][6]+"�x"+map[3][7]+"�x"+map[3][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  4�x"+map[4][0]+"�x"+map[4][1]+"�x"+map[4][2]+"�x"+map[4][3]+"�x"+map[4][4]+"�x"+map[4][5]+"�x"+map[4][6]+"�x"+map[4][7]+"�x"+map[4][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  5�x"+map[5][0]+"�x"+map[5][1]+"�x"+map[5][2]+"�x"+map[5][3]+"�x"+map[5][4]+"�x"+map[5][5]+"�x"+map[5][6]+"�x"+map[5][7]+"�x"+map[5][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  6�x"+map[6][0]+"�x"+map[6][1]+"�x"+map[6][2]+"�x"+map[6][3]+"�x"+map[6][4]+"�x"+map[6][5]+"�x"+map[6][6]+"�x"+map[6][7]+"�x"+map[6][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  7�x"+map[7][0]+"�x"+map[7][1]+"�x"+map[7][2]+"�x"+map[7][3]+"�x"+map[7][4]+"�x"+map[7][5]+"�x"+map[7][6]+"�x"+map[7][7]+"�x"+map[7][8]+"�x");
		System.out.println("   �u�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�q�w�w�w�t");
		System.out.println("  8�x"+map[8][0]+"�x"+map[8][1]+"�x"+map[8][2]+"�x"+map[8][3]+"�x"+map[8][4]+"�x"+map[8][5]+"�x"+map[8][6]+"�x"+map[8][7]+"�x"+map[8][8]+"�x");
		System.out.println("   �|�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�r�w�w�w�}");
		System.out.println("Y/X  0   1   2   3   4   5   6   7   8");
	}
}
