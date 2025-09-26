public class Main
{
	public static void main(String[] args) {
	    String s="abcd";
	    int n =s.length();
	    for(int i=0;i<n;i++)
	    {
	        System.out.println("prefix: "+s.charAt(i)+"suffix");
	        for(int j=i+1,m=i-1;j<n||m>=0;j++,m--)
	        {
	            if(m>=0&&m<i){
	                System.out.println(s.charAt(m));
	            }
	            else{
	                System.out.println("empty");
	                
	            }
	            if(j>i&&j<n)
	            {
	            System.out.println("            "+s.charAt(j));
	            }
	        }
	    }
	}
		
}