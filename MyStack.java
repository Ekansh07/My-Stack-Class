
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyStack<AnyType> {
	/**
	 * Construct an empty ArrayList.
	 */
	ArrayList<AnyType> list = new ArrayList<AnyType>();

	/**
	 * Returns the number of items in this collection.
	 * 
	 * @return the number of items in this collection.
	 */
	public int getSize() {
		return list.size();
	}
	/**
	 * pushing elements in the stack
	 **/
	public void push(AnyType element) {
		list.add(element);
	}
	
	/**
	 * Popping out the elements from the stack
	 **/
	public AnyType pop() {
		return list.remove(list.size() - 1);
	}

	public AnyType top() {
		int size = list.size();
		if (size == 0)
			return null;
		else
			return list.get(size - 1);
	}
		public String toString() {
		StringBuilder sb = new StringBuilder("[ ");

		for (AnyType x : list)
			sb.append(x + " ");
		sb.append("]");

		return new String(sb);
	}
		
		public static void main(String[] args) {
			MyStack<Character> stk = new MyStack<>();
			String s = "[{()}]";
			boolean flag = true;
			for (char ch : s.toCharArray()) {
				if (ch == '[' || ch == '{' || ch == '(') {
					stk.push(ch);
					
				} else if (ch == ']') {
					if (stk.getSize() == 0) {
						flag = false;
						System.out.println("Unalanced. Since the element are not in the stacks but still paranthesis are present in the input.");
						break;
					}
					if (stk.pop() != '[') {
						System.out.println("Unbalanced. Since the closing bracket ']' doesn't match with the opening bracket '[");
						break;
					}
				} else if (ch == '}') {
					if (stk.getSize() == 0) {
						flag = false;
						System.out.println("Unalanced. Since the element are not in the stacks but still paranthesis are present in the input.");
						break;
					}
					if (stk.pop() != '{') {
						System.out.println("Unbalanced. Since the closing bracket '}' doesn't match with the opening bracket '{");
						break;
					}
				} else if (ch == ')') {
					if (stk.getSize() == 0) {
						flag = false;
						System.out.println("Unalanced. Since the element are not in the stacks but still paranthesis are present in the input.");
						break;
					}
					if (stk.pop() != '(') {
						System.out.println("Unbalanced. Since the closing bracket ')' doesn't match with the opening bracket '(");
						break;
					}
				} else {
					throw new NoSuchElementException(ch + " character is invalid."); // invalid
				}
			}
			if (stk.getSize() == 0 && flag) {
				System.out.println("Balanced");
			}
			System.out.println("MyStack: " + stk);
		}
}