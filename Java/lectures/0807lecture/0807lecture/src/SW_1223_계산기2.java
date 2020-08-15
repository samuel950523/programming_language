import java.util.Scanner;
import java.util.Stack;

// 후위 표현 문자열 작성
// 3+4+5+6+7 의 후위 표현식은 34+5+6+7+ 이며 앞 (3) 부터 꺼내서 처리하는 방식이다.
// 예) 3+4+5+6+7 >> 34+5+6+7+    3+4+5*6+7 >> 34+56*7++
// 만약 연산자가 한개만 사용되면, 처음 2개의 숫자를 연속하고, 그 뒤로는 숫자 하나 + 연자 하나 순으로 만들어진다. 
// 숫자 나오면 후위 문자열에 추가하고 연산자 나오면 stack 에 push 했다가 다른 연산자 나오면 기존 연산자 꺼내서 후위문자열에 추가 방식임
// 이 경우는 연산자의 우선순위가 존재. 우선순위가 있는 연산자를 기존 연산자를 꺼내지 않고 stack에 넣어서 기존 연산자보다 먼저 꺼내지게 함. 
// 연산자 stack은 stack 이 비어있으면 
//		넣고, 
// stack 비어있지 않으면
//		stack 의 마지막 연산자와 현재 연산자를 비교해서 현재 연산자가 우선 순위가 높으면,
//			기존 stack에 연산자가 있어도 stack 에 넣는다
//		높지 않으면
//			기존 연산자를 꺼내고 현재 연산자를 stack 에 넣는다. (우선순위 가지도록 - 먼저 꺼내지도록)

// 후위 연산자 문자열 연산
//     앞에서부터 숫자이면 stack 에 넣고 연산자가 나오면 stack 에서 2개를 꺼내서 연산 후에 다시 stack 에 넣는 작업을 반복한다.
/*

// 덧셈 only
1
3+4+5+6+7
34+5+6+7+

#25

// 덧셈 + 곱셈
1
3+4+5*6+7
34+56*7++

44
*/
public class SW_1223_계산기2 {


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int t = 1; t <= 10; t++) {
			
			int N = sc.nextInt();
			
			String s = sc.next();
			Stack<Character> oper = new Stack<>();
			
			StringBuilder reverse = new StringBuilder();
			
			for(int i = 0; i < N; i++) {
				
				char c = s.charAt(i);
				
				if( c >= '0' && c <= '9') {
					reverse.append(String.valueOf(c));
				}else {
					if(oper.isEmpty()) {
						oper.push(c);
					}else {
						if( oper.peek() == '+' && c == '*' ) { // +/* // 스택에서 나오려는 연산자보다 더 우위에 있는 연산자이면 스택에 넣는다. (먼저 처리되도록)
							oper.push(c);
						}else { // */+ , */*, +/+ // 동일 순위 연산자이거나 하위 연산자인 경우는 스택에서 나오려는 연산자를 꺼내서 후위문자열에 추가하고 해당 연산자를 스택에 넣는다.
							reverse.append(String.valueOf(oper.pop()));
							oper.push(c);
						}
					}
				}
			}
			
			// 스택에 남은 연산자를 모두 후위문자열에 추가
			while(!oper.isEmpty()) {
				reverse.append(String.valueOf(oper.pop()));
			}
			
			//System.out.println(reverse);
			
			// 스택을 이용해서 숫자는 스택에 넣고 연산자이면 스택에서 2개를 꺼내서 해당 연산자와 연산을 수행한 후 다시 스택에 넣는다. 이 과정을 반복
			// 마지막 스택에 남은 결과가 최종 연산 결과
			Stack<Integer> nums = new Stack<>();
			for(int i = 0; i < N; i++) {
				char c = reverse.charAt(i);
				if( c >= '0' && c <= '9') {
					nums.push(c - '0');
				}else {
					int tmp1 = nums.pop();
					int tmp2 = nums.pop();
					if(c == '*') nums.push(tmp1 * tmp2);
					else if(c == '+') nums.push(tmp1 + tmp2);
				}
			}
			System.out.println("#" + t + " " + nums.pop());
		}
		sc.close();
	}
}
 