import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int sum = Integer.MAX_VALUE;	
		String[] subtraction = br.readLine().split("-");
		
 
		for(int i = 0; i < subtraction.length; i++) {
			int temp = 0;
			String[] addition = subtraction[i].split("\\+");

			for(int j = 0; j < addition.length; j++) {
				temp += Integer.parseInt(addition[j]);
			}
			
			// 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
			if (sum == Integer.MAX_VALUE) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		System.out.println(sum);
	}
 
}