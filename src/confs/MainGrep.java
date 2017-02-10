package confs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainGrep {

	public static void main(String[] args) throws IOException {
		String[] fi = { "run_a1.txt", "run_a2.txt", "run_b1.txt", "run_b2.txt", "run_c1.txt", "run_c2.txt",
				"run_d1.txt", "run_d2.txt", "run_f1.txt", "run_f2.txt" };
		for (int i = 7; i <= 16; i++) {
			String baseDir = "final_exp_results/exp"+i+"Results/";
			int m = 1;
			double sum = 0;
			for (String f : fi) {
				BufferedReader br = new BufferedReader(new FileReader(baseDir+f));
				try {
					String line = br.readLine();

					if (line != null) {
						int x = line.lastIndexOf(',');
						x += 2;
						String s = line.substring(x);
						double d = Double.parseDouble(s);
						
						sum += d;
						if (m == 2) {
							m = 0;							
							System.out.print(sum/2 +",");
						}
						m++;
					}
				} finally {
					br.close();
				}
			}
			System.out.println(i);
			
		}
	}
}
