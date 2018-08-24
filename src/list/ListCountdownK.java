package list;

/**
 * @Description:
 * @Auther: HXM
 * @Date: 2018/8/8 10:21
 */
public class ListCountdownK {

    public Node removeLastKthNode(Node head, int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        Node cur = head;
        while(cur != null){
            lastKth --;
            cur = cur.next;
        }
        if(lastKth == 0){
            head = head.next;
        } else if(lastKth < 0){
            cur = head;
            while(++lastKth!=0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

}
