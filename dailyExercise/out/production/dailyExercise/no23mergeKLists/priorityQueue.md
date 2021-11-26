# 优先级队列

放入`PriorityQueue`的元素，必须实现`Comparable`接口，`PriorityQueue`会根据元素的排序顺序决定出队的优先级。

实现Comparable接口：

```java
public class Solution {
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;
        Status(int val,ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }
        @Override
        public int compareTo(Status o) {
            return this.val-o.val;
        }
    }
    PriorityQueue<Status> queue = new PriorityQueue<Status>();
    public ListNode mergeKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                queue.add(new Status(lists[i].val,lists[i]));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            Status f = queue.poll();
            tail.next = f.ptr;
            if(f.ptr.next!=null){
                queue.offer(new Status(f.ptr.next.val,f.ptr.next));
            }
        }
        return head.next;
    }
}
    
```

也可以用lambda表达式表示元素之间的关系：

```java
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>((x,y) ->x.val-y.val);
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail= tail.next;
            if(tail.next!=null){
                queue.offer(tail.next);
            }
        }
        return head.next;
    }
```

如果我们要放入的元素并没有实现`Comparable`接口怎么办？`PriorityQueue`允许我们提供一个`Comparator`对象来判断两个元素的顺序。我们以银行排队业务为例，实现一个`PriorityQueue`：

```java
public class Main {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            // 如果两人的号都是A开头或者都是V开头,比较号的大小:
            return u1.number.compareTo(u2.number);
        }
        if (u1.number.charAt(0) == 'V') {
            // u1的号码是V开头,优先级高:
            return -1;
        } else {
            return 1;
        }
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}

```

