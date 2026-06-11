class Ex1
{
	public static void main(String[] args) {
		
		for(int i=1;i<=5;++i)
		{
			System.out.println("i="+i+"\thello java");
		
		}
		
		for(int x=1,y=1;x<=50000 || y<=70000;)
		{
			System.out.println("x="+x+"\ty="+y);
			x=2*y+100;
			y=2*x-10;
		}
	}
}