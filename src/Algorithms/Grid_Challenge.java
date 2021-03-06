/* Name :- Kushal S Shinde
 * Email:- kshinde1@binghamton.edu
 * 
  
 
Given a squared sized grid G of size N in which each cell has a lowercase letter. Denote the character in the ith row and in the jth column as G[i][j].

You can perform one operation as many times as you like: Swap two column adjacent characters in the same row G[i][j] and G[i][j+1] for all valid i,j.

Is it possible to rearrange the grid such that the following condition is true?

G[i][1] <= G[i][2] <= ... <= G[i][N] for 1<=i<=N and 
G[1][j] <= G[2][j] <= ... <= G[N][j] for 1<=j<=N.

In other words, is it possible to rearrange the grid such that every row and every column is lexicographically sorted?

Note: c1<=c2, if letter c1 is equal to c2 or is before c2 in the alphabet.


Input Format

The first line begins with T, the number of testcases. In each testcase you will be given N. 
The following N lines contain N lowercase english alphabet each, describing the grid.

Constraints
1<=T<=100
1<=N<=100
Gij will be a lower case letter

Output Format

Print T lines. On the ith line print YES if it is possible to rearrange the grid in the ith testcase or NO otherwise.

Sample Input
========================
1
5
ebacd
fghij
olmkn
trpqs
xywuv

Sample Output
========================
YES

Explanation
========================
The grid in the first and only testcase can be reordered to

abcde
fghij
klmno
pqrst
uvwxy
This fulfills the condition since the rows 1, 2, ..., 5 and the columns 1, 2, ..., 5 are all lexicographically sorted.

*/

package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Grid_Challenge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int x=0; x<t; x++) {
			int n = sc.nextInt();
			char[][] matrix = new char[n][n];
			
			int m=0;
			for(int i=0; i<n; i++) {
				String input = sc.next();
				while(m!=n) {
					matrix[i][m] = input.toCharArray()[m];
					m++;
				}
				m=0;
			}
			
			System.out.println(validMatrix(matrix) ? "YES" : "NO");
		}
		sc.close();
    }
	
	public static boolean validMatrix(char[][] matrix) {
		if(matrix.length==0) 
			return true;
		
		for(char[] arr:matrix)
	        Arrays.sort(arr);

		for(int i=0;i<matrix.length;i++){
	        for(int j=0;j<matrix.length-1;j++){
	            if(matrix[j][i]>matrix[j+1][i]) 
	            	return false;
	        }
	    }
	    return true;
	}
}
