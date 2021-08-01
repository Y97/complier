package compiler;

public class IsReserve {//标识符
	
	public int isreserve(String s)
	{//判断是否为保留字,是，则返回种别码;不是，则返回0.
		String reserve[] = 
			{"int","long","short","float","double","char","main","if","return","for","while","int36"};
		for(int i = 0; i < reserve.length; i++)
		{
			if(s.equals(reserve[i]))
				return 1;
		}
		return -1;
	}
}
