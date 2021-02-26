// java -jar target/example-1.0-SNAPSHOT.jar
package example;

import example.arithmetic.ArithmeticExpressions;
import example.binarytree.BTNode;

public class App {
    public static void main(String[] args) {
        BTNode<Double> tree = ArithmeticExpressions.createTree();
		// ( 5 * ( ( 9 + 4 ) - 1 ) ) / 6 = 10

		System.out.println("evaluateTree: " + ArithmeticExpressions.evaluateTree(tree));

		String postfixExpr = ArithmeticExpressions.treeToPostfix(tree);
		System.out.println("postfix: " + postfixExpr);

		System.out.println("evaluatePostfix: " + ArithmeticExpressions.evaluatePostfix(postfixExpr));
    }
}
