package P2;

//You are given two non-empty linked lists representing two non-negative integers.
//The digits are stored in reverse order and each of their nodes contain a single digit.
//Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//      Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//      Output: 7 -> 0 -> 8
//      Explanation: 342 + 465 = 807.

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class P2 {
    public static void main(String[] args){
        Solution solution = new Solution();
        ListNode result = solution.addTwoListNodes(createListNode(new int[] {2,4,3}), createListNode(new int[] {5,6,4}));
        displayListNode(result);
    }

    public static ListNode createListNode(int[] values){
        ListNode firstNode = new ListNode(values[0]);
        ListNode previousNode = firstNode;
        for(int i=1;i<values.length;i++){
            ListNode listNode = new ListNode(values[i]);
            previousNode.next = listNode;
            previousNode = previousNode.next;
        }
        return firstNode;
    }

    public static void displayListNode(ListNode listNode){
        while(listNode.next != null){
            System.out.print(listNode.val);
            listNode=listNode.next;
        }
        System.out.println(listNode.val);
    }
}

class Solution {
    public ListNode addTwoListNodes(ListNode l1, ListNode l2){
        ListNode solution,previousNode,firstNode;

        int sum = l1.val + l2.val;
        int counter = 0;

        if(sum > 9){
            sum = sum % 10;
            counter = 1;
        }
        firstNode = previousNode = new ListNode(sum);

        l1 = l1.next;
        l2 = l2.next;

        while(l1 != null && l2 != null){

            //Calculate sum and counter
            if(counter == 1){
                sum = l1.val + l2.val + 1;
                if(sum > 9){
                    sum = sum%10;
                    counter = 1;
                } else {
                    counter = 0;
                }
            } else {
                sum = l1.val + l2.val;
                if(sum > 9){
                    sum = sum%10;
                    counter = 1;
                } else {
                    counter = 0;
                }
            }

            solution = new ListNode(sum);
            previousNode.next = solution;
            previousNode = solution;

            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 == null && l2 == null){
            if(counter == 1){
                solution = new ListNode(counter);
                previousNode.next = solution;
            }
        } else if(l2 == null){
            previousNode.next = l1;
            if(counter == 1){
                finishList(l1);
            }
        } else if(l1 == null){
            previousNode.next = l2;
            if(counter == 1){
                finishList(l2);
            }

        }
        return firstNode;
    }
    public void finishList(ListNode listNode){
        int counter = 1;
        if(listNode.next == null){
            listNode.val ++;
            if (listNode.val > 9) {
                listNode.val = listNode.val % 10;
                ListNode listNode1 = new ListNode(1);
                listNode.next = listNode1;
            }
        }
        else{
            while( listNode.next != null) {
                listNode.val ++;
                if (listNode.val > 9) {
                    listNode.val = listNode.val % 10;
                    listNode = listNode.next;
                }
                else {
                    counter = 0;
                    break;
                }
            }
            if(counter == 1){
                listNode.val ++;
                if (listNode.val > 9) {
                    listNode.val = listNode.val % 10;
                    ListNode listNode1 = new ListNode(1);
                    listNode.next = listNode1;
                }
            }
        }
    }

    //Does not work because long is too small
    public ListNode alternativeSolution(ListNode l1, ListNode l2) {
        long n1=0,n2=0;

        ListNode pointer = l1;
        int counter = 0;
        while(pointer.next != null){
            n1 += pointer.val * Math.pow(10,counter);
            pointer = pointer.next;
            counter++;
        }
        n1 += pointer.val * Math.pow(10,counter);

        pointer = l2;
        counter = 0;
        while(pointer.next != null){
            n2 += pointer.val * Math.pow(10,counter);
            pointer = pointer.next;
            counter++;
        }
        n2 += pointer.val * Math.pow(10,counter);

        System.out.println(n1);
        System.out.println(n2);

        long n3 = n1+n2;

        ListNode ln = new ListNode( Math.toIntExact(n3%10) );
        ListNode previousNode = null;
        counter = 0;
        while(n3 != 0){

            if(counter == 0)
            {
                ListNode newNode = ln;

                if(previousNode != null)
                    previousNode.next = newNode;
                previousNode = newNode;
                n3 = n3 / 10;
            }
            else{
                ListNode newNode = new ListNode(Math.toIntExact(n3%10));

                if(previousNode != null)
                    previousNode.next = newNode;
                previousNode = newNode;
                n3 = n3 / 10;
            }
            counter++;
        }

        return ln;
    }
}