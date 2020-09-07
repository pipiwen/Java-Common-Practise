package sort;

/**
 * <Description> <br>
 *
 * @author shi.yuwen<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2020/09/01 10:53 <br>
 * @see sort <br>
 */
public class LinkedListPractise {
    static class  Node {
        Node pre;
        Node next;
        Integer value;
        Node (Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            if (null == this.value) {
                return "";
            }
            if (null == this.next) {
                return String.valueOf(this.value);
            }
            return this.value + " -> " + this.next.toString();
        }
    }
    public static Node getMid(Node start, Node end) {
        Integer temp = start.value;
        while (start != end) {
            while (start != end && end.value > temp) {
                end = end.pre;
            }
            start.value = end.value;
            while (start != end && start.value < temp) {
                start = start.next;
            }
            end.value = start.value;
            start.value = temp;
        }
        return start;
    }
    public static void quickSort(Node start, Node end) {
        if (null == start || null == end || start == end) {
            return;
        }
        Node mid = getMid(start, end);
        quickSort(start, mid);
        quickSort(mid.next, end);

    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(-45);
        Node n3 = new Node(9);
        Node n4 = new Node(8);
        Node n5 = new Node(0);
        n1.next = n2;
        n2.pre = n1;
        n2.next = n3;
        n3.pre = n2;
        n3.next = n4;
        n4.pre = n3;
        n4.next = n5;
        n5.pre = n4;
        System.out.println("ori: " + n1);
        quickSort(n1, n5);
        System.out.println("des: " + n1);
    }
}
