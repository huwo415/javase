
class Ex4
{
	public static void main(String[] args) {
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入次數");
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			//if(i==121) break;
			if(i==121) continue;
			if(i>=31 && i<=50) continue;
			if(i>=76 && i<=90) continue;
			if(i==131) break;
		
			if(i>30 && i<90)continue;
            


			System.out.println("i="+i+"\thello java");
		}
	}
}