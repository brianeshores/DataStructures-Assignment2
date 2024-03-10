public class Main {
    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.insertAtEnd(5);
        list.insertAtBeginning(3);
        list.insertAtEnd(7);
        list.insertSorted(2);
        list.insertSorted(11);
        System.out.println("Original List:");
        list.printList();

        list.deleteFirstNode();
        list.deleteLastNode();
        System.out.println("List after deleting first and last node:");
        list.printList();

        LinkedList list2 = new LinkedList();
        list2.insertAtEnd(2);
        list2.insertAtEnd(3);
        list2.insertAtEnd(5);
        list2.insertAtEnd(7);
        list2.insertAtEnd(11);

        System.out.println("List before front back split:");
        list2.printList();

        LinkedList frontList = new LinkedList();
        LinkedList backList = new LinkedList();
        list2.frontBackSplit(frontList, backList);
        System.out.println("Front List:");
        frontList.printList();
        System.out.println("Back List:");
        backList.printList();

        LinkedList listA = new LinkedList();
        listA.insertAtEnd(40);
        listA.insertAtEnd(30);
        listA.insertAtEnd(50);
        listA.sortList();

        LinkedList listB = new LinkedList();
        listB.insertAtEnd(80);
        listB.insertAtEnd(40);
        listB.insertAtEnd(60);
        listB.sortList();

        LinkedList mergedList = LinkedList.mergeSortedLists(listA, listB);
        System.out.println("Merged and Sorted List:");
        mergedList.printList();
    }
}