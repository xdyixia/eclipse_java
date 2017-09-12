package com.array;
//According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

//Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

 // Any live cell with fewer than two live neighbors dies, as if caused by under-population.任何细胞少于2个（<2）邻居时 死亡
 // Any live cell with two or three live neighbors lives on to the next generation.任何细胞有两个或三个（x=2or3）邻居时 活到下一代
 // Any live cell with more than three live neighbors dies, as if by over-population..任何细胞多于三个（>3）邻居时 死亡
 // Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.任何死细胞恰好有三个活邻居时 变为活细胞
 // Write a function to compute the next state (after one update) of the board given its current state.

//Follow up: 
//Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
//In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

//判断条件是活邻居的个数，所以分为两部分，1：得到活邻居的数量lives 2：进行判断更新
//

import java.util.Scanner;

public class gameOfLife {

 public void gameOfLife(int[][] board) {
     
     if(board == null || board.length == 0) {
         
         return;
         
     }
     
     int m = board.length;
     int n = board[0].length;
     
     for(int i = 0; i < m; i++) {
         
         for(int j = 0; j < n; j++) {
             
             int lives = liveNeighbors(board, m, n, i, j);
             
             if(board[i][j] ==  1 && lives >= 2 && lives <= 3) {
                 
                 board[i][j] = 3;//这里让cell等于3，为了不影响下个cell的活邻居数量的判断，且方便最后统一 右移 更新。
                 
             }
             
             if(board[i][j] == 0 && lives == 3) {
                 
                 board[i][j] = 2;//同理，右移一位 得 1（活），如果直接更新为1（活）则会影响下面的cell的判断
                 
             }
             //出去上面这两种情况下一轮活着，其他都会死，所以让他们依然保持0or1，统一更新时右移一位即可
         }
         
     }
		
     //这个嵌套循环是对整个二维数组进行统一更新，cell为2或3则右移1位得1（活着），0或1则右移1位得0（死亡）
     for(int i = 0; i < m; i++) {
         
         for(int j = 0; j < n; j++) {
             
             board[i][j] >>= 1;
             
         }
         
     }
     
 }
 
	//一个细胞的 活 邻居的个数
 private int liveNeighbors(int[][] board, int m, int n, int i, int j) {
     
     int lives = 0;
     
     //0,m-1为了防止数组行变量x越界，即共有  0~m-1 行
     //0，n-1为了防止数组列变量y越界，即共有  0~n-1 列
     for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
         
         for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
             
             lives += board[x][y] & 1;//与 1 按位“与”运算，偶数得“0”，奇数得“1”，此处cell为奇数（3或1）即活着，故加1
             
         }
         
     }
     //上面循环计算活邻居加上了cell自己，所以再减去
     lives -= board[i][j] & 1;
     
     return lives;
     
 }

 public static void main (String[] args)
 {
 	System.out.println("输入矩阵行数：");
 	Scanner in = new Scanner(System.in);
 	int m=in.nextInt();
 	
 	System.out.println("输入矩阵列数：");
 	int n=in.nextInt();
 	
 	int[][] board = new int[m][n];
 	System.out.println("输入矩阵各元素：");
 	for(int i = 0 ; i < m ; i++){
 		for(int j = 0 ; j < n ; j++){
 			board[i][j] = in.nextInt();
 		}   		
 	}
 	
// 	int[][] board = {{1,1,1},{1,1,1}};
 	gameOfLife cs = new gameOfLife();
 	cs.gameOfLife(board);
 	
 	for(int i = 0 ; i < m ; i++){
 		for(int j = 0 ; j < n ; j++){
 			System.out.println(board[i][j]);
 		}
 		
 	}
 	
 }
}