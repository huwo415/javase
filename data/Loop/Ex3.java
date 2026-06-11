class Ex3
{
	public static void main(String[] args) {
		

		/*for(int x=1;x<=9;x++)
		{
			for(int y=1;y<=9;y++)
			{
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}
		*/

        
		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.println("請輸入列數");
        int n=sc.nextInt();

		System.out.println("請輸入行數");
		int m=sc.nextInt();

		a:
		for(int x=1;x<=n;x++)//列數
		{
			//if(x==7) break;
			
			b:
			for(int y=1;y<=m;y++)//行數
			{
				if(y==8) break;
				if(x==7) break a;
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println("結束");

			System.out.println();
		}

		


		/*
		for(int x=1;x<=n;x++)//列數
		{
			for(int y=1;y<=m;y++)//行數
			{
				if(y==8) break;
				if(x==7) break;
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}*/

       

        /*
		for(int x=1;x<=n;x++)//列數
		{
			for(int y=1;y<=m;y++)//行數
			{
				System.out.print(x+"*"+y+"="+(x*y)+"\t");
			}
			System.out.println();
		}*/

        


		/*
		int x1=1;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x1+"*"+y+"="+(x1*y)+"\t");
		}
		System.out.println();

		int x2=2;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x2+"*"+y+"="+(x2*y)+"\t");
		}
		System.out.println();

		int x3=3;
		for(int y=1;y<=9;y++)
		{
			System.out.print(x3+"*"+y+"="+(x3*y)+"\t");
		}
		System.out.println();
		*/
	}
}