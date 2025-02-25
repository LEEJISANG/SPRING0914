package ex03_array_quiz;

public class Quiz10 {

	public static void main(String[] args) {
		
		// 문제. 전체 구구단의 결과만
		// 2차원 배열 a에 저장하고, 출력하시오.
		// 실행 예)
		// 2  3  4  ... 9
		// 4  6  8  ... 18
		// ...
		// 18 27 36 ... 81
		
		int[][] a = new int[9][8];
		
		for (int i = 0; i < a.length; i++) {
			// i를 num으로 변환 : (i + 1)
			for (int j = 0; j < a[i].length; j++) {
				// j를 dan으로 변환 : (j + 2)
				a[i][j] = (j + 2) * (i + 1);
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		
	}

}