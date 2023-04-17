/*
 * In this assignment, you will implement code to model a problem tree structure domain of your choice,
 * whether it be an org chart, a restaurant menu (appetizers, main dishes, salads, desserts, etc),
 * group-types of animals, etc.
 * My take was types of sneks (https://www.youtube.com/watch?v=0arsPXEaIUY).
 *
 * R Stone
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingConstants;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.model.mxGeometry;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxPoint;
import com.mxgraph.util.mxRectangle;
import com.mxgraph.view.mxGraph;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
public class JGraphX2 extends JFrame
{

    private static final long serialVersionUID = -2707712944901661771L;
    SimpleTreeNode<String> root = createSimpleTreeNode();

    public void fillGraphFromModel( mxGraph graph)  {
        //   graphUpdate();

        Object parent = graph.getDefaultParent();

        graph.getModel().beginUpdate();

        try
        {
            Object vRoot = graph.insertVertex(parent, null, createSimpleTreeNode().getData(), 80, 00, 80, 30);

            CreateGraphPoints(graph, parent, vRoot, createSimpleTreeNode());
            mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
            layout.setUseBoundingBox(false);
            layout.execute(parent);
        }
        finally
        {
            graph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(graph);
    }

    public void CreateGraphPoints(mxGraph graph, Object parent, Object vRoot, SimpleTreeNode<String> parentNode)
    {
        for(SimpleTreeNode child : parentNode.getChildren())
        {
            Object meRoot = graph.insertVertex(parent, null, child.getData(), 80, 0, 80, 30);
            graph.insertEdge(parent, null, "", vRoot, meRoot);


            if(child.childCount() > 0)
            {
                // Recursively draw nodes
                CreateGraphPoints(graph, parent, meRoot, child);
            }
        }
    }


    public JGraphX2()
    {
        super("Simple Tree Node");
        mxGraph graph = new mxGraph();
        fillGraphFromModel(graph);
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        getContentPane().add(graphComponent);


    }


    public SimpleTreeNode<String> createSimpleTreeNode() {
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
        return root;
    }


    public static void main(String[] args)
    {
        JGraphX2 frame = new JGraphX2();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 420);
        frame.setVisible(true);
    }

}