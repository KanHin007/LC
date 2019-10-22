package firstday;

import structure.ListNode;

/**
 * @author Lawrence Han
 * @date 2019.10.22
 * <p>
 * 2.两个数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbersSolution {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultListNode = new ListNode(0);
        ListNode indexListNode = resultListNode;

        int incr = 0;
        // 首先判断两个链表的节点是不是null
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            int l2Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            if (l2 != null) {
                l2Val = l2.val;
            }

            // 存储的临时数据 计算加上进位的数据
            int tempValue = l1Val + l2Val + incr;
            // 算出进位的数据
            incr = tempValue / 10;
            // 计算出余数 并调用构造函数
            indexListNode.next = new ListNode(tempValue % 10);
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            indexListNode = indexListNode.next;
        }

        //如果有进位 则新增节点
        // 这里在编写是漏掉了逻辑 需要注意
        if (incr != 0) {
            indexListNode.next = new ListNode(incr);
        }


        return resultListNode.next;
    }

    public static void main(String[] args) {

        // 构造l1
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 构造l2
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode resultListNode = addTwoNumbers(l1, l2);

        System.out.println(resultListNode.val + " -> " + resultListNode.next.val + " -> " + resultListNode.next.next.val);


        // 构造l1
        ListNode l3 = new ListNode(5);


        // 构造l2
        ListNode l4 = new ListNode(5);


        ListNode resultListNode1 = addTwoNumbers(l3, l4);

        System.out.println(resultListNode1.val + " -> " + resultListNode1.next.val);

    }


}
