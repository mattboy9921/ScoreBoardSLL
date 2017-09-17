public class SingleLinkedList {

    private Node list;

    public SingleLinkedList() {
        list = null;
    }

    public void addNode(Score s) {
        Node newNode = new Node(s);
        Node current = list;
        if (list == null){
            list = newNode;
        }
        else if (newNode.data.getScore() >= current.data.getScore()){
            list = newNode;
            newNode.next = current;
            if (countNodes(list) > 10) {
                removeLastNode();
            }
        }
        else {
            while (current.next != null && newNode.data.getScore() <= current.next.data.getScore()){
                current = current.next;
            }
            if (current.next == null) {
                if (countNodes(list) < 10) {
                    current.next = newNode;
                    System.out.println("List less than 10.");
                }
            }
            else {
                newNode.next = current.next;
                current.next = newNode;
                if (countNodes(list) > 10) {
                    removeLastNode();
                }
            }
        }
    }

    private Node findNode(Score s) {
        Node current = list;
        if (list == null) {
            return list;
        }
        else {
            while (current.data.getScore() != s.getScore()) {
                current = current.next;
            }
            return current;
        }
    }

    public void removeNode(Node n) {
        Node current = list;
        Node previous = list;
        while (n != current) {
            previous = current;
            current = current.next;
        }
        if (current != null) previous.next = current.next;

    }

    public void removeLastNode() {
        Node current = list;
        Node previous = list;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }
    public void addFront(Score s){
        Node frontNode = new Node(s);
        frontNode.next = list;
        list = frontNode;
    }

    public void addTail(Score s) {
        Node tailNode = new Node(s);
        Node current = list;
        if (list == null){
            list = tailNode;
        }else{
            while (current.next != null){
                current = current.next;
            }
            current.next = tailNode;
        }
    }


    public Score topScore(){
        Node current = list.next;
        Score bestStudent = list.data;
        while (current != null){
            if (current.data.getScore() > bestStudent.getScore()){
                bestStudent = current.data;
            }
            current = current.next;
        }
        return bestStudent;
    }

    public void printLinkedList(){
        Node current = list;
        int count = 1;
        while (current != null){
            System.out.println(count + ": " + current.data.getScore());
            current = current.next;
            count++;
        }
    }

    public int countNodes(Node list){
        if (list.next == null) {
            return 1;
        }else{
            return countNodes(list.next) + 1;
        }
    }

    public Score worstStudentRec(Node list){
        if (list.next == null){
            return list.data;
        }else{
            Score s = worstStudentRec(list.next);
            if (s.getScore() < list.data.getScore()){
                return s;
            }else{
                return list.data;
            }
        }
    }



    public Node getList(){
        return list;
    }

    private class Node{

        public Score data;
        private Node next;

        public Node(Score s){
            data = s;
            next = null;
        }
    }
}