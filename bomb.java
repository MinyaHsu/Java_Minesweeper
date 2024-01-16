import java.util.Scanner;
public class bomb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[][] map = new String[9][9];
		String[][] hide = new String[9][9];
		int x,y,xb,yb;
		String l,m;
		int k = 0;//炸彈數量
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
		
		//規則說明
		System.out.println("歡迎來到【踩地雷】遊戲");
		System.out.println("1.先輸入任何一格開局");
		System.out.println("2.格子上的數字代表，以他為中心的九宮格內有多少地雷");
		System.out.println("3.踩到地雷就失敗");
		System.out.println("4.找出所有沒有地雷的格子");
		System.out.println("●:地雷  ███:周圍沒炸彈");
		printmap(map);
		System.out.println("【遊戲開始】");
		System.out.println("請選擇開局位置");
		while(true) {
			System.out.print("X值:");
			x = sc.nextInt();
			if(x>=0 && x<=8) {
				break;
			}else {
				System.out.println("請輸入0~8之間的數");
			}
		}
		while(true) {
			System.out.print("Y值:");
			y = sc.nextInt();
			if(y>=0 && y<=8) {
				break;
			}else {
				System.out.println("請輸入0~8之間的數");
			}
		}
		
		//地雷設定
		for(int i=1;i<=10;i++) {
			xb = (int)(Math.random()*9);
			yb = (int)(Math.random()*9);
			if(xb!=x && yb!=y && hide[yb][xb]=="   " && xb!=x-1 && xb!=x+1 && yb!=y-1 && yb!=y+1) {
				hide[yb][xb]=" ● ";
			}else {
				i--;
			}
		}
	
		//數字生成，周圍有多少炸彈
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(hide[i][j]=="   ") {
					for(int a=-1;a<=1;a++) {//上下
						for(int b=-1;b<=1;b++) {//左右
							if(i+a>=0 && i+a<=8 && j+b>=0 && j+b<=8) {
								if(hide[i+a][j+b]==" ● ") {
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
		
		//開局
		for(int a=0;a>=-8;a--) {//往上
			if(y+a>=0 && y+a<=8) {
				if(hide[y+a][x]=="   ") {//空格
					map[y+a][x]="███";
					for(int b=-1;b>=-8;b--){//左
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}
					for(int b=1;b<=8;b++) {//右
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
				}else if(hide[y+a][x]!="   " && hide[y+a][x]!=" ● "){//有數字
					map[y+a][x]=hide[y+a][x];
					for(int b=-1;b>=-8;b--){//左
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
					for(int b=1;b<=8;b++) {//右
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}break;
				}
			}
		}
		for(int a=0;a<=8;a++) {//往下
			if(y+a>=0 && y+a<=8) {
				if(hide[y+a][x]=="   ") {//空格
					map[y+a][x]="███";
					for(int b=-1;b>=-8;b--){//左
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}
					for(int b=1;b<=8;b++) {//右
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
				}else if(hide[y+a][x]!="   " && hide[y+a][x]!=" ● "){//有數字
					map[y+a][x]=hide[y+a][x];
					for(int b=-1;b>=-8;b--){//左
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==0) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}
						}
					}
					for(int b=1;b<=8;b++) {//右
						if(x+b>=0 && x+b<=8) {
							if(hide[y+a][x+b]=="   ") {
								map[y+a][x+b]="███";
								if(x+b==8) {
									break;
								}
							}else if(hide[y+a][x+b]!="   " && hide[y+a][x+b]!=" ● "){
								map[y+a][x+b]=hide[y+a][x+b];
								break;
							}	
						}
					}break;
				}
			}
		}
		printmap(map);
		//開局後
		while(true) {
			System.out.println("【輸入選擇位置】");
			while(true) {
				while(true) {
					System.out.print("X值:");
					x = sc.nextInt();
					if(x>=0 && x<=8) {
						break;
					}else {
						System.out.println("請輸入0~8之間的數");
					}
				}
				while(true) {
					System.out.print("Y值:");
					y = sc.nextInt();
					if(y>=0 && y<=8) {
						break;
					}else {
						System.out.println("請輸入0~8之間的數");
					}
				}
				if(map[y][x]!="   ") {
					System.out.println("【不可選此格】");
				}else {
					break;
				}
			}
			
			//填格子
			if(hide[y][x]=="   ") {//空格
				map[y][x]="███";
				printmap(map);
			}else if(hide[y][x]==" ● ") {//炸彈
				for(int i=0;i<=8;i++) {
					for(int j=0;j<=8;j++) {
						if(hide[i][j]==" ● ") {
							map[i][j]=hide[i][j];
						}
					}
				}
				printmap(map);
				System.out.println("【遊戲失敗】");
				break;
			}else {//數字
				map[y][x]=hide[y][x];
				printmap(map);
			}
			
			//勝利判定
			for(int i=0;i<=8;i++) {
				for(int j=0;j<=8;j++) {
					if(hide[i][j]!=" ● ") {
						if(hide[i][j]=="   " && map[i][j]=="███") {
							finish++;
						}else if(hide[i][j]!="   " && hide[i][j]==map[i][j]){
							finish++;
						}
						if(finish==71) {
							System.out.println("【遊戲勝利】");
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
		System.out.println("   ┌───┬───┬───┬───┬───┬───┬───┬───┬───┐");
		System.out.println("  0│"+map[0][0]+"│"+map[0][1]+"│"+map[0][2]+"│"+map[0][3]+"│"+map[0][4]+"│"+map[0][5]+"│"+map[0][6]+"│"+map[0][7]+"│"+map[0][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  1│"+map[1][0]+"│"+map[1][1]+"│"+map[1][2]+"│"+map[1][3]+"│"+map[1][4]+"│"+map[1][5]+"│"+map[1][6]+"│"+map[1][7]+"│"+map[1][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  2│"+map[2][0]+"│"+map[2][1]+"│"+map[2][2]+"│"+map[2][3]+"│"+map[2][4]+"│"+map[2][5]+"│"+map[2][6]+"│"+map[2][7]+"│"+map[2][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  3│"+map[3][0]+"│"+map[3][1]+"│"+map[3][2]+"│"+map[3][3]+"│"+map[3][4]+"│"+map[3][5]+"│"+map[3][6]+"│"+map[3][7]+"│"+map[3][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  4│"+map[4][0]+"│"+map[4][1]+"│"+map[4][2]+"│"+map[4][3]+"│"+map[4][4]+"│"+map[4][5]+"│"+map[4][6]+"│"+map[4][7]+"│"+map[4][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  5│"+map[5][0]+"│"+map[5][1]+"│"+map[5][2]+"│"+map[5][3]+"│"+map[5][4]+"│"+map[5][5]+"│"+map[5][6]+"│"+map[5][7]+"│"+map[5][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  6│"+map[6][0]+"│"+map[6][1]+"│"+map[6][2]+"│"+map[6][3]+"│"+map[6][4]+"│"+map[6][5]+"│"+map[6][6]+"│"+map[6][7]+"│"+map[6][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  7│"+map[7][0]+"│"+map[7][1]+"│"+map[7][2]+"│"+map[7][3]+"│"+map[7][4]+"│"+map[7][5]+"│"+map[7][6]+"│"+map[7][7]+"│"+map[7][8]+"│");
		System.out.println("   ├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
		System.out.println("  8│"+map[8][0]+"│"+map[8][1]+"│"+map[8][2]+"│"+map[8][3]+"│"+map[8][4]+"│"+map[8][5]+"│"+map[8][6]+"│"+map[8][7]+"│"+map[8][8]+"│");
		System.out.println("   └───┴───┴───┴───┴───┴───┴───┴───┴───┘");
		System.out.println("Y/X  0   1   2   3   4   5   6   7   8");
	}
}
