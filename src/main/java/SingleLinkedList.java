public class SingleLinkedList {
    private Node list;

    public SingleLinkedList(){
        list = null;
    }

    public void addFront(Score s){
        Node frontNode = new Node(s);
        frontNode.next = list;
        list = frontNode;
    }

    public void addTail(Score s){
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

    public Score bestStudent(){
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
        while (current != null){
            System.out.println(current.data.toString());
            current = current.next;
        }
    }

    public int countNodesRec(Node list){
        if (list.next == null) {
            return 1;
        }else{
            return countNodesRec(list.next) + 1;
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

    public void addInOrder(Score s){
        Node newNode = new Node(s);
        Node current = list;
        if (list == null){
            list = newNode;
        }else if (newNode.data.getScore() < current.data.getScore()){
            list = newNode;
            newNode.next = current;
        }else{
            while (current.next != null && newNode.data.getScore() > current.next.data.getScore()){
                current = current.next;
            }
            if (current.next == null){
                current.next = newNode;
            }else{
                newNode.next = current.next;
                current.next = newNode;
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