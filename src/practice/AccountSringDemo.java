package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AccountSringDemo {
      public static void main(String[] args) {
    	  String[] strs= {"chenhao","zhangsan","zhangsan",
    			  "chenhao","lisi","wangwu"};
    	 AccountUtil.printData(AccountUtil.account(strs));
      }
}

class AccountUtil{
	public static Map<String,Integer> account(String[] strs){
		Map<String,Integer> data=new HashMap<String,Integer>();
			for(int i=0;i<strs.length;i++) {
				String str=strs[i];
				if(data.get(str)==null) {
					data.put(str, 1);
				}else {
					data.put(str,data.get(str)+1);
				}
			}
			return data;
		
	}
	public static void printData(Map<String,Integer> data) {
		Set<Entry<String,Integer>> entrys=data.entrySet();
		for(Entry<String,Integer> entry:entrys) {
			System.out.println(entry.getKey()+"出现的次数为"+entry.getValue());
		}
	}
}

