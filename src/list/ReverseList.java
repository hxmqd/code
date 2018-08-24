package list;

/**
 * @Description:
 * @Auther: HXM
 * @Date: 2018/8/8 10:41
 */
public class ReverseList {

    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
