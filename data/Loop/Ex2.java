class Ex2
{
	public static void main(String[] args) {
		/*
		int i=1;
		while(i<=5)
		{
			System.out.println("i="+i+"\thello java");
			i++;
		}
	    */
		
		int i=1;
		do
		{	if(i<=5)
			{
				System.out.println("i="+i+"\thello java");
				i++;
			}
			else
			{
				System.out.println("error,i="+i);
			}
			
		}while(i<=5);


	}
}