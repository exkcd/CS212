/*
 * In this assignment, you will implement code to model a problem tree structure domain of your choice,
 * whether it be an org chart, a restaurant menu (appetizers, main dishes, salads, desserts, etc),
 * group-types of animals, etc.
 * My take was types of sneks (https://www.youtube.com/watch?v=0arsPXEaIUY).
 *
 * R Stone
 */

import java.util.*;

public class SimpleTreeNode<T>{
    private T data = null;  // name or other data about node
    private List<SimpleTreeNode> children = new ArrayList<>();
    private SimpleTreeNode parent = null;

    public SimpleTreeNode(T data) {
        this.data = data;
    }

    public void addChild(SimpleTreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        SimpleTreeNode<T> newChild = new SimpleTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<SimpleTreeNode> children) {
        for(SimpleTreeNode t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<SimpleTreeNode> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(SimpleTreeNode parent) {
        this.parent = parent;
    }

    public SimpleTreeNode getParent() {
        return parent;
    }

    public  String getParents(SimpleTreeNode node)
    {
        Deque stack = new LinkedList<SimpleTreeNode>();
        String path="";
        SimpleTreeNode parentNode = node.getParent();
        while (parentNode != null)
        {
            stack.push(parentNode);
            parentNode = parentNode.getParent();
        }
        Iterator<SimpleTreeNode> itr = stack.iterator();
        while (itr.hasNext()) {
            path = path + ((SimpleTreeNode) itr.next()).data + ":";
        }
        return path;
    }

    public int childCount()
    {
        return (int)getChildren().stream().count();
    }

    //  Recursive methods to print multi-level tree
    public void printChildren(SimpleTreeNode node) {
        if (node.parent != null) {
            if (node.children.size() == 0) {
                System.out.println(node.getParents((SimpleTreeNode) node) + ((SimpleTreeNode) node).data);
            } else {
                for (Object child : node.getChildren()) {
                    System.out.println(node.getParents((SimpleTreeNode) child) + ((SimpleTreeNode) child).data);
                    for (Object childOfChild : ((SimpleTreeNode) child).getChildren())
                        printChildren((SimpleTreeNode) childOfChild);
                }
            }
        }
        //       System.out.println(node.data);
    }

    public static void main(String[] args) {
        SimpleTreeNode<String> root = new SimpleTreeNode<>("Snek");

        SimpleTreeNode<String> child1 = new SimpleTreeNode<>("Nope ropes");
        child1.addChild("Danger noodle");
        child1.addChild("Shake snek");
        child1.addChild("Cober");

        SimpleTreeNode<String> child2 = new SimpleTreeNode<>("Hurt juice snek");
        child2.addChild("Slippery tube dudes");
        child2.addChild("Hazard spaghetti");
        child2.addChild("Spicy noodles");
        child2.addChild("Caution ramen");
        child2.addChild("Murder spagurder");

        root.addChild(child1);
        root.addChild(child2);

        SimpleTreeNode<String> child3 = new SimpleTreeNode<>("Boop noodles");
        root.addChild(child3);
        child3.addChild(new SimpleTreeNode<>("Big thicc boi"));
        child3.addChild(new SimpleTreeNode<>("Slim boi"));
        child3.addChild(new SimpleTreeNode<>("Judgemental shoelace"));
        child3.addChild(new SimpleTreeNode<>("Original snek"));
        child3.addChild(new SimpleTreeNode<>("Uggo but still lovable snek"));
        child3.addChild(new SimpleTreeNode<>("Screaming worm boi"));
        child3.addChild(new SimpleTreeNode<>("Noodle ball"));

        for (SimpleTreeNode child: root.getChildren()) {
            root.printChildren(child);
        }
    }
}
