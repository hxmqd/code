package tree;

import java.util.Stack;

/**
 * @Description:
 * @Auther: HXM
 * @Date: 2018/8/8 14:39
 */
class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }
}
public class unRecurTreeTravel {

    public void preOrderUnRecurTree(Node head){
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print(head.value+" ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
            System.out.println();
        }
    }

    public void inOrderUnRecur(Node head){
        System.out.print("in-order:");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + "");
                    head = head.right;
                }
            }
        }
    }
}
