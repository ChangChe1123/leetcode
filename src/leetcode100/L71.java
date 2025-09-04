package leetcode100;

import java.util.ArrayDeque;
import java.util.Deque;

public class L71 {
	public static void main(String[] args) {
		L71 s = new L71();
		String path = new String("/home/");
		String result = s.simplifyPath(path);
		System.out.print(result);
	}
	
	public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String str : parts){
            if(str.isEmpty() || str.equals(".")){
                continue;
            }else if(str.equals("..")){
                if (!stack.isEmpty()) {
					stack.pollLast();
				}
            }else{
                stack.offerLast(str);
            }
        }
        StringBuilder builder = new StringBuilder();
        for(String str : stack){
            builder.append("/").append(str);
        }
        return builder.length() == 0 ? "/" : builder.toString();
    }
}
