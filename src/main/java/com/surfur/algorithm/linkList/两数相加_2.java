package com.surfur.algorithm.linkList;

/**
 * 题目：给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 <p>逆序</p> 的方式存储的，并且每个节点只能存储 <p>一位</p> 数字。
 *      请你将两个数相加，并以相同形式返回一个表示和的链表。
 *      你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 *      输入：l1 = [2,4,3], l2 = [5,6,4]
 *          输出：[7,0,8]
 *      解释：342 + 465 = 807.
 *      示例 2：
 *      输入：l1 = [0], l2 = [0]
 *          输出：[0]
 *      示例 3：
 *      输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 *          输出：[8,9,9,9,0,0,0,1]
 */
public class 两数相加_2 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static void main(String[] args) {
        // [2,4,3], l2 = [5,6,4]
        // 输出：[7,0,8]
        // 解释：342 + 465 = 807.
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        // l1 = [0], l2 = [0]
        // ListNode l1 = new ListNode(0);
        // ListNode l2 = new ListNode(0);
        // l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(1008 % 10);
    }

    /**
     * 模拟加法：存在三个角色：虚拟头节点：dummy，移动节点：current，进位值：carry
     * 测试通过：运行时间 1ms
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Num = l1 != null ? l1.val : 0;
            int l2Num = l2 != null ? l2.val : 0;
            // 将两个值 和 进位值 相加
            int sum = l1Num + l2Num + carry;
            // 重新计算更新进位值
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            // 移动链表指针
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        // 处理最后的进位
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next;
    }



    /**
     * 测试不通过，有特殊值情况没考虑，我们用integer接收，有上限 2147483647 10位
     * 当节点为：9999999991 10位 > 2147483647，就报： java.lang.NumberFormatException: For input string: "9999999991"
     * 解决方案：使用 模拟加法 解决链表相加的问题，同时避免了整数溢出和性能问题。
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        StringBuilder l1Str = new StringBuilder();
        StringBuilder l2Str = new StringBuilder();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                l1Str.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                l2Str.append(l2.val);
                l2 = l2.next;
            }
        }
        Integer l1Long = Integer.valueOf(l1Str.reverse().toString());
        Integer l2Long = Integer.valueOf(l2Str.reverse().toString());
        String numberStr = new StringBuilder().append(l1Long + l2Long).reverse().toString();
        ListNode head = new ListNode(Integer.parseInt(String.valueOf(numberStr.charAt(0))));
        ListNode current = head;
        for (int i = 1; i < numberStr.length(); i++) {
            current.next = new ListNode(Integer.parseInt(String.valueOf(numberStr.charAt(i))));
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        // 用于最后一个节点存储
        ListNode(int val) {
            this.val = val;
        }

        // 如果有下一个节点用该构造器
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
