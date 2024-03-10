class LinkedList {
    Node head;

    // Insertion at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insertion at the end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // Insertion at a given location in a sorted list
    public void insertSorted(int data) {
        Node newNode = new Node(data);
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Deletion of the first node
    public void deleteFirstNode() {
        if (head != null) {
            head = head.next;
        }
    }

    // Deletion of the last node
    public void deleteLastNode() {
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node secondLast = head;
            while (secondLast.next.next != null) {
                secondLast = secondLast.next;
            }
            secondLast.next = null;
        }
    }

    // Splitting the list into two sub-lists
    public void frontBackSplit(LinkedList frontList, LinkedList backList) {
        if (head == null || head.next == null) {
            frontList.head = head;
            backList.head = null;
            return;
        }
        Node slow = head;
        Node fast = head.next;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        frontList.head = head;
        backList.head = slow.next;
        slow.next = null;
    }

    // Merge two sorted lists
    public static LinkedList mergeSortedLists(LinkedList listA, LinkedList listB) {
        Node dummyHead = new Node(0);
        Node tail = dummyHead;
        Node a = listA.head;
        Node b = listB.head;
        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a == null) ? b : a;
        LinkedList result = new LinkedList();
        result.head = dummyHead.next;
        return result;
    }

    // Utility method to print list contents
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Utility method to sort the list
    public void sortList() {
        head = mergeSort(head);
    }

    private Node mergeSort(Node h) {
        if (h == null || h.next == null) {
            return h;
        }
        Node middle = getMiddle(h);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(nextOfMiddle);
        return sortedMerge(left, right);
    }

    private Node sortedMerge(Node a, Node b) {
        Node result;
        if (a == null) return b;
        if (b == null) return a;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private Node getMiddle(Node h) {
        if (h == null) return null;
        Node fastptr = h.next;
        Node slowptr = h;
        while (fastptr != null) {
            fastptr = fastptr.next;
            if (fastptr != null) {
                slowptr = slowptr.next;
                fastptr = fastptr.next;
            }
        }
        return slowptr;
    }
}
